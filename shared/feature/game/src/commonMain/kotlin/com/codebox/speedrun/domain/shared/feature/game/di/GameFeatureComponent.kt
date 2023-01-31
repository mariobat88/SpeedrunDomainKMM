package com.codebox.speedrun.domain.shared.feature.game.di

import com.codebox.speedrun.domain.di.AppComponent
import com.codebox.speedrun.domain.di.Factory
import com.codebox.speedrun.domain.shared.feature.game.GameViewModel
import com.codebox.speedrun.domain.shared.feature.game.navigation.GameNavigator

interface GameFeatureComponent {
    val gameViewModelFactory: GameViewModelFactory
}

class GameFeatureComponentImpl(
    gameId: String,
    gameNavigator: GameNavigator,
    appComponent: AppComponent,
) : GameFeatureComponent {

    override val gameViewModelFactory = GameViewModelFactory(gameId, gameNavigator, appComponent)
}

class GameViewModelFactory(
    private val gameId: String,
    private val gameNavigator: GameNavigator,
    private val appComponent: AppComponent,
) : Factory<GameViewModel> {
    override fun create(): GameViewModel {
        return GameViewModel(
            gameId = gameId,
            gameNavigator = gameNavigator,
            developersRepository = appComponent.developersRepository,
            publishersRepository = appComponent.publishersRepository,
            gamesRepository = appComponent.gamesRepository,
            dispatcherProvider = appComponent.dispatcherProvider
        )
    }
}
