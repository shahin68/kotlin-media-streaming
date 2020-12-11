package com.shahin.stream

import androidx.multidex.MultiDexApplication
import com.shahin.stream.di.appModule
import com.shahin.stream.di.localModule
import com.shahin.stream.di.mediaModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                localModule,
                mediaModule,
                appModule
            )
        }

    }

}