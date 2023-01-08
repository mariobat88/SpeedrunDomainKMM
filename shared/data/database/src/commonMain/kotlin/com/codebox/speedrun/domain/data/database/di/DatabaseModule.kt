package com.codebox.speedrun.domain.data.database.di

import com.codebox.speedrun.domain.data.database.Database
import com.codebox.speedrun.domain.data.database.DatabaseDriverFactory

class DatabaseModule(
    private val databaseDriverFactory: DatabaseDriverFactory
) {

    val database by lazy {
        Database(databaseDriverFactory)
    }
}
