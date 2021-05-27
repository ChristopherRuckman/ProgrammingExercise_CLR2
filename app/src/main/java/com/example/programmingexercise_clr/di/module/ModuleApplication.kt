package com.example.programmingexercise_clr.di.module

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class ModuleApplication(private val application: Application) {

    @Provides
    fun provideApplication(): Application{
        return application
    }
}