package com.shahin.stream.di

import android.content.Context
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.analytics.AnalyticsListener
import com.shahin.stream.data.sources.media.MediaRepository
import com.shahin.stream.data.sources.media.MediaRepositoryImpl
import com.shahin.stream.mediaplayer.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val mediaModule = module {
    factory<MediaRepository> { MediaRepositoryImpl(get()) }
    factory<MediaPlayer> { MediaPlayerImpl(get()) }
    single { provideSimpleExoPlayer(androidContext(), get()) }
    factory { provideMediaAnalyticsListener() }
}

private fun provideSimpleExoPlayer(
    context: Context,
    analyticsListener: AnalyticsListener
): SimpleExoPlayer {
    val exoPlayer = SimpleExoPlayer
        .Builder(context)
        .build()
    exoPlayer.addAnalyticsListener(analyticsListener)
    return exoPlayer
}

private fun provideMediaAnalyticsListener(): AnalyticsListener {
    return object: MediaAnalyticsListener() {

    }
}
