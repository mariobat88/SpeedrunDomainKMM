package com.codebox.speedrun.domain.networking.api.categories

import com.codebox.speedrun.domain.networking.api.categories.models.CategoryDataListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class CategoriesApiService(
    private val httpClient: HttpClient,
) {
    suspend fun getCategories(gameId: String): CategoryDataListResponse {
        return httpClient.get("games/${gameId}/categories").body()
    }
}
