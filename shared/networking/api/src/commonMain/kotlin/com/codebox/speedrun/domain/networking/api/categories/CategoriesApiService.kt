package com.codebox.speedrun.domain.networking.api.categories

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

internal class CategoriesApiService(
    private val httpClient: HttpClient,
) {
    suspend fun getCategories(gameId: String): String {
        val response = httpClient.get("games/${gameId}/categories")
        return response.bodyAsText()
    }
}
