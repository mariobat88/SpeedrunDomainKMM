package com.codebox.speedrun.domain.feature.dashboard.feature.home

import com.codebox.speedrun.domain.core.framework.SpeedrunViewModel
import kotlinx.coroutines.launch

class HomeViewModel() : SpeedrunViewModel<ViewState, Intent, Unit>(
    viewState = ViewState()
) {

    init {
        scope.launch {

        }
    }
}