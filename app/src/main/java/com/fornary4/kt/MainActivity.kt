package com.fornary4.kt


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fornary4.kt.database.AppDatabase
import com.fornary4.kt.databinding.ActivityMainBinding
import com.fornary4.kt.entity.User
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        

    }






}


