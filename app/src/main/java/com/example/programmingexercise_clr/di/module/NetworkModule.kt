package com.example.programmingexercise_clr.di.module

import android.app.Application
import com.example.programmingexercise_clr.model.remote.Network
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideNetwork(application: Application): Network{
        return Network(application)
    }
}