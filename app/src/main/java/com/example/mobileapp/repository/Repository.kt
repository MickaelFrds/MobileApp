package com.example.mobileapp.repository

import com.example.mobileapp.api.RetrofitInstance
import com.example.mobileapp.model.BookResponse

class Repository {
    suspend fun getBookList(): BookResponse{
        return RetrofitInstance.api.getBookList()
    }

}