package com.codebox.speedrun.domain.networking.api.leaderboards

import com.codebox.speedrun.domain.networking.api.leaderboards.models.LeaderboardResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.path
import io.ktor.http.set

class LeaderboardsApiService(
    private val httpClient: HttpClient,
) {
    suspend fun getLeaderboard(
        gameId: String,
        categoryId: String
    ): LeaderboardResponse {
        return httpClient.get {
            url.set { path("leaderboards/$gameId/category/${categoryId}") }
            parameter("embed", "players,category,variables")
        }.body()
    }
}
