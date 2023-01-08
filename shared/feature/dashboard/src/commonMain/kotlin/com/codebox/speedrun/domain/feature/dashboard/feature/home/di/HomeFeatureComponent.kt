package com.codebox.speedrun.domain.feature.dashboard.feature.home.di

import com.codebox.speedrun.domain.di.Factory
import com.codebox.speedrun.domain.feature.dashboard.feature.home.HomeViewModel

interface HomeFeatureComponent {
    val homeViewModelFactory: HomeViewModelFactory
}

class HomeFeatureComponentImpl() : HomeFeatureComponent {
    override val homeViewModelFactory = HomeViewModelFactory()
}

class HomeViewModelFactory : Factory<HomeViewModel> {
    override fun create(): HomeViewModel {
        return HomeViewModel()
    }
}
