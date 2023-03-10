package com.example.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.mShopList.observe(this){
            Log.d("MainActivity",it.toString())
        }
    }
}