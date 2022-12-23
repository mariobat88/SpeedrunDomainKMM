package com.codebox.speedrun.domain.data.datasource.di

import com.codebox.speedrun.domain.data.datasource.categories.CategoriesRepositoryImpl
import com.codebox.speedrun.domain.data.repo.CategoriesRepository
import com.codebox.speedrun.domain.networking.di.NetworkingModule2

interface DatasourceComponent {
    val categoriesRepository: CategoriesRepository
}

class DatasourceComponentImpl : DatasourceComponent {

    override val categoriesRepository: CategoriesRepository by lazy {
        CategoriesRepositoryImpl(NetworkingModule2.categoriesApiService)
    }
}
