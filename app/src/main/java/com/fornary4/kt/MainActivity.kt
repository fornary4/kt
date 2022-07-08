package com.fornary4.kt


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private val responseText: TextView by lazy {
        findViewById(R.id.response_text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_send).setOnClickListener {
            sendRequestWithHttpURLConnection()
        }

    }

    private fun sendRequestWithHttpURLConnection() {
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("http://119.91.60.142")
                    .build()
                val response = client.newCall(request).execute()
                val resultData = response.body?.string()
                if (resultData != null) {
                    showResponse(resultData)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun showResponse(response: String) {
        runOnUiThread {
            responseText.text = response
        }
    }


}