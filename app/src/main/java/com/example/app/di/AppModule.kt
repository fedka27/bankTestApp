package com.example.app.di

import com.example.app.data.UserRepository
import com.example.app.domain.UserUseCase
import com.example.app.presentation.LoginViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Data layer
    single { UserRepository(androidContext()) }

    // Domain layer
    single { UserUseCase(get()) }

    // Presentation layer
    viewModel { LoginViewModel(get()) }
} 