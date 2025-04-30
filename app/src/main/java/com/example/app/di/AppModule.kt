package com.example.app.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Presentation layer
    viewModel { LoginViewModel(get()) }
} 