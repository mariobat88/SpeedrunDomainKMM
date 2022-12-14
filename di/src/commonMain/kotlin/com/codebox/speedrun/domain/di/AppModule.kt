package com.codebox.speedrun.domain.di

/**
 * Base Koin module shared across all apps (android, iOS, Desktop)
 */
fun appModule() = listOf(
    platformModule,
//    networkModule,
//    persistenceModule,
//    domainAuthModule,
//    repositoryModule,
)