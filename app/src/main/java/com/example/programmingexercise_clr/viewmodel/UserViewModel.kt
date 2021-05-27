package com.example.programmingexercise_clr.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.programmingexercise_clr.model.RepositoryImpl
import com.example.programmingexercise_clr.model.ShoppingBag

private const val TAG = "UserViewModel"
class UserViewModel(private val repositoryImpl: RepositoryImpl): ViewModel() {


    private val _data = MutableLiveData<ShoppingBag>()
    val data: LiveData<ShoppingBag>
    get() = _data

    fun queryData(){
        repositoryImpl.loadGithubAccount(::updateData, ::showError)
    }

    private fun updateData(shoppingBag: ShoppingBag?) {
        _data.value = shoppingBag
    }

    private fun showError(errorMessage: String) {
        Log.d(TAG, "showError: $errorMessage")
    }
}
