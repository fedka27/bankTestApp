package com.example.testbankapp.domain

import com.example.testbankapp.data.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserUseCase(private val userRepository: UserRepository) {
    suspend fun login(username: String, password: String): Flow<Boolean> = flow {
        val result = userRepository.login(username, password)
        emit(result)
    }
} 