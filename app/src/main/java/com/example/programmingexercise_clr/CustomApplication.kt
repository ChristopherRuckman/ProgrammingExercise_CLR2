package com.example.programmingexercise_clr

import android.app.Application
import com.example.programmingexercise_clr.di.component.CustomComponent
import com.example.programmingexercise_clr.di.component.DaggerCustomComponent
import com.example.programmingexercise_clr.di.module.ModuleApplication
import com.example.programmingexercise_clr.di.module.NetworkModule
import com.example.programmingexercise_clr.di.module.RepositoryModule
import com.example.programmingexercise_clr.di.module.UserViewModelModule

class CustomApplication: Application() {

    companion object{
        lateinit var component: CustomComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerCustomComponent.builder()
            .moduleApplication(ModuleApplication(this))
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .userViewModelModule(UserViewModelModule())
            .build()
    }
}