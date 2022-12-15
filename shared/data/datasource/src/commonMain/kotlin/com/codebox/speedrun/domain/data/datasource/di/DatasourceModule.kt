package com.codebox.speedrun.domain.data.datasource.di

import com.codebox.speedrun.domain.data.datasource.categories.CategoriesRepositoryImpl
import com.codebox.speedrun.domain.data.repo.CategoriesRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val datasourceModule: Module = module {
    single<CategoriesRepository> { CategoriesRepositoryImpl(get()) }
}
