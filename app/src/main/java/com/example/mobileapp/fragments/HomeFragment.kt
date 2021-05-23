package com.example.mobileapp.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.BookListViewFactory
import com.example.mobileapp.BookListViewModel
import com.example.mobileapp.MainActivity
import com.example.mobileapp.R
import com.example.mobileapp.adapter.BookAdapter
import com.example.mobileapp.model.Book
import com.example.mobileapp.repository.Repository


class HomeFragment (
    private val context : MainActivity
        ) :Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container,false) }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)

        var bookList: List<Book>
        val repository = Repository()
        val bookListViewFactory =BookListViewFactory(repository)
        val bookListModel : BookListViewModel = ViewModelProvider(this, bookListViewFactory).get(BookListViewModel::class.java)
        bookListModel.getBookList()

        bookListModel.myResponse.observe(this) { response ->
            bookList = response.entries
            verticalRecyclerView.adapter = BookAdapter(context, R.layout.item_vertical_book, bookList)
            horizontalRecyclerView.adapter = BookAdapter(context, R.layout.item_horizontal_book, bookList)
        }


    }
}