package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.*

class GameDeveloperDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertGameDevelopers(gameDevelopers: List<GameDeveloperEntity>) {
        dbQuery.transaction {
            gameDevelopers.forEach {
                dbQuery.upsertGameDeveloper(
                    gameDeveloper_gameId = it.gameDeveloper_gameId,
                    gameDeveloper_developerId = it.gameDeveloper_developerId
                )
            }
        }
    }
}
