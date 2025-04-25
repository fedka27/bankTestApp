package com.example.testbankapp.di

import com.example.testbankapp.data.UserRepository
import com.example.testbankapp.domain.UserUseCase
import com.example.testbankapp.presentation.LoginViewModel
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