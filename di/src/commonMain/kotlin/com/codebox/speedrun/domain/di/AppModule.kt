package com.codebox.speedrun.domain.di

import com.codebox.speedrun.domain.data.datasource.di.datasourceModule
import com.codebox.speedrun.domain.networking.di.networkingModule

/**
 * Base Koin module shared across all apps (android, iOS, Desktop)
 */
fun appModule() = listOf(
    platformModule,
    networkingModule,
    datasourceModule,
//    domainAuthModule,
//    repositoryModule,
)