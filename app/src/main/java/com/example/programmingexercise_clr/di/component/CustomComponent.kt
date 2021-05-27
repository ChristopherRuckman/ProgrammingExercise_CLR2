package com.example.programmingexercise_clr.di.component

import com.example.programmingexercise_clr.di.module.ModuleApplication
import com.example.programmingexercise_clr.di.module.NetworkModule
import com.example.programmingexercise_clr.di.module.RepositoryModule
import com.example.programmingexercise_clr.di.module.UserViewModelModule
import com.example.programmingexercise_clr.view.ShoppingView
import dagger.Component

@Component(modules = [ModuleApplication::class, NetworkModule::class, RepositoryModule::class,
UserViewModelModule::class])
interface CustomComponent {
    fun inject(shoppingView: ShoppingView)
}