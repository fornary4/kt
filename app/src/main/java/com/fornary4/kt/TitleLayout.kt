package com.fornary4.kt

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.titlebar, this)
        findViewById<Button>(R.id.title_back).setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
        findViewById<Button>(R.id.title_edit).setOnClickListener {
            Toast.makeText(context, "You edit!", Toast.LENGTH_SHORT).show()
        }
    }
}