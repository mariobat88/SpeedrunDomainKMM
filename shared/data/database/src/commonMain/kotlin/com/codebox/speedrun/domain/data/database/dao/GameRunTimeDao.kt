package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.GameRunTimeEntity
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase

class GameRunTimeDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertGameRunTimes(runTimes: List<GameRunTimeEntity>) {
        dbQuery.transaction {
            runTimes.forEach {
                dbQuery.upsertGameRunTime(
                    gameId = it.gameId,
                    runTime = it.runTime,
                )
            }
        }
    }
}
