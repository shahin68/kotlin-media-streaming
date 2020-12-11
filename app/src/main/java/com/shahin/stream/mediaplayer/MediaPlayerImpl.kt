package com.shahin.stream.mediaplayer

import com.google.android.exoplayer2.*

class MediaPlayerImpl(
    private val exoPlayer: SimpleExoPlayer
): MediaPlayer {

    override fun getMediaPlayer(): SimpleExoPlayer {
        return exoPlayer
    }

    override fun registerMediaPlayerListener(mediaEventListener: MediaEventListener) {
        exoPlayer.addListener(mediaEventListener)
    }

    override fun unregisterMediaPlayerListener(mediaEventListener: MediaEventListener) {
        exoPlayer.removeListener(mediaEventListener)
    }

    override fun setAndPlaySingleMedia(mediaItem: MediaItem) {
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.play()
    }

    override fun setAndPlayMediaPlaylist(mediaItems: List<MediaItem>) {
        exoPlayer.addMediaItems(mediaItems)
        exoPlayer.prepare()
        exoPlayer.play()
    }

    override fun moveItem(currentIndex: Int, newIndex: Int) {
        return exoPlayer.moveMediaItem(currentIndex, newIndex)
    }

    override fun moveItems(fromIndex: Int, toIndex: Int, newIndex: Int) {
        return exoPlayer.moveMediaItems(fromIndex, toIndex, newIndex)
    }

    override fun removeItem(index: Int) {
        return exoPlayer.removeMediaItem(index)
    }

    override fun removeItems(fromIndex: Int, toIndex: Int) {
        return exoPlayer.removeMediaItems(fromIndex, toIndex)
    }

    override fun replaceAllPlaylist(newItems: List<MediaItem>) {
        exoPlayer.setMediaItems(newItems, true)
        exoPlayer.clearMediaItems()
    }

    override fun getMediaCount(): Int {
        return exoPlayer.mediaItemCount
    }

    override fun getMediaAt(index: Int): MediaItem {
        return exoPlayer.getMediaItemAt(index)
    }

    override fun getCurrentMedia(): MediaItem? {
        return exoPlayer.currentMediaItem
    }

    override fun enableShuffle(isShuffleEnabled: Boolean) {
        exoPlayer.shuffleModeEnabled = isShuffleEnabled
    }

    override fun isShuffleEnabled(isShuffleEnabled: Boolean): Boolean {
        return exoPlayer.shuffleModeEnabled
    }

    override fun setShuffleOrder(mediaShuffleOrder: MediaShuffleOrder) {
        exoPlayer.setShuffleOrder(mediaShuffleOrder)
    }
}