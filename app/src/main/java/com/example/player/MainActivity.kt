package com.example.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnClick.setOnClickListener{
            onClick()
        }
    }

    private fun onClick() {
        counter++
        binding.tvCounts.text = counter.toString()
    }
}