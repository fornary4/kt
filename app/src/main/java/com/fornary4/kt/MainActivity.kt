package com.fornary4.kt

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var downloadBinder: MyService.DownloadBinder
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            downloadBinder = service as MyService.DownloadBinder
            downloadBinder.startDownload()
            downloadBinder.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName?) {
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, MyService::class.java)

        findViewById<Button>(R.id.btn_start).setOnClickListener {
            startService(intent)
        }

        findViewById<Button>(R.id.btn_stop).setOnClickListener {
            stopService(intent)
        }

        findViewById<Button>(R.id.btn_bind).setOnClickListener {
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }

        findViewById<Button>(R.id.btn_unbind).setOnClickListener {
            unbindService(connection)
        }


    }


}