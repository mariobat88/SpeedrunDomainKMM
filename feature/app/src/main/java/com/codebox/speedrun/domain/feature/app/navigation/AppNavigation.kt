package com.codebox.speedrun.domain.feature.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.codebox.speedrun.domain.core.navigation.StateNavigator
import com.codebox.speedrun.domain.feature.dashboard.navigation.DashboardNavigation
import com.codebox.speedrun.domain.feature.dashboard.navigation.dashboardNavigation
import com.codebox.speedrun.domain.shared.feature.app.navigation.AppNavigator
import com.speedrun.domain.core.framework.Navigation

@Composable
fun <T> AppNavigation(
    navController: NavHostController,
    mainNavigator: T,
) where T : AppNavigator, T : StateNavigator {
    NavHost(
        navController = navController,
        startDestination = DashboardNavigation.route
    ) {
        dashboardNavigation(mainNavigator)
        //gameNavigation(mainNavigator)
        //leaderboardsNavigation(mainNavigator)
        //runNavigation(mainNavigator)
        //playerNavigation(mainNavigator)
    }
    Navigation(navController, mainNavigator)
}
