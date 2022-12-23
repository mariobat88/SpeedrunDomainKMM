package com.codebox.speedrun.domain.core.base

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope: CoroutineScope

    protected open fun onCleared()
}