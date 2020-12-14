package com.shahin.stream.di

import com.shahin.stream.data.sources.youtube.YouTubeRepository
import com.shahin.stream.data.sources.youtube.YouTubeRepositoryImpl
import org.koin.dsl.module

val youTubeModule = module {
    factory<YouTubeRepository> { YouTubeRepositoryImpl() }
}