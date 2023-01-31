package com.codebox.speedrun.domain.networking.api.publishers

import com.codebox.speedrun.domain.networking.api.publishers.models.PublisherResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class PublishersApiService(
    private val httpClient: HttpClient,
) {
    suspend fun getPublisher(
        id: String,
    ): PublisherResponse {
        return httpClient.get {
            url.set { path("publishers/${id}") }
        }.body()
    }
}