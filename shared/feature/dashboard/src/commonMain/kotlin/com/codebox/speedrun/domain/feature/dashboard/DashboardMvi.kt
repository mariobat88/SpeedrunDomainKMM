package com.codebox.speedrun.domain.feature.dashboard

sealed class Intent {
    data class NavigateToTab(val route: String) : Intent()
}
