package com.codebox.speedrun.domain.feature.dashboard.feature.search

import com.codebox.speedrun.domain.data.repo.games.GamesRepository
import com.codebox.speedrun.domain.data.repo.players.PlayersRepository
import com.codebox.speedrun.domain.feature.dashboard.feature.search.navigation.SearchNavigator

expect class SearchViewModel(
    searchNavigator: SearchNavigator,
    gamesRepository: GamesRepository,
    playersRepository: PlayersRepository,
) {

    val tabEnums: Array<ViewState.TAB>
}
