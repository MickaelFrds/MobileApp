package com.example.mobileapp.model

import com.example.mobileapp.model.Book

data class BookResponse (
 val size : Int,
 val entries : List<Book>
 )