package com.fornary4.kt


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fornary4.kt.entity.App
import com.fornary4.kt.http.HttpCallbackListener
import com.fornary4.kt.parser.ContentHandler
import com.fornary4.kt.util.HttpUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import org.json.JSONArray
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.StringReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.SAXParserFactory
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private val responseText: TextView by lazy {
        findViewById(R.id.response_text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_send).setOnClickListener {
            HttpUtil.sendOKHttpRequest("http://119.91.60.142/jsonDataTest.json", object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    val responseData = response.body?.string()
                    parseJSON(responseData.toString())
                }

            })
        }
    }

    private fun sendRequestWithHttpURLConnection() {
        thread {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("http://119.91.60.142/jsonDataTest.json")
                    .build()
                val response = client.newCall(request).execute()
                val resultData = response.body?.string()
                if (resultData != null) {
                    parseJSON(resultData)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun parseJSON(jsonData: String) {
        try {
            val gson = Gson()
            val appList =
                gson.fromJson<List<App>>(jsonData, object : TypeToken<List<App>>() {}.type)
            for (app in appList) {
                Log.d("forntag", app.toString())
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}