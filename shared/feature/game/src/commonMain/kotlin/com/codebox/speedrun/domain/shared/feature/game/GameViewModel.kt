package com.codebox.speedrun.domain.shared.feature.game

import com.codebox.speedrun.domain.core.framework.SpeedrunViewModel
import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.data.repo.developers.DevelopersRepository
import com.codebox.speedrun.domain.data.repo.games.GamesRepository
import com.codebox.speedrun.domain.data.repo.publishers.PublishersRepository
import com.codebox.speedrun.domain.di.AppComponent
import com.codebox.speedrun.domain.shared.feature.game.di.GameFeatureComponentImpl
import com.codebox.speedrun.domain.shared.feature.game.navigation.GameNavigator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach

class GameViewModel(
    private val gameId: String,
    private val gameNavigator: GameNavigator,
    private val developersRepository: DevelopersRepository,
    private val publishersRepository: PublishersRepository,
    private val gamesRepository: GamesRepository,
    dispatcherProvider: DispatcherProvider,
) : SpeedrunViewModel<ViewState, Intent, Unit>(
    viewState = ViewState()
) {
    companion object {
        fun create(
            gameId: String,
            gameNavigator: GameNavigator,
            appComponent: AppComponent
        ): GameViewModel {
            return GameFeatureComponentImpl(
                gameId = gameId,
                gameNavigator = gameNavigator,
                appComponent = appComponent,
            ).gameViewModelFactory.create()
        }
    }

    override suspend fun bind(intents: Flow<Intent>): Flow<Any> {
        val backClickedIntent = intents.filterIsInstance<Intent.BackClicked>()
            .onEach { gameNavigator.backClicked() }

        val leaderboardsClickedIntent = intents.filterIsInstance<Intent.LeaderboardsClicked>()
            .onEach { gameNavigator.navigateToLeaderboardsScreen(gameId) }

        return merge(backClickedIntent, leaderboardsClickedIntent)
    }
}