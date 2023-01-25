package com.codebox.speedrun.domain.feature.dashboard.feature.search

import com.codebox.speedrun.domain.data.repo.games.GamesRepository
import com.codebox.speedrun.domain.data.repo.players.PlayersRepository
import com.codebox.speedrun.domain.feature.dashboard.feature.search.navigation.SearchNavigator

actual class SearchViewModel actual constructor(
    private val searchNavigator: SearchNavigator,
    private val gamesRepository: GamesRepository,
    private val playersRepository: PlayersRepository,
) {

    actual val tabEnums = ViewState.TAB.values()
}
