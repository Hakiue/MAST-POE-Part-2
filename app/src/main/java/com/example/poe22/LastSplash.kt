package com.example.poe22

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


class LastSplash : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper()) // Use Looper to get the main thread
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_splash)

        runnable = Runnable {
            startActivity(Intent(this, MenuItemEntryActivity::class.java))
            finish()
        }
        handler.postDelayed(runnable, 3000) // Delay for 3 seconds
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }
}