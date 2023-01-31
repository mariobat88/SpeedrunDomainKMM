package com.codebox.speedrun.domain.shared.feature.game.navigation

interface GameNavigator {
    fun backClicked()
    fun navigateToLeaderboardsScreen(gameId: String)
}
