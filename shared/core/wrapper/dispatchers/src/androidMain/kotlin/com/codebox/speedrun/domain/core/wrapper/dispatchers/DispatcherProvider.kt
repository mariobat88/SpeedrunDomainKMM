package com.codebox.speedrun.domain.core.wrapper.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

actual class DefaultDispatcherProviderImpl : DispatcherProvider {
    actual override fun main(): CoroutineDispatcher = Dispatchers.Main
    actual override fun default(): CoroutineDispatcher = Dispatchers.Default
    actual override fun io(): CoroutineDispatcher = Dispatchers.IO
    actual override fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}
