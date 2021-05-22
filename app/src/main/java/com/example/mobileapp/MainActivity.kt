package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileapp.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //injecter un fragment dans la boite (fragment_container)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,HomeFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}