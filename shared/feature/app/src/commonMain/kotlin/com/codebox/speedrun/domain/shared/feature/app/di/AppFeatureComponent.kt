package com.codebox.speedrun.domain.shared.feature.app.di

import com.codebox.speedrun.domain.core.navigation.StateNavigatorImpl
import com.codebox.speedrun.domain.di.Factory
import com.codebox.speedrun.domain.shared.feature.app.AppViewModel

interface AppFeatureComponent {
    val appViewModelFactory: AppViewModelFactory
}

class AppFeatureComponentImpl : AppFeatureComponent {
    override val appViewModelFactory = AppViewModelFactory()
}

class AppViewModelFactory : Factory<AppViewModel> {
    override fun create(): AppViewModel {
        return AppViewModel(
            stateNavigator = StateNavigatorImpl()
        )
    }
}
