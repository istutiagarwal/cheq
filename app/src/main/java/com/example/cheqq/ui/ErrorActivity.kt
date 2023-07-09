package com.example.cheqq.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import com.example.cheqq.R
import com.example.cheqq.databinding.ActivityErrorBinding
import com.example.cheqq.databinding.FragmentRewardBinding

class ErrorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityErrorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_error)
        binding.errorStateImage.setOnClickListener {
            finish()
        }
    }
}