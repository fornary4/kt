package com.fornary4.kt


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView

class ThirdActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        videoView = findViewById(R.id.vv)




        findViewById<Button>(R.id.play).setOnClickListener {
            if (!videoView.isPlaying) {
                videoView.start()
            }
        }

        findViewById<Button>(R.id.pause).setOnClickListener {
            if (videoView.isPlaying) {
                videoView.pause()
            }
        }

        findViewById<Button>(R.id.replay).setOnClickListener {
            if (videoView.isPlaying) {
                videoView.resume()
            }
        }

    }



    override fun onDestroy() {
        super.onDestroy()
        videoView.suspend()
    }
}