package com.codebox.speedrun.domain.core.wrapper.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun main(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
    fun unconfined(): CoroutineDispatcher
}

expect class DefaultDispatcherProviderImpl(): DispatcherProvider {
    override fun main(): CoroutineDispatcher
    override fun default(): CoroutineDispatcher
    override fun io(): CoroutineDispatcher
    override fun unconfined(): CoroutineDispatcher
}
