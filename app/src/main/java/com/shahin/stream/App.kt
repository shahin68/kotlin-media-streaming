package com.shahin.stream

import android.app.Application
import com.shahin.stream.di.homeModule
import com.shahin.stream.di.localModule
import com.shahin.stream.di.mediaModule
import com.shahin.stream.di.mediaPlayerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                localModule,
                mediaModule,
                mediaPlayerModule,
                homeModule
            )
        }

    }

}