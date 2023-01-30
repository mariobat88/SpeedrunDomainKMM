package com.codebox.speedrun.domain.core.navigation

class NavigationOptions internal constructor(
    val singleTop: Boolean,
    val restoreState: Boolean,
    val popUpToInclusive: Boolean,
    val popUpToSaveState: Boolean,
    val enterAnim: Int = -1,
    val exitAnim: Int = -1,
    val popEnterAnim: Int = -1,
    val popExitAnim: Int = -1,
) {

    var popUpToRoute: String? = null
        private set

    internal constructor(
        singleTop: Boolean,
        restoreState: Boolean,
        popUpToRoute: String?,
        popUpToInclusive: Boolean,
        popUpToSaveState: Boolean,
        enterAnim: Int,
        exitAnim: Int,
        popEnterAnim: Int,
        popExitAnim: Int
    ) : this(
        singleTop,
        restoreState,
        popUpToInclusive,
        popUpToSaveState,
        enterAnim,
        exitAnim,
        popEnterAnim,
        popExitAnim
    ) {
        this.popUpToRoute = popUpToRoute
    }

    class Builder {
        private var singleTop = false
        private var restoreState = false

        private var popUpToId = -1
        private var popUpToRoute: String? = null
        private var popUpToInclusive = false
        private var popUpToSaveState = false

        private val enterAnim: Int = -1
        private val exitAnim: Int = -1
        private val popEnterAnim: Int = -1
        private val popExitAnim: Int = -1

        fun setRestoreState(restoreState: Boolean): Builder {
            this.restoreState = restoreState
            return this
        }

        fun setPopUpTo(
            route: String?,
            inclusive: Boolean,
            saveState: Boolean = false
        ): Builder {
            popUpToRoute = route
            popUpToId = -1
            popUpToInclusive = inclusive
            popUpToSaveState = saveState
            return this
        }

        fun build(): NavigationOptions {
            return NavigationOptions(
                singleTop, restoreState,
                popUpToRoute, popUpToInclusive, popUpToSaveState,
                enterAnim, exitAnim, popEnterAnim, popExitAnim
            )
        }
    }
}