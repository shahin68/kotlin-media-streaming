package com.shahin.stream.mediaplayer

import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer

interface MediaPlayer {
    fun getMediaPlayer(): SimpleExoPlayer?
    fun setAndPlaySingleMedia(mediaItem: MediaItem, currentWindow: Int = 0, playbackPosition: Long = 0)
    fun setAndPlayMediaPlaylist(mediaItems: List<MediaItem>)
    fun moveItem(currentIndex: Int, newIndex: Int)
    fun moveItems(fromIndex: Int, toIndex: Int, newIndex: Int)
    fun removeItem(index: Int)
    fun removeItems(fromIndex: Int, toIndex: Int)
    fun replaceAllPlaylist(newItems: List<MediaItem>)
    fun getMediaCount(): Int
    fun getMediaAt(index: Int): MediaItem?
    fun getCurrentMedia(): MediaItem?
    fun enableShuffle(isShuffleEnabled: Boolean)
    fun isShuffleEnabled(isShuffleEnabled: Boolean): Boolean
    fun setShuffleOrder(mediaShuffleOrder: MediaShuffleOrder)
    fun registerMediaPlayerListener(mediaEventListener: MediaEventListener)
    fun unregisterMediaPlayerListener(mediaEventListener: MediaEventListener)
    fun release()
    fun resume()
    fun pause()
}