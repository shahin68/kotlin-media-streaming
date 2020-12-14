package com.shahin.stream.mediaplayer

import com.google.android.exoplayer2.*

class MediaPlayerImpl(
    private var exoPlayer: SimpleExoPlayer?
): MediaPlayer {

    private var _currentWindow = 0
    private var _playbackPosition: Long = 0

    override fun getMediaPlayer(): SimpleExoPlayer? {
        return exoPlayer
    }

    override fun registerMediaPlayerListener(mediaEventListener: MediaEventListener) {
        exoPlayer?.addListener(mediaEventListener)
    }

    override fun unregisterMediaPlayerListener(mediaEventListener: MediaEventListener) {
        exoPlayer?.removeListener(mediaEventListener)
    }

    override fun release() {
        exoPlayer?.let {
            it.release()
            exoPlayer = null
        }
    }

    override fun resume() {
        exoPlayer?.let {
            it.seekTo(_currentWindow, _playbackPosition)
            it.prepare()
            it.play()
        }
    }

    override fun pause() {
        exoPlayer?.let {
            _playbackPosition = it.currentPosition
            _currentWindow = it.currentWindowIndex
            it.pause()
        }
    }

    override fun setAndPlaySingleMedia(
        mediaItem: MediaItem,
        currentWindow: Int,
        playbackPosition: Long
    ) {
        exoPlayer?.let {
            _currentWindow = currentWindow
            _playbackPosition = playbackPosition
            it.setMediaItem(mediaItem)
            it.seekTo(currentWindow, playbackPosition)
            it.prepare()
            it.play()
        }
    }

    override fun setAndPlayMediaPlaylist(mediaItems: List<MediaItem>) {
        exoPlayer?.let {
            it.addMediaItems(mediaItems)
            it.prepare()
            it.play()
        }
    }

    override fun moveItem(currentIndex: Int, newIndex: Int) {
        return exoPlayer?.moveMediaItem(currentIndex, newIndex) ?: Unit
    }

    override fun moveItems(fromIndex: Int, toIndex: Int, newIndex: Int) {
        return exoPlayer?.moveMediaItems(fromIndex, toIndex, newIndex) ?: Unit
    }

    override fun removeItem(index: Int) {
        return exoPlayer?.removeMediaItem(index) ?: Unit
    }

    override fun removeItems(fromIndex: Int, toIndex: Int) {
        return exoPlayer?.removeMediaItems(fromIndex, toIndex) ?: Unit
    }

    override fun replaceAllPlaylist(newItems: List<MediaItem>) {
        exoPlayer?.let {
            it.setMediaItems(newItems, true)
            it.clearMediaItems()
        }
    }

    override fun getMediaCount(): Int {
        return exoPlayer?.mediaItemCount ?: 0
    }

    override fun getMediaAt(index: Int): MediaItem? {
        return exoPlayer?.getMediaItemAt(index)
    }

    override fun getCurrentMedia(): MediaItem? {
        return exoPlayer?.currentMediaItem
    }

    override fun enableShuffle(isShuffleEnabled: Boolean) {
        exoPlayer?.shuffleModeEnabled = isShuffleEnabled
    }

    override fun isShuffleEnabled(isShuffleEnabled: Boolean): Boolean {
        return exoPlayer?.shuffleModeEnabled ?: false
    }

    override fun setShuffleOrder(mediaShuffleOrder: MediaShuffleOrder) {
        exoPlayer?.setShuffleOrder(mediaShuffleOrder)
    }
}