package com.codebox.speedrun.domain.networking.api.players

import com.codebox.speedrun.domain.networking.api.pagination.models.PaginationResponse
import com.codebox.speedrun.domain.networking.api.players.models.PersonalBestsDataListResponse
import com.codebox.speedrun.domain.networking.api.players.models.UserDataResponse
import com.codebox.speedrun.domain.networking.api.players.models.UserResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class PlayersApiService(
    private val httpClient: HttpClient,
) {
    suspend fun searchPlayers(
        name: String,
        offset: Int,
        max: Int,
    ): PaginationResponse<UserResponse> {
        return httpClient.get {
            headers["Cache-Control"] = "no-cache"
            url.set { path("users") }
            parameter("name", name)
            parameter("offset", offset)
            parameter("max", max)
        }.body()
    }

    suspend fun getPlayer(
        playerId: String
    ): UserDataResponse {
        return httpClient.get {
            url.set { path("users/${playerId}") }
        }.body()
    }

    suspend fun getUserPersonalBests(
        playerId: String
    ): PersonalBestsDataListResponse {
        return httpClient.get {
            url.set { path("users/${playerId}/personal-bests") }
            parameter("embed", "game,category")
        }.body()
    }
}
