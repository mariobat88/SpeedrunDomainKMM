package com.codebox.speedrun.domain.networking.di

import com.codebox.speedrun.domain.networking.api.categories.CategoriesApiService
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkingModule: Module = module {
    singleOf<HttpClient> {
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
                    }
                )
            }
            defaultRequest {
                url {
                    host = "www.speedrun.com/api/v1"
                    protocol = URLProtocol.HTTPS
                }
            }
        }
    }
    single { CategoriesApiService(get()) }
}