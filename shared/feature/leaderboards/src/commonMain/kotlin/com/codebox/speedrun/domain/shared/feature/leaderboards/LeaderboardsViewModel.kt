package com.codebox.speedrun.domain.shared.feature.leaderboards

import com.codebox.speedrun.domain.core.framework.SpeedrunViewModel
import com.codebox.speedrun.domain.core.wrapper.dispatchers.DispatcherProvider
import com.codebox.speedrun.domain.data.repo.categories.CategoriesRepository
import com.codebox.speedrun.domain.di.AppComponent
import com.codebox.speedrun.domain.shared.feature.leaderboards.di.LeaderboardsFeatureComponentImpl
import com.codebox.speedrun.domain.shared.feature.leaderboards.navigation.LeaderboardsNavigator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class LeaderboardsViewModel(
    private val gameId: String,
    private val leaderboardsNavigator: LeaderboardsNavigator,
    private val categoriesRepository: CategoriesRepository,
    //private val leaderboardsRepository: LeaderboardsRepository,
    dispatcherProvider: DispatcherProvider,
) : SpeedrunViewModel<ViewState, Intent, Unit>(
    viewState = ViewState()
) {

    companion object {
        fun create(
            appComponent: AppComponent,
            gameId: String,
            leaderboardsNavigator: LeaderboardsNavigator
        ): LeaderboardsViewModel {
            return LeaderboardsFeatureComponentImpl(
                appComponent = appComponent,
                gameId = gameId,
                leaderboardsNavigator = leaderboardsNavigator,
            ).leaderboardsViewModelFactory.create()
        }
    }

    init {
        scope.launch(dispatcherProvider.main()) {
            launch {
                categoriesRepository.refreshCategoriesByGame(gameId)
//                categoriesRepository.observeCategoriesByGame(gameId)
//                    .map { it.filter { it.type == RunTypeEnum.PER_GAME } }
//                    .asAsync()
//                    .collect { categoriesAsync ->
//                        reduce {
//                            it.copy(
//                                categoriesAsync = categoriesAsync
//                            )
//                        }
//                    }
            }
        }
    }

    override suspend fun bind(intents: Flow<Intent>): Flow<Any> {
        val categorySelected = intents.filterIsInstance<Intent.CategorySelected>()
            .onEach { intent ->
//                val category = getViewState().categoriesAsync()!![intent.index]
//                val leaderboardsMap = getViewState().leaderboardsMap
//                val currentEntry = leaderboardsMap[intent.index]
//
//                if (currentEntry == null) {
//                    suspend {
//                        leaderboardsRepository.refreshLeaderboards(gameId, category.id)
//                    }.execute {
//
//                    }
//
//                    viewModelScope.launch {
//                        leaderboardsRepository.observeLeaderboard(gameId, category.id)
//                            .map {
//                                it.copy(
//                                    runs = it.runs.sortedBy { it.place }
//                                )
//                            }
//                            .asAsync()
//                            .collect { leaderboardAsync ->
//                                leaderboardsMap[intent.index] = leaderboardAsync
//
//                                reduce {
//                                    it.copy(
//                                        leaderboardsMap = leaderboardsMap
//                                    )
//                                }
//                            }
//                    }
//                }
            }

        val runClicked = intents.filterIsInstance<Intent.RunClicked>()
            .onEach { intent ->
                intent.runId?.let { runId ->
                    leaderboardsNavigator.navigateToRunScreen(runId)
                }
            }

        return merge(
            categorySelected,
            runClicked,
        )
    }
}
