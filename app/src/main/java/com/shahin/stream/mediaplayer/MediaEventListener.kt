package com.shahin.stream.mediaplayer

import android.util.Log
import com.google.android.exoplayer2.ExoPlaybackException
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.TrackSelectionArray

abstract class MediaEventListener(

): Player.EventListener {

    /**
     * - reason = Player.TIMELINE_CHANGE_REASON_DYNAMIC -> This happens when the playlist
     * changes, e.g. if items are added, moved, or removed
     * @param timeline
     * @param reason
     */
    override fun onTimelineChanged(timeline: Timeline, reason: Int) {

    }

    override fun onTracksChanged(
        trackGroups: TrackGroupArray,
        trackSelections: TrackSelectionArray
    ) {

    }

    override fun onLoadingChanged(isLoading: Boolean) {

    }

    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        Log.d("MediaEventListener", " ----------------> ")
    }

    override fun onPlaybackSuppressionReasonChanged(playbackSuppressionReason: Int) {

    }

    override fun onIsPlayingChanged(isPlaying: Boolean) {

    }

    override fun onRepeatModeChanged(repeatMode: Int) {

    }

    override fun onShuffleModeEnabledChanged(shuffleModeEnabled: Boolean) {

    }

    override fun onPlayerError(error: ExoPlaybackException) {

    }

    /**
     * - reason = Player.DISCONTINUITY_REASON_PERIOD_TRANSITION -> This happens when playback automatically
     * transitions from one item to the next
     * - reason = Player.DISCONTINUITY_REASON_SEEK -> This happens when the current playback item changes
     * as part of a seek operation, for example when calling Player.next
     * @param reason --> reason = 0 (exoplayer skipped or changed automatically) - reason = 1 or 2 (exoplayer skipped manually by calling skip)
     */
    override fun onPositionDiscontinuity(reason: Int) {

    }

    override fun onPlaybackParametersChanged(playbackParameters: PlaybackParameters) {

    }

    override fun onSeekProcessed() {

    }

}