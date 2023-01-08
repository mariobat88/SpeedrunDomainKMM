package com.codebox.speedrun.domain.feature.dashboard.feature.search.di

import com.codebox.speedrun.domain.di.AppComponent
import com.codebox.speedrun.domain.di.Factory
import com.codebox.speedrun.domain.feature.dashboard.feature.search.SearchViewModel
import com.codebox.speedrun.domain.feature.dashboard.feature.search.navigation.SearchNavigator

interface SearchFeatureComponent {
    val searchViewModelFactory: SearchViewModelFactory
}

class SearchFeatureComponentImpl(
    appComponent: AppComponent,
    searchNavigator: SearchNavigator,
) : SearchFeatureComponent {

    override val searchViewModelFactory =
        SearchViewModelFactory(appComponent, searchNavigator)
}

class SearchViewModelFactory(
    private val appComponent: AppComponent,
    private val searchNavigator: SearchNavigator,
) : Factory<SearchViewModel> {
    override fun create(): SearchViewModel {
        return SearchViewModel(
            searchNavigator = searchNavigator,
            gamesRepository = appComponent.gamesRepository
        )
    }
}
