package com.shahin.stream.data.media

import androidx.lifecycle.LiveData
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.shahin.stream.models.Media

interface MediaRepository {
    val currentMedia: LiveData<MediaItem>
    val currentPlaylist: LiveData<MutableList<MediaItem>>

    suspend fun setCurrentMediaItem(media: Media)
    suspend fun setCurrentPlaylist(medias: List<Media>)

    fun getMediaPlayer(): SimpleExoPlayer
}