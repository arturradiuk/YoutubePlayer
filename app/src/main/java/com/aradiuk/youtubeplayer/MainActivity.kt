package com.aradiuk.youtubeplayer

import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class MainActivity : YouTubeBaseActivity() {
    var playButton: Button? = null
    private var youTubePlayerView: YouTubePlayerView? = null
    private var onInitializedListener: YouTubePlayer.OnInitializedListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.play_button)
        youTubePlayerView = findViewById(R.id.youtube_view)

        onInitializedListener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider,
                youTubePlayer: YouTubePlayer,
                b: Boolean
            ) {
                youTubePlayer.loadVideo("https://www.youtube.com/watch?v=DWcJFNfaw9c");
            }

            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider,
                youTubeInitializationResult: YouTubeInitializationResult
            ) {
            }
        }

        playButton?.setOnClickListener(View.OnClickListener {
            youTubePlayerView?.initialize("AIzaSyBNvZD7VPAchV4PsDIfJdS6o3wOmYPSEXg",onInitializedListener)
        })

    }
}