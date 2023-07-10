package com.example.cheqq.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.cheqq.R
import com.example.cheqq.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val newsNavHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment)
        //binding.bottomNavigationView.setupWithNavController(binding.flFragment.findViewById(R.id.bottomNavigationView).f)
        if (newsNavHostFragment != null) {
            binding.bottomNavigationView.itemIconTintList = null
            binding.bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
        }

    }
}