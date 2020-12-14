package com.shahin.stream.ui

import androidx.lifecycle.ViewModel
import com.shahin.stream.data.sources.media.MediaRepository
import com.shahin.stream.mediaplayer.MediaEventListener

class MainViewModel(
    private val mediaRepository: MediaRepository
): ViewModel() {

    var mediaPlayer = mediaRepository.getMediaPlayer()
    val currentMedia = mediaRepository.currentMedia

    fun releaseMediaPlayer() {
        mediaPlayer?.let {
            it.release()
            mediaPlayer = null
        }
    }

    fun registerMediaPlayerListener(mediaEventListener: MediaEventListener) {
        mediaRepository.attachMediaPlayerListener(mediaEventListener)
    }

    fun unregisterMediaPlayerListener(mediaEventListener: MediaEventListener) {
        mediaRepository.detachMediaPlayerListener(mediaEventListener)
    }

}