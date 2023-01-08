package com.codebox.speedrun.domain.feature.dashboard.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.codebox.speedrun.domain.feature.dashboard.DashboardScreen
import com.codebox.speedrun.domain.feature.dashboard.DashboardViewModel
import com.codebox.speedrun.domain.feature.dashboard.feature.home.navigation.HomeNavigation
import com.codebox.speedrun.domain.feature.dashboard.feature.home.navigation.homeNavigation
import com.codebox.speedrun.domain.feature.dashboard.feature.search.navigation.searchNavigation
import com.speedrun.domain.core.framework.Navigation

fun NavGraphBuilder.dashboardNavigation(
    dashboardNavigator: DashboardNavigator
) {
    navigation(
        route = DashboardNavigation.route,
        startDestination = DashboardNavigation.destination,
    ) {
        composable(route = DashboardNavigation.destination) {
            DashboardScreen(dashboardNavigator)
        }
    }
}

@Composable
fun DashboardSubNavigation(
    navController: NavHostController,
    dashboardNavigator: DashboardNavigator,
    dashboardViewModel: DashboardViewModel,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeNavigation.route,
        modifier = modifier
    ) {
        homeNavigation()
        searchNavigation(dashboardNavigator)
    }
    Navigation(navController, dashboardViewModel)
}
