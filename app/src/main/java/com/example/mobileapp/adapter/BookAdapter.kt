package com.example.mobileapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobileapp.DetailPopUp
import com.example.mobileapp.MainActivity
import com.example.mobileapp.R
import com.example.mobileapp.model.Book

class BookAdapter (
    val context :MainActivity,
    private val layoutId : Int,
    private var bookList : List<Book>
    ) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val bookImage  =view.findViewById<ImageView>(R.id.image_item)
        val bookName : TextView?= view.findViewById(R.id.name_book)
        val bookLastUpdate: TextView?= view.findViewById((R.id.text_last_Update))
        val bookType: TextView?= view.findViewById((R.id.text_Type))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId,parent ,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val currentbook: Book=bookList[position]
        Glide
            .with(context)
            .load("https:"+currentbook.picture.url)
            .centerCrop()
            .into(holder.bookImage)
        holder.bookName?.text =currentbook.title
        holder.bookLastUpdate?.text =currentbook.last_update
        holder.bookType?.text =currentbook.type
        holder.itemView.setOnClickListener{
          DetailPopUp(this,currentbook).show()
      }
    }
    override fun getItemCount(): Int =bookList.size
}