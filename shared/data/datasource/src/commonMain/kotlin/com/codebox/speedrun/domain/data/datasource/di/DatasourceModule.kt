package com.codebox.speedrun.domain.data.datasource.di

import com.codebox.speedrun.domain.data.database.di.DatabaseModule
import com.codebox.speedrun.domain.data.datasource.categories.CategoriesRepositoryImpl
import com.codebox.speedrun.domain.data.repo.categories.CategoriesRepository
import com.codebox.speedrun.domain.data.repo.games.GamesRepository
import com.codebox.speedrun.domain.networking.di.NetworkingModule
import com.codebox.speedrun.domain.data.datasource.games.GamesRepositoryImpl

class DatasourceModule(
    private val networkingModule: NetworkingModule,
    private val databaseModule: DatabaseModule,
) {
    val categoriesRepository: CategoriesRepository by lazy {
        CategoriesRepositoryImpl(networkingModule.categoriesApiService)
    }

    val gamesRepository: GamesRepository by lazy {
        GamesRepositoryImpl(networkingModule.gamesApiService, databaseModule.database)
    }
}
