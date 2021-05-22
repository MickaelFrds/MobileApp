package com.example.mobileapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mobileapp.R
import com.example.mobileapp.Restaurant

class RestaurantAdapter (
    private val layoutId : Int,
    private val restaurantList : List<Restaurant>
    ) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {


    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val restaurantImage =view.findViewById<ImageView>(R.id.image_item)
        val restaurantName = view.findViewById<TextView>(R.id.name_restaurant)
        //val restaurantLiked = view.findViewById<TextView>(R.id.unlike_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId,parent ,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentRestaurant =restaurantList[position]

        Glide
            .with(context)
            .load(currentRestaurant.imagePrincipal)
            .centerCrop()
            .into();

    }

    override fun getItemCount(): Int =restaurantList.size
}