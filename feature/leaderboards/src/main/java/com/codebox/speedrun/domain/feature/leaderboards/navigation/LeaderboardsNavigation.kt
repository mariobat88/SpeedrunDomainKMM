package com.codebox.speedrun.domain.feature.leaderboards.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.codebox.speedrun.domain.feature.leaderboards.LeaderboardsScreen
import com.codebox.speedrun.domain.shared.feature.leaderboards.navigation.LeaderboardsNavigation
import com.codebox.speedrun.domain.shared.feature.leaderboards.navigation.LeaderboardsNavigator

fun NavGraphBuilder.leaderboardsNavigation(
    leaderboardsNavigator: LeaderboardsNavigator
) {
    navigation(
        route = LeaderboardsNavigation.route,
        startDestination = LeaderboardsNavigation.destination,
        arguments = listOf(navArgument(LeaderboardsNavigation.gameIdArg) { type = NavType.StringType })
    ) {
        composable(route = LeaderboardsNavigation.destination) {
            val gameId = it.arguments?.getString(LeaderboardsNavigation.gameIdArg)!!
            LeaderboardsScreen(gameId, leaderboardsNavigator)
        }
    }
}

