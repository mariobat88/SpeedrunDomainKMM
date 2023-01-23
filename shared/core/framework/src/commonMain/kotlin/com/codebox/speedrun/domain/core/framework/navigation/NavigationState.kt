package com.codebox.speedrun.domain.core.framework.navigation

import kotlin.random.Random

/**
 * State that can be used to trigger navigation.
 */
sealed class NavigationState {

    /**
     * @param id is used so that multiple instances of the same route will trigger multiple navigation calls.
     */

    object Idle : NavigationState()

    data class NavigateToRoute(val route: String, val id: String = Random.nextInt().toString()) :
        NavigationState()

    /**
     * @param staticRoute is the static route to pop to, without parameter replacements.
     */
    data class PopToRoute(val staticRoute: String, val id: String = Random.nextInt().toString()) :
        NavigationState()

    data class NavigateUp(val id: String = Random.nextInt().toString()) : NavigationState()
}