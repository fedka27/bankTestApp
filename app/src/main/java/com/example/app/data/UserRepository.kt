package com.example.app.data

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random

class UserRepository(private val context: Context) {

    suspend fun login(username: String, password: String) {
        // Simulate network delay
        Thread.sleep(1000)
        val tokenGenerated = generateTokenOrError()
        /* TODO save token */
    }

    private fun generateTokenOrError(): String {
        return Random.nextBoolean().takeIf { it }
            ?.let { "JWTLToken" }
            ?: error("Error")
    }
} 