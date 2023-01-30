package com.codebox.speedrun.domain.core.navigation

import androidx.navigation.NavOptions

fun NavigationOptions.toNavOptions() = NavOptions.Builder()
    .setLaunchSingleTop(singleTop = singleTop)
    .setRestoreState(restoreState = restoreState)
    .setPopUpTo(
        route = popUpToRoute,
        inclusive = popUpToInclusive,
        saveState = popUpToSaveState,
    )
    .setEnterAnim(enterAnim = enterAnim)
    .setExitAnim(exitAnim = exitAnim)
    .setPopEnterAnim(popEnterAnim = popEnterAnim)
    .setPopExitAnim(popExitAnim = popExitAnim)
    .build()