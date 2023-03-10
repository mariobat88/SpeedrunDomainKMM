package com.codebox.speedrun.domain.data.database

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(SpeedrunDomainDatabase.Schema, "SpeedrunDomainDatabase.db")
    }
}
