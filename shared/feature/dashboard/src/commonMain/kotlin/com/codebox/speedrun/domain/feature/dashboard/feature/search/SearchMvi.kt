package com.codebox.speedrun.domain.feature.dashboard.feature.search

sealed class Intent {
    data class TabSelected(val index: Int) : Intent()
    data class Search(val searchTerm: String) : Intent()
    object ClearSearch : Intent()
    data class NavigateToGameScreen(val gameId: String) : Intent()
}

data class ViewState(
    val selectedTab: TAB = TAB.GAMES
) {
    enum class TAB {
        GAMES, PLAYERS
    }
}
