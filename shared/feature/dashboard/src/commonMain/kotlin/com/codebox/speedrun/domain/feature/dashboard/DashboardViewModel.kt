package com.codebox.speedrun.domain.feature.dashboard

import com.codebox.speedrun.domain.core.framework.SpeedrunViewModel
import com.codebox.speedrun.domain.core.navigation.NavigationOptions
import com.codebox.speedrun.domain.core.navigation.StateNavigator
import com.codebox.speedrun.domain.feature.dashboard.di.DashboardFeatureComponentImpl
import com.codebox.speedrun.domain.feature.dashboard.navigation.DashboardNavigator
import com.codebox.speedrun.domain.feature.dashboard.navigation.DashboardSubNavigator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.onEach

class DashboardViewModel(
    private val stateNavigator: StateNavigator,
    val dashboardNavigator: DashboardNavigator,
) : SpeedrunViewModel<Unit, Intent, Unit>(
    viewState = Unit
), DashboardSubNavigator, StateNavigator by stateNavigator {

    companion object {
        fun create(
            dashboardNavigator: DashboardNavigator
        ): DashboardViewModel {
            return DashboardFeatureComponentImpl(dashboardNavigator).dashboardViewModelFactory.create()
        }
    }

    override suspend fun bind(intents: Flow<Intent>): Flow<Any> {
        return intents.filterIsInstance<Intent.NavigateToTab>()
            .onEach { intent -> navigateToTab(intent.route, intent.navigationOptions) }
    }

    override fun navigateToTab(route: String, navigationOptions: NavigationOptions) {
        stateNavigator.navigateToRoute(route, navigationOptions)
    }
}
