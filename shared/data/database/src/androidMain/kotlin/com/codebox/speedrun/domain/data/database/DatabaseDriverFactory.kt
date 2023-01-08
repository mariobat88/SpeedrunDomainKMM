package com.codebox.speedrun.domain.data.database

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver{
        return AndroidSqliteDriver(SpeedrunDomainDatabase.Schema, context, "SpeedrunDomainDatabase.db")
    }
}
