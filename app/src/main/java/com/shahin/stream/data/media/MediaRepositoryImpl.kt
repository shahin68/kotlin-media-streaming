package com.shahin.stream.data.media

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.shahin.stream.mediaplayer.MediaEventListener
import com.shahin.stream.mediaplayer.MediaPlayer
import com.shahin.stream.models.Media

class MediaRepositoryImpl(
    private val mediaPlayer: MediaPlayer
) : MediaRepository {
    private val _currentMedia: MutableLiveData<MediaItem> = MutableLiveData()
    override val currentMedia: LiveData<MediaItem>
        get() = _currentMedia

    private val _currentPlaylist: MutableLiveData<MutableList<MediaItem>> = MutableLiveData()
    override val currentPlaylist: LiveData<MutableList<MediaItem>>
        get() = _currentPlaylist

    init {
        _currentMedia.postValue(null)
        _currentPlaylist.postValue(emptyList<MediaItem>().toMutableList())
    }

    override fun getMediaPlayer(): SimpleExoPlayer {
        return mediaPlayer.getMediaPlayer()
    }

    override suspend fun playMedia(media: Media) {
        val item = makeMediaItem(media.uri, media.id, media.tag)
        _currentMedia.postValue(item)
        mediaPlayer.setAndPlaySingleMedia(item)
    }

    override suspend fun playPlaylist(medias: List<Media>) {
        val mediaItems = mutableListOf<MediaItem>()
        mediaItems.addAll(
            medias.map {
                makeMediaItem(
                    it.uri,
                    it.id,
                    it.tag
                )
            }
        )
        _currentPlaylist.postValue(mediaItems)
        mediaPlayer.setAndPlayMediaPlaylist(mediaItems)
    }

    private fun makeMediaItem(uri: Uri, id: String?, tag: Any?): MediaItem {
        return MediaItem
            .Builder()
            .setUri(uri)
            .setMediaId(id)
            .setTag(tag)
            .build()
    }

    override fun attachMediaPlayerListener(mediaEventListener: MediaEventListener) {
        mediaPlayer.registerMediaPlayerListener(mediaEventListener)
    }

    override fun detachMediaPlayerListener(mediaEventListener: MediaEventListener) {
        mediaPlayer.unregisterMediaPlayerListener(mediaEventListener)
    }
}