package com.codebox.speedrun.android

import android.app.Application
import com.codebox.speedrun.domain.data.database.DatabaseDriverFactory
import com.codebox.speedrun.domain.di.AppComponentImpl
import com.codebox.speedrun.domain.di.SpeedrunApplicationEntryPoint

class SpeedrunApplication : Application(), SpeedrunApplicationEntryPoint {

    override val appComponent = AppComponentImpl(DatabaseDriverFactory(this))
}