package com.shahin.stream.di

import com.shahin.stream.data.media.MediaRepository
import com.shahin.stream.data.media.MediaRepositoryImpl
import org.koin.dsl.module

val mediaModule = module {
    factory<MediaRepository> { MediaRepositoryImpl(get()) }
}