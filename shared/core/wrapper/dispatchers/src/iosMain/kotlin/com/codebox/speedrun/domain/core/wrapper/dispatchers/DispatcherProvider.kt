package com.codebox.speedrun.domain.core.wrapper.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newFixedThreadPoolContext

actual class DefaultDispatcherProviderImpl : DispatcherProvider {
    actual override fun main(): CoroutineDispatcher = Dispatchers.Main
    actual override fun default(): CoroutineDispatcher = Dispatchers.Default
    actual override fun io(): CoroutineDispatcher = newFixedThreadPoolContext(64, "Dispatchers.IO")
    actual override fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}
