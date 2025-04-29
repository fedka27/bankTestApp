package com.example.testbankapp.data

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    
    suspend fun login(username: String, password: String): Boolean = withContext(Dispatchers.IO) {
        // Simulate network delay
        Thread.sleep(1000)
        if (username == "user" && password == "pass") {
            sharedPreferences.edit().putString("username", username).apply()
            true
        } else {
            false
        }
    }
} 