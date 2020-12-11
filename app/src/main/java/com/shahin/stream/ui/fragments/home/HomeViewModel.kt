package com.shahin.stream.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.shahin.stream.data.media.MediaRepository
import com.shahin.stream.mediaplayer.MediaEventListener
import com.shahin.stream.mediaplayer.MediaPlayer
import com.shahin.stream.models.Media
import kotlinx.coroutines.launch

class HomeViewModel(
    private val mediaRepository: MediaRepository,
) : ViewModel() {

    val currentMedia = mediaRepository.currentMedia

    fun play(media: Media) {
        viewModelScope.launch {
            mediaRepository.playMedia(media)
        }
    }

    fun getExoPlayer(): SimpleExoPlayer {
        return mediaRepository.getMediaPlayer()
    }

    fun registerMediaPlayerListener(mediaEventListener: MediaEventListener) {
        mediaRepository.attachMediaPlayerListener(mediaEventListener)
    }

    fun unregisterMediaPlayerListener(mediaEventListener: MediaEventListener) {
        mediaRepository.detachMediaPlayerListener(mediaEventListener)
    }
}