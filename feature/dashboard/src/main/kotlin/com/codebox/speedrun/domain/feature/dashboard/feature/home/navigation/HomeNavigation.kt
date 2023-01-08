package com.codebox.speedrun.domain.feature.dashboard.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.codebox.speedrun.domain.feature.dashboard.feature.home.HomeScreen


fun NavGraphBuilder.homeNavigation() {
    composable(route = HomeNavigation.route) {
        HomeScreen()
    }
}