package com.codebox.speedrun.domain.core.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

interface StateNavigator {
    fun onNavigated(state: NavigationState)
    fun navigateUp()
    fun popToRoute(route: String)

    //fun navigateToRoute(route: String, navOptions: NavOptions? = null)
    fun navigateToRoute(route: String)

    val navigationState: StateFlow<NavigationState>
}

class StateNavigatorImpl : StateNavigator {

    private val _navigationState: MutableStateFlow<NavigationState> =
        MutableStateFlow(NavigationState.Idle)
    override val navigationState = _navigationState.asStateFlow()

    override fun onNavigated(state: NavigationState) {
        // clear navigation state, if state is the current state:
        _navigationState.update { NavigationState.Idle }
    }

    override fun popToRoute(route: String) =
        navigate(NavigationState.PopToRoute(route))

    override fun navigateUp() = navigate(NavigationState.NavigateUp())

//    override fun navigateToRoute(route: String, navOptions: NavOptions?) =
//        navigate(NavigationState.NavigateToRoute(route, navOptions))

    override fun navigateToRoute(route: String) =
        navigate(NavigationState.NavigateToRoute(route))

    private fun navigate(state: NavigationState) {
        _navigationState.update { state }
    }
}
