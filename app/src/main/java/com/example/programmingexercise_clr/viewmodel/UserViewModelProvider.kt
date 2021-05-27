package com.example.programmingexercise_clr.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.programmingexercise_clr.model.RepositoryImpl

class UserViewModelProvider(private val repositoryImpl: RepositoryImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(repositoryImpl) as T
    }
}