package com.codebox.speedrun.domain.core.wrapper.dispatchers

class DispatchersModule {
    val dispatcherProvider: DispatcherProvider by lazy {
        DefaultDispatcherProviderImpl()
    }
}
