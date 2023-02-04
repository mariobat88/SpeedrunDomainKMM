package com.codebox.speedrun.domain.di

import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatchersModule
import com.codebox.speedrun.domain.data.database.DatabaseDriverFactory
import com.codebox.speedrun.domain.data.database.di.DatabaseModule
import com.codebox.speedrun.domain.data.datasource.di.DatasourceModule
import com.codebox.speedrun.domain.data.repo.categories.CategoriesRepository
import com.codebox.speedrun.domain.data.repo.developers.DevelopersRepository
import com.codebox.speedrun.domain.data.repo.games.GamesRepository
import com.codebox.speedrun.domain.data.repo.players.PlayersRepository
import com.codebox.speedrun.domain.data.repo.publishers.PublishersRepository
import com.codebox.speedrun.domain.networking.di.NetworkingModule

interface AppComponent {
    val dispatcherProvider: DispatcherProvider
    val categoriesRepository: CategoriesRepository
    val gamesRepository: GamesRepository
    val playersRepository: PlayersRepository
    val developersRepository: DevelopersRepository
    val publishersRepository: PublishersRepository
}

class AppComponentImpl(
    private val databaseDriverFactory: DatabaseDriverFactory
) : AppComponent {

    private val networkingModule by lazy {
        NetworkingModule()
    }

    private val databaseModule by lazy {
        DatabaseModule(databaseDriverFactory)
    }

    private val datasourceModule by lazy {
        DatasourceModule(networkingModule, databaseModule, dispatchersModule)
    }

    private val dispatchersModule by lazy {
        DispatchersModule()
    }

    override val dispatcherProvider: DispatcherProvider by lazy {
        dispatchersModule.dispatcherProvider
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

    override val developersRepository: DevelopersRepository by lazy {
        datasourceModule.developersRepository
    }

    override val publishersRepository: PublishersRepository by lazy {
        datasourceModule.publishersRepository
    }
}
