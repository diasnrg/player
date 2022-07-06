package com.example.player

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.MediaPlayer
import android.os.IBinder

class PlayerService : Service() {
    private var player: MediaPlayer? = null

    companion object {
        const val PLAYER_ACTION_KEY = "PLAYER_ACTION_KEY"
        const val PLAYER_KEY = "PLAYER_KEY"
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this, R.raw.never_gonna_give_you_up)
        registerReceiver(broadcastReceiver, IntentFilter(PLAYER_ACTION_KEY))
        player?.start()
        return super.onStartCommand(intent, flags, startId)
    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val key = intent?.getStringExtra(PLAYER_KEY)
            if (key == "PLAY") {
                player?.start()
            } else {
                player?.pause()
            }
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        player?.release()
        player = null
        super.onDestroy()
    }
}