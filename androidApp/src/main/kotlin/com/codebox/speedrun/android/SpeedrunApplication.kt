package com.codebox.speedrun.android

import android.app.Application
import com.codebox.speedrun.domain.di.appModule
import org.koin.core.context.startKoin

class SpeedrunApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule())
        }
    }
}