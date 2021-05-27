package com.example.programmingexercise_clr.model

import android.util.Log
import android.widget.Toast
import com.example.programmingexercise_clr.GithubAccount
import com.example.programmingexercise_clr.model.remote.Network
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class RepositoryImpl(private val network: Network) {

    fun loadGithubAccount(callbackSuccess: (ShoppingBag?)-> Unit, callbackError: (String)-> Unit) {
        // create a network cache interceptor, setting the max age to 1 minute

        network.shoppingApi.getUserAccount("google")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ShoppingBag>>(){ //DisposableObserver<Response<ShoppingBag>>() {
                override fun onNext(response: Response<ShoppingBag>) {

                    if (response.raw().cacheResponse != null) {
                        Log.d("Network", "response came from cache")
                    }

                    if (response.raw().networkResponse != null) {
                        Log.d("Network", "response came from server")
                    }

                    if (response.isSuccessful && response.body() != null){
                        callbackSuccess(response.body())
                    }else{
                        callbackError(response.message())
                    }

                    //Toast.makeText(applicationContext, response.body().toString(), Toast.LENGTH_SHORT).show()
                }

                override fun onComplete() {}

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
    }

}