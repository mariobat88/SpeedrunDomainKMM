package com.codebox.speedrun.domain.feature.dashboard.feature.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.codebox.speedrun.domain.feature.dashboard.feature.search.SearchScreen

fun NavGraphBuilder.searchNavigation(searchNavigator: SearchNavigator) {
    composable(route = SearchNavigation.route) {
        SearchScreen(searchNavigator)
    }
}
