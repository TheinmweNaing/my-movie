package com.naing.themovie.model

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

object RetrofitManager {

    const val API_KEY = "?api_key=5ef201909e461193a54344319ffe0d53"
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun <T> create(clazz: Class<T>) = retrofit.create(clazz)
}