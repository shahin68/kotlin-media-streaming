package com.shahin.stream.data.media

import androidx.lifecycle.LiveData
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.shahin.stream.mediaplayer.MediaEventListener
import com.shahin.stream.models.Media

interface MediaRepository {
    val currentMedia: LiveData<MediaItem>
    val currentPlaylist: LiveData<MutableList<MediaItem>>

    suspend fun playMedia(media: Media)
    suspend fun playPlaylist(medias: List<Media>)

    fun attachMediaPlayerListener(mediaEventListener: MediaEventListener)
    fun detachMediaPlayerListener(mediaEventListener: MediaEventListener)

    fun getMediaPlayer(): SimpleExoPlayer
}