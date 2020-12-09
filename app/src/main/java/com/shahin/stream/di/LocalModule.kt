package com.shahin.stream.di

import com.shahin.stream.data.LocalRepository
import com.shahin.stream.data.LocalRepositoryImpl
import org.koin.dsl.module

val localModule = module {
    factory<LocalRepository> { LocalRepositoryImpl() }
}