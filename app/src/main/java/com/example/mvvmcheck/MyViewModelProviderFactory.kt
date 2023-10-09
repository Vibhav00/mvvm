package com.example.mvvmcheck

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelProviderFactory(
    val app: Application,
    val catRepository: CatRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelMy( catRepository,app) as T
    }
}