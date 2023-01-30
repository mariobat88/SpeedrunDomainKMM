package com.codebox.speedrun.domain.networking.api.developers

import com.codebox.speedrun.domain.networking.api.developers.models.DeveloperResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class DevelopersApiService(
    private val httpClient: HttpClient,
) {
    suspend fun getDeveloper(id: String): DeveloperResponse {
        return httpClient.get("developers/${id}").body()
    }
}
