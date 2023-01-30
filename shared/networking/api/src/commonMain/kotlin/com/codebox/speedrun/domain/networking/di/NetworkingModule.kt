package com.codebox.speedrun.domain.networking.di

import com.codebox.speedrun.domain.networking.api.categories.CategoriesApiService
import com.codebox.speedrun.domain.networking.api.games.GamesApiService
import com.codebox.speedrun.domain.networking.api.players.PlayersApiService
import com.codebox.speedrun.domain.networking.api.players.models.GuestResponse
import com.codebox.speedrun.domain.networking.api.players.models.PlayerResponse
import com.codebox.speedrun.domain.networking.api.players.models.UserResponse
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

class NetworkingModule {

    @OptIn(ExperimentalSerializationApi::class)
    private val httpClient by lazy {
        HttpClient {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v(message, null, "HttpClient")
                    }
                }
                level = LogLevel.BODY
                // todo: provide different antilog for release
                Napier.base(DebugAntilog())
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        ignoreUnknownKeys = true
                        explicitNulls = false
                        serializersModule = SerializersModule {
                            polymorphic(PlayerResponse::class){
                                subclass(UserResponse::class)
                                subclass(GuestResponse::class)
                            }
                        }
                    }
                )
            }
            install(HttpCache)
            defaultRequest {
                url {
                    host = "www.speedrun.com/api/v1"
                    protocol = URLProtocol.HTTPS
                }
            }
        }
    }

    val categoriesApiService by lazy {
        CategoriesApiService(httpClient)
    }

    val gamesApiService by lazy {
        GamesApiService(httpClient)
    }

    val playersApiService by lazy {
        PlayersApiService(httpClient)
    }
}
