package com.codebox.speedrun.domain.shared.feature.game.navigation

import com.codebox.speedrun.domain.core.navigation.Destination

object GameNavigation : Destination {
    const val gameIdArg = "gameId"

    operator fun invoke(gameId:String) = "game_route/$gameId"

    override val route = "game_route/{$gameIdArg}"

    override val destination = "game_destination"
}
