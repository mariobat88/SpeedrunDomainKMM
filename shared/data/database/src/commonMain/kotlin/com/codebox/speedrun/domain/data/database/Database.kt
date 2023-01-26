package com.codebox.speedrun.domain.data.database

import com.codebox.speedrun.domain.data.database.dao.CategoryDao
import com.codebox.speedrun.domain.data.database.dao.GameDao
import com.squareup.sqldelight.EnumColumnAdapter

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = SpeedrunDomainDatabase(
        driver = databaseDriverFactory.createDriver(),
        GameRuleSetEntityAdapter = GameRuleSetEntity.Adapter(
            defaultTimeAdapter = EnumColumnAdapter()
        )
    )

    fun categoryDao(): CategoryDao = CategoryDao(database)
    fun gameDao(): GameDao = GameDao(database)
}
