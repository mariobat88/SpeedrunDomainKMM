package com.codebox.speedrun.domain.data.database

import com.codebox.speedrun.domain.data.database.dao.CategoryDao

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = SpeedrunDomainDatabase(databaseDriverFactory.createDriver())

    fun categoryDao(): CategoryDao = CategoryDao(database)
}
