package com.codebox.speedrun.domain.feature.test

import com.codebox.speedrun.domain.core.base.BaseViewModel
import com.codebox.speedrun.domain.data.repo.CategoriesRepository
import com.codebox.speedrun.domain.di.AppComponent
import com.codebox.speedrun.domain.feature.test.di.TestFeatureComponentImpl
import kotlinx.coroutines.launch

class TestViewModel(
    private val categoriesRepository: CategoriesRepository,
) : BaseViewModel() {

    companion object {
        fun create(
            appComponent: AppComponent
        ): TestViewModel {
            return TestFeatureComponentImpl(appComponent).testViewModelFactory.create()
        }
    }

    init {
        scope.launch {
            try {
                categoriesRepository.refreshCategoriesByGame("123")
                print("BATBAT")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
