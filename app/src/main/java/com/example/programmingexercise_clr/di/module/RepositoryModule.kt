package com.example.programmingexercise_clr.di.module

import com.example.programmingexercise_clr.model.RepositoryImpl
import com.example.programmingexercise_clr.model.remote.Network
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(network: Network): RepositoryImpl{
        return RepositoryImpl(network)
    }
}