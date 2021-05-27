package com.example.programmingexercise_clr.di.module

import com.example.programmingexercise_clr.model.RepositoryImpl
import com.example.programmingexercise_clr.viewmodel.UserViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class UserViewModelModule {

    @Provides
    fun provideUserViewModelProvider(repositoryImpl: RepositoryImpl): UserViewModelProvider{
        return UserViewModelProvider(repositoryImpl)
    }
}