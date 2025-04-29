package com.example.testbankapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testbankapp.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userRepository: UserRepository
) : ViewModel() {

    var loginState by mutableStateOf<LoginState>(LoginState.Initial)
        private set

    fun login(username: String, password: String) {
        viewModelScope.launch {
            loginState = LoginState.Loading
            try {
                val result = userRepository.login(username, password)
                loginState = if (result) {
                    LoginState.Success
                } else {
                    LoginState.Error("Invalid credentials")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun checkLoginStatus() {
        _loginState.value = if (userRepository.isLoggedIn()) {
            LoginState.Success
        } else {
            LoginState.Initial
        }
    }
}

sealed class LoginState {
    object Initial : LoginState()
    object Loading : LoginState()
    object Success : LoginState()
    class Error(val message: String) : LoginState()
} 