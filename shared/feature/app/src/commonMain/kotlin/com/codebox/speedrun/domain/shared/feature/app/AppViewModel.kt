package com.codebox.speedrun.domain.shared.feature.app

import com.codebox.speedrun.domain.core.framework.BaseViewModel
import com.codebox.speedrun.domain.core.navigation.StateNavigator
import com.codebox.speedrun.domain.shared.feature.app.di.AppFeatureComponentImpl
import com.codebox.speedrun.domain.shared.feature.app.navigation.AppNavigator

class AppViewModel constructor(
    private val stateNavigator: StateNavigator,
) : BaseViewModel(), AppNavigator, StateNavigator by stateNavigator {

    companion object {
        fun create(): AppViewModel {
            return AppFeatureComponentImpl().appViewModelFactory.create()
        }
    }

//    override fun backClicked() {
//        stateNavigator.navigateUp()
//    }

    override fun navigateToGameScreen(gameId: String) {
        //stateNavigator.navigateToRoute(GameNavigation(gameId))
    }

//    override fun navigateToLeaderboardsScreen(gameId: String) {
//        stateNavigator.navigateToRoute(LeaderboardsNavigation(gameId))
//    }
//
//    override fun navigateToRunScreen(runId: String) {
//        stateNavigator.navigateToRoute(RunNavigation(runId))
//    }
//
//    override fun navigateToPlayerScreen(playerId: String) {
//        stateNavigator.navigateToRoute(PlayerNavigation(playerId))
//    }
}
