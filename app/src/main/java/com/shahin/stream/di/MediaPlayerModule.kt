package com.shahin.stream.di

import android.content.Context
import com.google.android.exoplayer2.RenderersFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.shahin.stream.mediaplayer.MediaPlayer
import com.shahin.stream.mediaplayer.MediaPlayerImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val mediaPlayerModule = module {
    factory<MediaPlayer> { MediaPlayerImpl(get()) }
    single { provideSimpleExoPlayer(androidContext(), get()) }

}

private fun provideSimpleExoPlayer(context: Context, renderersFactory: RenderersFactory): SimpleExoPlayer {
    return SimpleExoPlayer.Builder(context, renderersFactory).build()
}
