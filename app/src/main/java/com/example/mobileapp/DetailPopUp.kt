package com.example.mobileapp

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mobileapp.adapter.BookAdapter
import com.example.mobileapp.model.Book




class DetailPopUp (
    private val adapter : BookAdapter,
    private val currentBook : Book
): Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.fragment_detail)
        setupComponents()
    }

    private fun setupComponents() {
        val bookImage = findViewById<ImageView>(R.id.image_item)
        Glide
            .with(context)
            .load("https:"+currentBook.picture.url)
            .centerCrop()
            .into(bookImage)
        findViewById<TextView>(R.id.text_title_book).text = currentBook.title
        findViewById<TextView>(R.id.text_last_Update).text = currentBook.last_update
        findViewById<TextView>(R.id.text_Type).text = currentBook.type
    }
}