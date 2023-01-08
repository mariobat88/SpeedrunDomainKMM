package com.codebox.speedrun.domain.feature.dashboard.di

import com.codebox.speedrun.domain.core.framework.navigation.StateNavigatorImpl
import com.codebox.speedrun.domain.di.Factory
import com.codebox.speedrun.domain.feature.dashboard.DashboardViewModel
import com.codebox.speedrun.domain.feature.dashboard.navigation.DashboardNavigator

interface DashboardFeatureComponent {
    val dashboardViewModelFactory: DashboardViewModelFactory
}

class DashboardFeatureComponentImpl(
    dashboardNavigator: DashboardNavigator,
) : DashboardFeatureComponent {

    override val dashboardViewModelFactory =
        DashboardViewModelFactory(dashboardNavigator)
}

class DashboardViewModelFactory(
    private val dashboardNavigator: DashboardNavigator,
) : Factory<DashboardViewModel> {
    override fun create(): DashboardViewModel {
        return DashboardViewModel(
            stateNavigator = StateNavigatorImpl(),
            dashboardNavigator = dashboardNavigator
        )
    }
}
