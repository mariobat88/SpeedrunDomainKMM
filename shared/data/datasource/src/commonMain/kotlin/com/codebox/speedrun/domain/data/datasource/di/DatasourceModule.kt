package com.codebox.speedrun.domain.data.datasource.di

import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatchersModule
import com.codebox.speedrun.domain.data.database.di.DatabaseModule
import com.codebox.speedrun.domain.data.datasource.categories.CategoriesRepositoryImpl
import com.codebox.speedrun.domain.data.datasource.games.GamesRepositoryImpl
import com.codebox.speedrun.domain.data.datasource.players.PlayersRepositoryImpl
import com.codebox.speedrun.domain.data.repo.categories.CategoriesRepository
import com.codebox.speedrun.domain.data.repo.games.GamesRepository
import com.codebox.speedrun.domain.data.repo.players.PlayersRepository
import com.codebox.speedrun.domain.networking.di.NetworkingModule

class DatasourceModule(
    private val networkingModule: NetworkingModule,
    private val databaseModule: DatabaseModule,
    private val dispatchersModule: DispatchersModule,
) {
    val categoriesRepository: CategoriesRepository by lazy {
        CategoriesRepositoryImpl(
            networkingModule.categoriesApiService,
            dispatchersModule.dispatcherProvider,
            databaseModule.database
        )
    }

    val gamesRepository: GamesRepository by lazy {
        GamesRepositoryImpl(
            networkingModule.gamesApiService,
            dispatchersModule.dispatcherProvider,
            databaseModule.database
        )
    }

    val playerRepository: PlayersRepository by lazy {
        PlayersRepositoryImpl(
            networkingModule.playersApiService,
            dispatchersModule.dispatcherProvider,
            databaseModule.database
        )
    }
}
