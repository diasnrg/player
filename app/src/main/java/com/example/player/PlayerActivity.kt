package com.example.player

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.player.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlayerBinding
    private var isServiceStarted = false
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPlay.setOnClickListener {
            if (!isServiceStarted) {
                startPlayerService()
                isServiceStarted = true
            }
            isPlaying = if (isPlaying) {
                sendBroadcast(
                    Intent(PlayerService.PLAYER_ACTION_KEY).putExtra(
                        PlayerService.PLAYER_KEY,
                        "PAUSE"
                    )
                )
                false
            } else {
                sendBroadcast(
                    Intent(PlayerService.PLAYER_ACTION_KEY).putExtra(
                        PlayerService.PLAYER_KEY,
                        "PLAY"
                    )
                )
                true
            }
        }
    }

    private fun startPlayerService() {
        val intent = Intent(this, PlayerService::class.java)
        startService(intent)
    }
}
