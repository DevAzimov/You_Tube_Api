package com.magicapp.youtubeapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment
import com.magicapp.youtubeapi.R
import com.magicapp.youtubeapi.YouTubeFailureRecoveryActivity

class YoutubeActivity : YouTubeFailureRecoveryActivity() {

    lateinit var videoId: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)

        videoId = intent.getStringExtra("video_id") ?: ""
        val fragment =
            fragmentManager.findFragmentById(R.id.youtube_fragment) as YouTubePlayerFragment
        fragment.initialize("AIzaSyDpRo2A3TbjXDleozHOPPqXiZE89oMXe1M", this)

    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        if (!p2) {
            p1?.cueVideo(videoId)
        }
    }

    override fun getYouTubePlayerProvider(): YouTubePlayer.Provider {
        return fragmentManager.findFragmentById(R.id.youtube_fragment) as YouTubePlayerFragment
    }
}