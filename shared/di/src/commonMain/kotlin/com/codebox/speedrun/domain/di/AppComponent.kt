package com.codebox.speedrun.domain.di

import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatchersModule
import com.codebox.speedrun.domain.data.database.DatabaseDriverFactory
import com.codebox.speedrun.domain.data.database.di.DatabaseModule
import com.codebox.speedrun.domain.data.datasource.di.DatasourceModule
import com.codebox.speedrun.domain.data.repo.categories.CategoriesRepository
import com.codebox.speedrun.domain.data.repo.games.GamesRepository
import com.codebox.speedrun.domain.data.repo.players.PlayersRepository
import com.codebox.speedrun.domain.networking.di.NetworkingModule

interface AppComponent {
    val databaseModule: DatabaseModule
    val datasourceModule: DatasourceModule
    val networkingModule: NetworkingModule
    val dispatchersModule: DispatchersModule
    val categoriesRepository: CategoriesRepository
    val gamesRepository: GamesRepository
    val playersRepository: PlayersRepository
}

class AppComponentImpl(
    private val databaseDriverFactory: DatabaseDriverFactory
) : AppComponent {

    override val networkingModule by lazy {
        NetworkingModule()
    }

    override val databaseModule by lazy {
        DatabaseModule(databaseDriverFactory)
    }

    override val datasourceModule by lazy {
        DatasourceModule(networkingModule, databaseModule, dispatchersModule)
    }

    override val dispatchersModule by lazy{
        DispatchersModule()
    }

    override val categoriesRepository: CategoriesRepository by lazy {
        datasourceModule.categoriesRepository
    }

    override val gamesRepository: GamesRepository by lazy {
        datasourceModule.gamesRepository
    }

    override val playersRepository: PlayersRepository by lazy {
        datasourceModule.playerRepository
    }
}
