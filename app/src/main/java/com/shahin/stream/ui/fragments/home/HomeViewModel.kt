package com.shahin.stream.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shahin.stream.data.sources.media.MediaRepository
import com.shahin.stream.data.models.Media
import kotlinx.coroutines.launch

class HomeViewModel(
    private val mediaRepository: MediaRepository,
) : ViewModel() {

    val mediaPlayer = mediaRepository.getMediaPlayer()

    fun play(media: Media) {
        viewModelScope.launch {
            mediaRepository.playMedia(media)
        }
    }
}