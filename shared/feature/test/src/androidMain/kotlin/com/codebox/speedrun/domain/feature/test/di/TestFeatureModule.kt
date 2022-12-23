package com.codebox.speedrun.domain.feature.test.di

import com.codebox.speedrun.domain.feature.test.TestViewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual val testFeatureModule: Module = module {
    factory { TestViewModel(get()) }
}
