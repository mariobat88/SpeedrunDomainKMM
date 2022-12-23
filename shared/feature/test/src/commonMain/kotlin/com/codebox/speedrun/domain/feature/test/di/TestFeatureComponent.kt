package com.codebox.speedrun.domain.feature.test.di

import com.codebox.speedrun.domain.data.repo.CategoriesRepository
import com.codebox.speedrun.domain.di.AppComponent
import com.codebox.speedrun.domain.di.Factory
import com.codebox.speedrun.domain.feature.test.TestViewModel

interface TestFeatureComponent {
    val testViewModelFactory: TestViewModelFactory
}

class TestFeatureComponentImpl(
    private val appComponent: AppComponent
) : TestFeatureComponent, AppComponent by appComponent {

    override val testViewModelFactory = TestViewModelFactory(appComponent.categoriesRepository)
}

class TestViewModelFactory(private val categoriesRepository: CategoriesRepository) : Factory<TestViewModel> {
    override fun create(): TestViewModel {
        return TestViewModel(categoriesRepository)
    }
}
