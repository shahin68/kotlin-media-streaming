package com.shahin.stream.di

import com.google.android.exoplayer2.Player
import com.shahin.stream.data.media.MediaRepository
import com.shahin.stream.data.media.MediaRepositoryImpl
import com.shahin.stream.mediaplayer.MediaEventListener
import com.shahin.stream.ui.fragments.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel(get()) }
}
