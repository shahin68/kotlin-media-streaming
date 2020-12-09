package com.shahin.stream.ui.fragments.home

import androidx.lifecycle.ViewModel
import com.google.android.exoplayer2.SimpleExoPlayer
import com.shahin.stream.data.media.MediaRepository
import com.shahin.stream.mediaplayer.MediaPlayer

class HomeViewModel(
    private val mediaRepository: MediaRepository
) : ViewModel() {

    fun getMediaPlayer(): SimpleExoPlayer {
        return mediaRepository.getMediaPlayer()
    }
    
}