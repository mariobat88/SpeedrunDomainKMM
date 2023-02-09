package com.codebox.speedrun.domain.data.database.dao

import com.codebox.speedrun.domain.data.database.LeaderboardEntity
import com.codebox.speedrun.domain.data.database.SpeedrunDomainDatabase

class LeaderboardDao(
    database: SpeedrunDomainDatabase
) {
    private val dbQuery = database.speedrunDomainDatabaseQueries

    fun upsertLeaderboard(leaderboard: LeaderboardEntity) {
        dbQuery.transaction {
            dbQuery.upsertLeaderboard(
                leaderboard_id = leaderboard.leaderboard_id,
                leaderboard_weblink = leaderboard.leaderboard_weblink,
                leaderboard_gameId = leaderboard.leaderboard_gameId,
                leaderboard_categoryId = leaderboard.leaderboard_categoryId,
                leaderboard_level = leaderboard.leaderboard_level,
                leaderboard_platform = leaderboard.leaderboard_platform,
                leaderboard_region = leaderboard.leaderboard_region,
                leaderboard_emulators = leaderboard.leaderboard_emulators,
                leaderboard_videoOnly = leaderboard.leaderboard_videoOnly,
                leaderboard_timing = leaderboard.leaderboard_timing,
            )
        }
    }
}
