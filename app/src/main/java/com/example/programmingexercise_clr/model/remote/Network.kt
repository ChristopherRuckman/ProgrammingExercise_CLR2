package com.example.programmingexercise_clr.model.remote

import android.app.Application
import com.example.programmingexercise_clr.model.ShoppingApi
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class Network(private val application: Application) {


    private val networkCacheInterceptor = Interceptor { chain ->
        val response = chain.proceed(chain.request())

        var cacheControl = CacheControl.Builder()
            .maxAge(1, TimeUnit.MINUTES)
            .build()

        response.newBuilder()
            .header("Cache-Control", cacheControl.toString())
            .build()
    }

    // Create the logging interceptor
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Create the httpClient, configure it
    // with cache, network cache interceptor and logging interceptor
    private val cache = okhttp3.Cache(
        directory = File(application.cacheDir, "http_cache"),
        maxSize = 50L * 1024L * 1024L
    )

    private val httpClient = OkHttpClient.Builder()
        .cache(cache)
        .addNetworkInterceptor(networkCacheInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    private val baseUrl: String = "https://www.dsw.com/api/v1/bag/"

    // Create the Retrofit with the httpClient
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(httpClient)
        .build()

    // Build the shopping API with Retrofit and do the network request
    val shoppingApi = retrofit.create(ShoppingApi::class.java)
}