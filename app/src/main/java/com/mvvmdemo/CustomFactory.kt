package com.mvvmdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CustomFactory(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}