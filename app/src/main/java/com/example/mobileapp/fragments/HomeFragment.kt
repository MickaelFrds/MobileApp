package com.example.mobileapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapp.R
import com.example.mobileapp.Restaurant
import com.example.mobileapp.adapter.RestaurantAdapter

class HomeFragment :Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container,false)

        val restaurantList = arrayListOf<Restaurant>()
        restaurantList.add(
            Restaurant(
                "AA",
                "dd",
                "ss",
                "14h",
                "",
                false
        ))
        restaurantList.add(
            Restaurant(
                "BB",
                "dd",
                "ss",
                "14h",
                "",
                false
            ))

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = RestaurantAdapter(R.layout.item_horizontal_restaurant,restaurantList)

        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter =RestaurantAdapter(R.layout.item_vertical_restaurant,restaurantList)

        return view

    }
}