package com.codebox.speedrun.domain.shared.feature.leaderboards.di

import com.codebox.speedrun.domain.di.AppComponent
import com.codebox.speedrun.domain.di.Factory
import com.codebox.speedrun.domain.shared.feature.leaderboards.LeaderboardsViewModel
import com.codebox.speedrun.domain.shared.feature.leaderboards.navigation.LeaderboardsNavigator

interface LeaderboardsFeatureComponent {
    val leaderboardsViewModelFactory: LeaderboardsViewModelFactory
}

class LeaderboardsFeatureComponentImpl(
    appComponent: AppComponent,
    gameId: String,
    leaderboardsNavigator: LeaderboardsNavigator,
) : LeaderboardsFeatureComponent {

    override val leaderboardsViewModelFactory = LeaderboardsViewModelFactory(appComponent, gameId, leaderboardsNavigator)
}

class LeaderboardsViewModelFactory(
    private val appComponent: AppComponent,
    private val gameId: String,
    private val leaderboardsNavigator: LeaderboardsNavigator,
) : Factory<LeaderboardsViewModel> {
    override fun create(): LeaderboardsViewModel {
        return LeaderboardsViewModel(
            gameId = gameId,
            leaderboardsNavigator = leaderboardsNavigator,
            categoriesRepository = appComponent.categoriesRepository,
            dispatcherProvider = appComponent.dispatcherProvider
        )
    }
}
