package com.example.android3homework2mc5.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android3homework2mc5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
