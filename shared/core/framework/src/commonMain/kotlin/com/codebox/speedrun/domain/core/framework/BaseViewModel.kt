package com.codebox.speedrun.domain.core.framework

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope: CoroutineScope

    protected open fun onCleared()
}