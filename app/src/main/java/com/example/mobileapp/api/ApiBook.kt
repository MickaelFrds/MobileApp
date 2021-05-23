package com.example.mobileapp.api

import com.example.mobileapp.model.BookResponse
import retrofit2.http.GET

interface ApiBook {
    @GET("/people/george08/lists/OL97L/seeds.json")
   suspend fun getBookList(): BookResponse
}