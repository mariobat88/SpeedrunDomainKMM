package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.RunPlayerJunctionEntity
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase

class RunPlayerDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    private fun upsertRunPlayer(runPlayer: RunPlayerJunctionEntity) {
        dbQuery.transaction {
            dbQuery.upsertRunPlayer(
                runPlayer_runId = runPlayer.runPlayer_runId,
                runPlayer_playerId = runPlayer.runPlayer_playerId,
            )
        }
    }

    fun upsertRunPlayers(runPlayers: List<RunPlayerJunctionEntity>) {
        dbQuery.transaction { runPlayers.forEach { upsertRunPlayer(it) } }
    }
}
