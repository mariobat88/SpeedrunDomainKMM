package com.codebox.speedrun.android

import android.app.Application
import android.content.pm.PackageManager
import android.os.Build
import com.codebox.speedrun.domain.data.database.DatabaseDriverFactory
import com.codebox.speedrun.domain.di.AppComponent
import com.codebox.speedrun.domain.di.AppComponentImpl
import com.codebox.speedrun.domain.di.SpeedrunApplicationEntryPoint

class SpeedrunApplication : Application(), SpeedrunApplicationEntryPoint {

    override var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponentImpl(versionName, DatabaseDriverFactory(this))
    }

    private val versionName by lazy {
        val packageInfo = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            applicationContext.packageManager.getPackageInfo(
                packageName,
                PackageManager.PackageInfoFlags.of(0)
            )
        } else {
            @Suppress("DEPRECATION") applicationContext.packageManager.getPackageInfo(
                packageName,
                0
            )
        }
        packageInfo.versionName
    }
}
