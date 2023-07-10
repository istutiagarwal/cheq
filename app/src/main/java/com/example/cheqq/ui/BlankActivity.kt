package com.example.cheqq.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.example.cheqq.R

class BlankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blank)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
           startActivity(Intent(this, MainActivity::class.java))
        }, 600)
    }
}