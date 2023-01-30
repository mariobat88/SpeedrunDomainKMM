package com.speedrun.domain.core.framework

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.codebox.speedrun.domain.core.framework.SpeedrunViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

@Composable
private fun <ViewState : Any, Intent : Any, SideEffect : Any> RegisterBackHandler(viewModel: SpeedrunViewModel<ViewState, Intent, SideEffect>) {
    val backHandlerScope = rememberCoroutineScope()
    BackHandler(true) {
        backHandlerScope.launch { viewModel.onBackClicked() }
    }
}

@Composable
fun <ViewState : Any, Intent : Any, SideEffect : Any> Compose(
    viewModel: SpeedrunViewModel<ViewState, Intent, SideEffect>,
    block: @Composable (viewState: ViewState, intentChannel: MutableSharedFlow<Intent>, sideEffects: Flow<SideEffect>) -> Unit,
) {
    block(
        viewModel.viewState.collectAsStateWithLifecycle().value,
        viewModel.intentChannel,
        viewModel.sideEffects
    )
}

@Composable
fun <ViewState : Any, Intent : Any, SideEffect : Any> Screen(
    viewModel: SpeedrunViewModel<ViewState, Intent, SideEffect>,
    block: @Composable (viewState: ViewState, intentChannel: MutableSharedFlow<Intent>, sideEffects: Flow<SideEffect>) -> Unit,
) {
    //RegisterBackHandler(viewModel)
    block(
        viewModel.viewState.collectAsStateWithLifecycle().value,
        viewModel.intentChannel,
        viewModel.sideEffects
    )
}

@Composable
fun Navigation(
    navController: NavController,
    stateNavigator: com.codebox.speedrun.domain.core.navigation.StateNavigator
) {
    when (val navigationState = stateNavigator.navigationState.collectAsState().value) {
        is com.codebox.speedrun.domain.core.navigation.NavigationState.NavigateToRoute -> {
            //navController.navigate(navigationState.route, navigationState.navOptions)
            navController.navigate(navigationState.route)
            stateNavigator.onNavigated(navigationState)
        }
        is com.codebox.speedrun.domain.core.navigation.NavigationState.PopToRoute -> {
            navController.popBackStack(navigationState.staticRoute, false)
            stateNavigator.onNavigated(navigationState)
        }
        is com.codebox.speedrun.domain.core.navigation.NavigationState.NavigateUp -> {
            navController.navigateUp()
        }
        is com.codebox.speedrun.domain.core.navigation.NavigationState.Idle -> {
        }
    }
}
