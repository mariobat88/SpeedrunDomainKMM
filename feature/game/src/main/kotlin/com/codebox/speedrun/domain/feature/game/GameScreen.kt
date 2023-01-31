package com.codebox.speedrun.domain.feature.game

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.codebox.speedrun.domain.core.framework.Screen
import com.codebox.speedrun.domain.di.SpeedrunApplicationEntryPoint
import com.codebox.speedrun.domain.shared.feature.game.GameViewModel
import com.codebox.speedrun.domain.shared.feature.game.Intent
import com.codebox.speedrun.domain.shared.feature.game.ViewState
import com.codebox.speedrun.domain.shared.feature.game.navigation.GameNavigator
import kotlinx.coroutines.flow.MutableSharedFlow

@Composable
internal fun GameScreen(
    gameId: String,
    gameNavigator: GameNavigator,
) {
    val appComponent =
        (LocalContext.current.applicationContext as SpeedrunApplicationEntryPoint).appComponent
    val gameViewModel = GameViewModel.create(gameId, gameNavigator, appComponent)
    GameScreen(gameViewModel)
}

@Composable
private fun GameScreen(
    viewModel: GameViewModel
) = Screen(viewModel) { viewState, intentChannel, _ ->
    GameScreen(viewState, intentChannel)
}

@Composable
fun GameScreen(
    viewState: ViewState,
    intentChannel: MutableSharedFlow<Intent>,
) {

}