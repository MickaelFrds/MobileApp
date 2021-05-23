package com.example.mobileapp.api

import com.example.mobileapp.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() }

    val api: ApiBook by lazy {
        retrofit.create(ApiBook::class.java)
    }
}