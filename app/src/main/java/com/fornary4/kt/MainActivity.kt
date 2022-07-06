package com.fornary4.kt

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_submit).setOnClickListener {
            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString("name", "Tom")
            editor.putInt("age", 20)
            editor.putBoolean("married", false)
            editor.apply()
        }

        findViewById<Button>(R.id.btn_read).setOnClickListener {
            val pref = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name = pref.getString("name", "")
            val age = pref.getInt("age", 0)
            val married = pref.getBoolean("married", false)

            Log.d("forntag", "name is $name")
            Log.d("forntag", "age is $age")
            Log.d("forntag", "married is $married")
        }
    }


}