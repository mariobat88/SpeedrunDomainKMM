package com.codebox.speedrun.domain.networking.api.games

import com.codebox.speedrun.domain.networking.api.games.models.GameResponse
import com.codebox.speedrun.domain.networking.api.pagination.models.PaginationResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class GamesApiService(
    private val httpClient: HttpClient,
) {
    suspend fun searchGames(
        name: String,
        offset: Int,
        max: Int,
    ): PaginationResponse<GameResponse> {
        return httpClient.get {
            headers["Cache-Control"] = "no-cache"
            url.set { path("games") }
            parameter("embed", "platforms")
            parameter("name", name)
            parameter("offset", offset)
            parameter("max", max)
        }.body()
    }
}
