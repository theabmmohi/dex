package com.theabmmohi.dex

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = TextView(this).apply {
            text = "Hello, Android"
            textSize = 24f
            gravity = Gravity.CENTER
        }
        setContentView(view)
    }
}
