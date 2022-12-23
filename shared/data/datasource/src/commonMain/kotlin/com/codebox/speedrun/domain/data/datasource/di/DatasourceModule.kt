package com.codebox.speedrun.domain.data.datasource.di

import com.codebox.speedrun.domain.data.datasource.categories.CategoriesRepositoryImpl
import com.codebox.speedrun.domain.data.repo.CategoriesRepository
import com.codebox.speedrun.domain.networking.di.NetworkingModule

class DatasourceModule {
    private val networkingModule = NetworkingModule()

    val categoriesRepository: CategoriesRepository by lazy {
        CategoriesRepositoryImpl(networkingModule.categoriesApiService)
    }
}
