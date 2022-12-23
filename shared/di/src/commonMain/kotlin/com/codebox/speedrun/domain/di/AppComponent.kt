package com.codebox.speedrun.domain.di

import com.codebox.speedrun.domain.data.datasource.di.DatasourceModule
import com.codebox.speedrun.domain.data.repo.CategoriesRepository

interface AppComponent {
    val datasourceModule: DatasourceModule
    val categoriesRepository: CategoriesRepository
}

class AppComponentImpl : AppComponent {

    override val datasourceModule by lazy {
        DatasourceModule()
    }

    override val categoriesRepository: CategoriesRepository by lazy {
        datasourceModule.categoriesRepository
    }
}
