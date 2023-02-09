package com.codebox.speedrun.domain.data.repo.leaderboards

interface LeaderboardsRepository {

    suspend fun refreshLeaderboards(gameId: String, categoryId: String)
//    suspend fun observeLeaderboard(gameId: String, categoryId: String): Flow<LeaderboardModel>
//    suspend fun observeLeaderboardPlace(runId: String): Flow<LeaderboardPlaceModel>
}
