package com.example.player

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.player.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNavigatePlayer.setOnClickListener{
            navigateToPlayerActivity()
        }
    }

    private fun navigateToPlayerActivity() {
        val intent = Intent(this, PlayerActivity::class.java) // what the f the :: mean here ???
        startActivity(intent)
    }
}