package com.codebox.speedrun.domain.data.database

import com.codebox.speedrun.domain.data.database.dao.*
import com.squareup.sqldelight.EnumColumnAdapter

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = SpeedrunDomainDatabase(
        driver = databaseDriverFactory.createDriver(),
        GameRuleSetEntityAdapter = GameRuleSetEntity.Adapter(
            defaultTimeAdapter = EnumColumnAdapter()
        ),
        GameRunTimeEntityAdapter = GameRunTimeEntity.Adapter(
            runTimeAdapter = EnumColumnAdapter()
        ),
        RunTimeEntityAdapter = RunTimeEntity.Adapter(
            runTimeAdapter = EnumColumnAdapter()
        )
    )

    fun categoryDao(): CategoryDao = CategoryDao(database)

    fun gameDao(): GameDao = GameDao(database)

    fun runTimeDao(): RunTimeDao = RunTimeDao(database)

    fun gameRunTimeDao(): GameRunTimeDao = GameRunTimeDao(database)

    fun gameDeveloperDao(): GameDeveloperDao = GameDeveloperDao(database)

    fun platformDao(): PlatformDao = PlatformDao(database)

    fun developerDao(): DeveloperDao = DeveloperDao(database)
}
