package com.codebox.speedrun.domain.di

import com.codebox.speedrun.domain.Platform
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * Platform specific Koin module. All build targets must
 * fulfill any platform required koin definitions specified.
 */
val platformModule = module {
    singleOf<Platform> { Platform() }
}
