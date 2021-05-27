package com.example.programmingexercise_clr.model


import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ShoppingApi {
    @GET("/users/{username}")
    fun getUserAccount(@Path("username") username: String): Observable<Response<ShoppingBag>>
}