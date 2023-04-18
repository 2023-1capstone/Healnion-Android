package com.cookandroid.healnion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        startLoding()
    }

    private fun startLoding() {
        val handler = Handler()
        handler.postDelayed({finish()}, 3000)
    }



}