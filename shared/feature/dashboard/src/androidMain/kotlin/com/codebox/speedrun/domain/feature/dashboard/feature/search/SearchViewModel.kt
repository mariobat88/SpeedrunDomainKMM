package com.codebox.speedrun.domain.feature.dashboard.feature.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.codebox.speedrun.domain.core.framework.SpeedrunViewModel
import com.codebox.speedrun.domain.data.repo.games.GamesRepository
import com.codebox.speedrun.domain.data.repo.players.PlayersRepository
import com.codebox.speedrun.domain.di.AppComponent
import com.codebox.speedrun.domain.feature.dashboard.feature.search.di.SearchFeatureComponentImpl
import com.codebox.speedrun.domain.feature.dashboard.feature.search.navigation.SearchNavigator
import com.speedrun.domain.core.paging.SpeedrunPagingSource
import kotlinx.coroutines.flow.*

actual class SearchViewModel actual constructor(
    private val searchNavigator: SearchNavigator,
    private val gamesRepository: GamesRepository,
    private val playersRepository: PlayersRepository,
) : SpeedrunViewModel<ViewState, Intent, Unit>(
    viewState = ViewState()
) {

    companion object {
        fun create(
            appComponent: AppComponent,
            searchNavigator: SearchNavigator
        ): SearchViewModel {
            return SearchFeatureComponentImpl(
                appComponent = appComponent,
                searchNavigator = searchNavigator
            ).searchViewModelFactory.create()
        }

        const val INITIAL_LOAD_SIZE = 40
    }

    actual val tabEnums = ViewState.TAB.values()

    var searchTerm by mutableStateOf("")
        private set

    private var gameSearchTerm by mutableStateOf("")

    private var playerSearchTerm by mutableStateOf("")

    private val gameSearchFlow = snapshotFlow { gameSearchTerm }

    private val playerSearchFlow = snapshotFlow { playerSearchTerm }

    val searchGames = gameSearchFlow
        .debounce(500)
        .distinctUntilChanged()
        .mapLatest { searchTerm ->
            Pager(
                pagingSourceFactory = {
                    SpeedrunPagingSource { offset, max ->
                        gamesRepository.searchGames(searchTerm, offset, max)
                    }
                },
                config = PagingConfig(pageSize = 20, initialLoadSize = INITIAL_LOAD_SIZE)
            ).flow.cachedIn(scope)
        }
        .stateIn(
            scope = scope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyFlow()
        )

    val searchPlayers = playerSearchFlow
        .debounce(500)
        .distinctUntilChanged()
        .mapLatest { searchTerm ->
            Pager(
                pagingSourceFactory = {
                    SpeedrunPagingSource { offset, max ->
                        playersRepository.searchPlayers(searchTerm, offset, max)
                    }
                },
                config = PagingConfig(pageSize = 20, initialLoadSize = INITIAL_LOAD_SIZE)
            ).flow.cachedIn(scope)
        }
        .stateIn(
            scope = scope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyFlow()
        )

    override suspend fun bind(intents: Flow<Intent>): Flow<Any> {
        val searchIntent = intents.filterIsInstance<Intent.Search>()
            .onEach { intent ->
                if (viewState.value.selectedTab == ViewState.TAB.GAMES) {
                    gameSearchTerm = intent.searchTerm
                    searchTerm = gameSearchTerm
                } else {
                    playerSearchTerm = intent.searchTerm
                    searchTerm = playerSearchTerm
                }
            }

        val clearSearchIntent = intents.filterIsInstance<Intent.ClearSearch>()
            .onEach {
                if (viewState.value.selectedTab == ViewState.TAB.GAMES) {
                    gameSearchTerm = ""
                    searchTerm = ""
                } else {
                    playerSearchTerm = ""
                    searchTerm = ""
                }
            }

        val selectedTabIntent = intents.filterIsInstance<Intent.TabSelected>()
            .onEach { intent ->
                reduce { it.copy(selectedTab = tabEnums[intent.index]) }
                searchTerm = if (intent.index == ViewState.TAB.GAMES.ordinal) {
                    gameSearchTerm
                } else {
                    playerSearchTerm
                }
            }

        val navigateToGameScreenIntent = intents.filterIsInstance<Intent.NavigateToGameScreen>()
            .onEach { intent -> searchNavigator.navigateToGameScreen(intent.gameId) }

        return merge(
            searchIntent,
            clearSearchIntent,
            selectedTabIntent,
            navigateToGameScreenIntent,
        )
    }
}
