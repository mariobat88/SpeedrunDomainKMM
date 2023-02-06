package com.codebox.speedrun.domain.feature.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.codebox.speedrun.domain.core.framework.Screen
import com.codebox.speedrun.domain.core.framework.speedrunViewModel
import com.codebox.speedrun.domain.core.navigation.NavigationOptions
import com.codebox.speedrun.domain.core.ui.SpeedrunScreen
import com.codebox.speedrun.domain.feature.dashboard.navigation.DashboardNavigator
import com.codebox.speedrun.domain.feature.dashboard.navigation.DashboardSubNavigation
import com.codebox.speedrun.domain.feature.dashboard.R as DashboardResources

@Composable
fun DashboardScreen(
    dashboardNavigator: DashboardNavigator
) {
    val dashboardViewModel = speedrunViewModel { DashboardViewModel.create(dashboardNavigator) }
    DashboardScreen(dashboardViewModel)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardScreen(
    dashboardViewModel: DashboardViewModel,
) = Screen(dashboardViewModel) { _, intentChannel, _ ->
    val dashboardNavController = rememberNavController()
    val bottomBarHeight = dimensionResource(DashboardResources.dimen.bottom_bar_height)

    SpeedrunScreen(
        navigationBarDarkIcons = false,
    ) { screenPadding ->
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            bottomBar = {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .background(MaterialTheme.colorScheme.primary),
                    ) {
                        DashboardTabs.values().forEach { tab ->
                            Column(
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .weight(1f)
                                    .clickable {
                                        intentChannel.tryEmit(
                                            Intent.NavigateToTab(
                                                route = tab.route,
                                                navigationOptions = NavigationOptions
                                                    .Builder()
                                                    .setPopUpTo(
                                                        route = dashboardNavController.currentDestination?.route,
                                                        inclusive = true,
                                                        saveState = true
                                                    )
                                                    .setRestoreState(true)
                                                    .build()
                                            )
                                        )
                                    }
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(bottomBarHeight)
                                ) {
                                    Text(
                                        text = stringResource(tab.titleRes),
                                        modifier = Modifier.align(Alignment.Center),
                                        color = MaterialTheme.colorScheme.onPrimary,
                                    )
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(screenPadding.calculateBottomPadding())
                            .background(MaterialTheme.colorScheme.primary)
                    )
                }
            }
        ) {
            DashboardSubNavigation(
                dashboardNavigator = dashboardViewModel.dashboardNavigator,
                navController = dashboardNavController,
                dashboardViewModel = dashboardViewModel,
                modifier = Modifier.padding(
                    top = screenPadding.calculateTopPadding(),
                    bottom = screenPadding.calculateBottomPadding() + bottomBarHeight
                )
            )
        }
    }
}
