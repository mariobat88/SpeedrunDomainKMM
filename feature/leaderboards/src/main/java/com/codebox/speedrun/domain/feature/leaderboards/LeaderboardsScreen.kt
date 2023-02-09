package com.codebox.speedrun.domain.feature.leaderboards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codebox.speedrun.domain.core.framework.Screen
import com.codebox.speedrun.domain.core.framework.speedrunViewModel
import com.codebox.speedrun.domain.core.ui.SpeedrunScreen
import com.codebox.speedrun.domain.di.appComponent
import com.codebox.speedrun.domain.shared.feature.leaderboards.Intent
import com.codebox.speedrun.domain.shared.feature.leaderboards.LeaderboardsViewModel
import com.codebox.speedrun.domain.shared.feature.leaderboards.ViewState
import com.codebox.speedrun.domain.shared.feature.leaderboards.navigation.LeaderboardsNavigator
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

@Composable
internal fun LeaderboardsScreen(
    gameId: String,
    leaderboardsNavigator: LeaderboardsNavigator
) {
    val appComponent = appComponent()
    val leaderboardsViewModel = speedrunViewModel{ LeaderboardsViewModel.create(appComponent, gameId, leaderboardsNavigator)}
    LeaderboardsScreen(leaderboardsViewModel)
}

@Composable
fun LeaderboardsScreen(
    viewModel: LeaderboardsViewModel
) = Screen(viewModel) { viewState, intentChannel, _ ->
    LeaderboardsScreen(viewState, intentChannel)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun LeaderboardsScreen(
    viewState: ViewState,
    intentChannel: MutableSharedFlow<Intent>,
) {
    SpeedrunScreen(
        modifier = Modifier.fillMaxSize()
    ) { screenPadding ->
        Column(
            modifier = Modifier.padding(top = screenPadding.calculateTopPadding())
        ) {
            viewState.categoriesAsync()?.let {
                val pagerState = rememberPagerState()
                val coroutineScope = rememberCoroutineScope()

                if (viewState.categoriesAsync()?.isNotEmpty() == true) {
                    LaunchedEffect(pagerState) {
                        // Collect from the pager state a snapshotFlow reading the currentPage
                        snapshotFlow { pagerState.currentPage }.collect { page ->
                            intentChannel.tryEmit(Intent.CategorySelected(page))
                        }
                    }
                }

                androidx.compose.material.ScrollableTabRow(
                    selectedTabIndex = pagerState.currentPage,
                    modifier = Modifier.fillMaxWidth(),
                    edgePadding = 0.dp,
                    backgroundColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                        )
                    }
                ) {
                    viewState.categoriesAsync()?.forEachIndexed { index, category ->
                        Tab(
                            selected = pagerState.currentPage == index,
                            onClick = { coroutineScope.launch { pagerState.scrollToPage(index) } },
                            text = {
                                Text(
                                    text = category.name,
                                    color = MaterialTheme.colorScheme.onBackground,
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}