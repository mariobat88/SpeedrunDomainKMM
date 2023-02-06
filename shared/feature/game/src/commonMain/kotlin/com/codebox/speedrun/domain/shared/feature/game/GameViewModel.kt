package com.codebox.speedrun.domain.shared.feature.game

import com.codebox.speedrun.domain.core.framework.SpeedrunViewModel
import com.codebox.speedrun.domain.core.framework.async.Success
import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.data.repo.developers.DevelopersRepository
import com.codebox.speedrun.domain.data.repo.games.GamesRepository
import com.codebox.speedrun.domain.data.repo.games.model.GameModel
import com.codebox.speedrun.domain.data.repo.publishers.PublishersRepository
import com.codebox.speedrun.domain.di.AppComponent
import com.codebox.speedrun.domain.shared.feature.game.di.GameFeatureComponentImpl
import com.codebox.speedrun.domain.shared.feature.game.navigation.GameNavigator
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

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
            appComponent: AppComponent,
            gameId: String,
            gameNavigator: GameNavigator,
        ): GameViewModel {
            return GameFeatureComponentImpl(
                appComponent = appComponent,
                gameId = gameId,
                gameNavigator = gameNavigator,
            ).gameViewModelFactory.create()
        }
    }

    init {
        scope.launch(dispatcherProvider.main()) {
            val getGameByIdFlow = gamesRepository.getGameById(gameId).stateIn(this)
                .asAsync()

            launch {
                getGameByIdFlow
                    .collect { gameAsync ->
                        reduce { it.copy(gameAsync = gameAsync) }
                    }
            }

            launch {
                getGameByIdFlow
                    .filterIsInstance<Success<GameModel>>()
                    .map { it.value }
                    .map { gameModel ->
                        gameModel.developers?.map { developerId ->
                            async { developersRepository.getDeveloper(developerId) }
                        }?.awaitAll()
                    }.asAsync()
                    .collect { developersAsync ->
                        reduce {
                            it.copy(
                                developersAsync = developersAsync,
                                developers = developersAsync()?.joinToString(", ") { it.name } ?: ""
                            )
                        }
                    }
            }

            launch {
                getGameByIdFlow
                    .filterIsInstance<Success<GameModel>>()
                    .map { it.value }
                    .map { gameModel ->
                        gameModel.publishers?.map { publisherId ->
                            async { publishersRepository.getPublisher(publisherId) }
                        }?.awaitAll()
                    }.asAsync()
                    .collect { publishersAsync ->
                        reduce {
                            it.copy(
                                publishersAsync = publishersAsync,
                                publishers = publishersAsync()?.map { it.name }?.joinToString(", ") ?: ""
                            )
                        }
                    }
            }
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