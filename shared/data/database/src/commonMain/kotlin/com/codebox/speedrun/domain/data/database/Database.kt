package com.codebox.speedrun.domain.data.database

import com.codebox.speedrun.domain.data.database.dao.*
import com.squareup.sqldelight.EnumColumnAdapter

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = SpeedrunDomainDatabase(
        driver = databaseDriverFactory.createDriver(),
        CategoryEntityAdapter = CategoryEntity.Adapter(
            category_typeAdapter = EnumColumnAdapter()
        ),
        GameRuleSetEntityAdapter = GameRuleSetEntity.Adapter(
            gameRuleSet_defaultTimeAdapter = EnumColumnAdapter()
        ),
        GameRunTimeEntityAdapter = GameRunTimeEntity.Adapter(
            runTimeAdapter = EnumColumnAdapter()
        ),
        RunTimeEntityAdapter = RunTimeEntity.Adapter(
            runTimeAdapter = EnumColumnAdapter()
        ),
        LeaderboardEntityAdapter = LeaderboardEntity.Adapter(
            leaderboard_timingAdapter = EnumColumnAdapter()
        ),
    )

    fun categoryDao(): CategoryDao = CategoryDao(database)
    fun developerDao(): DeveloperDao = DeveloperDao(database)
    fun gameDao(): GameDao = GameDao(database)
    fun gameDeveloperDao(): GameDeveloperDao = GameDeveloperDao(database)
    fun gamePublisherDao(): GamePublisherDao = GamePublisherDao(database)
    fun gameRunTimeDao(): GameRunTimeDao = GameRunTimeDao(database)
    fun leaderboardDao(): LeaderboardDao = LeaderboardDao(database)
    fun leaderboardRunDao(): LeaderboardRunDao = LeaderboardRunDao(database)
    fun locationDao(): LocationDao = LocationDao(database)
    fun placeDao(): PlaceDao = PlaceDao(database)
    fun platformDao(): PlatformDao = PlatformDao(database)
    fun playerDao(): PlayerDao = PlayerDao(database)
    fun publisherDao(): PublisherDao = PublisherDao(database)
    fun runDao(): RunDao = RunDao(database)
    fun runPlayerDao(): RunPlayerDao = RunPlayerDao(database)
    fun runTimeDao(): RunTimeDao = RunTimeDao(database)
    fun runValueDao(): RunValueDao = RunValueDao(database)
    fun userLocationDao(): UserLocationDao = UserLocationDao(database)
    fun valueDao(): ValueDao = ValueDao(database)
    fun variableDao(): VariableDao = VariableDao(database)
}
