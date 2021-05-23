package com.example.mobileapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileapp.model.BookResponse
import com.example.mobileapp.repository.Repository
import kotlinx.coroutines.launch


class BookListViewModel(private val repository: Repository) : ViewModel() {

    val myResponse : MutableLiveData<BookResponse> = MutableLiveData()

    fun getBookList(){
        viewModelScope.launch {
            val response : BookResponse = repository.getBookList()
            myResponse.value = response
        }
    }
}