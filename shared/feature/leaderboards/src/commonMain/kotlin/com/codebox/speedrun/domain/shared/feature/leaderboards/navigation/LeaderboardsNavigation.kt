package com.codebox.speedrun.domain.shared.feature.leaderboards.navigation

import com.codebox.speedrun.domain.core.navigation.Destination

object LeaderboardsNavigation : Destination {
    const val gameIdArg = "gameId"

    operator fun invoke(gameId:String) = "leaderboards_route/$gameId"

    override val route = "leaderboards_route/{$gameIdArg}"

    override val destination = "leaderboards_destination"
}
