package com.codebox.speedrun.domain.feature.dashboard

import com.codebox.speedrun.domain.core.navigation.NavigationOptions

sealed class Intent {
    data class NavigateToTab(val route: String, val navigationOptions: NavigationOptions) : Intent()
}
