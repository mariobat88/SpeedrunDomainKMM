package com.codebox.speedrun.domain.feature.dashboard.navigation

import com.codebox.speedrun.domain.core.navigation.NavigationOptions

interface DashboardSubNavigator {
    fun navigateToTab(route: String, navigationOptions: NavigationOptions)
}
