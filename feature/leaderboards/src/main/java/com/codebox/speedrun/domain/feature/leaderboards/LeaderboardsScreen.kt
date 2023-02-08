package com.codebox.speedrun.domain.feature.leaderboards

import androidx.compose.runtime.Composable
import com.codebox.speedrun.domain.core.framework.Screen
import com.codebox.speedrun.domain.core.framework.speedrunViewModel
import com.codebox.speedrun.domain.di.appComponent
import com.codebox.speedrun.domain.shared.feature.leaderboards.LeaderboardsViewModel
import com.codebox.speedrun.domain.shared.feature.leaderboards.navigation.LeaderboardsNavigator

@Composable
internal fun LeaderboardsScreen(
    gameId: String,
    leaderboardsNavigator: LeaderboardsNavigator
) {
    val appComponent = appComponent()
    val leaderboardsViewModel = speedrunViewModel{ LeaderboardsViewModel.create(appComponent, gameId, leaderboardsNavigator)}
    LeaderboardsScreen(leaderboardsViewModel)
}

@Composable
fun LeaderboardsScreen(
    viewModel: LeaderboardsViewModel
) = Screen(viewModel) { viewState, intentChannel, _ ->
    //LeaderboardsScreen(viewState, intentChannel)
}
