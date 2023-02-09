package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.LeaderboardRunEntity
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase

class LeaderboardRunDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertLeaderboardRuns(leaderboardRuns: List<LeaderboardRunEntity>) {
        dbQuery.transaction {
            leaderboardRuns.forEach {
                dbQuery.upsertLeaderboardRun(
                    leaderboardRun_leaderboardId = it.leaderboardRun_leaderboardId,
                    leaderboardRun_runId = it.leaderboardRun_runId,
                )
            }
        }
    }
}
