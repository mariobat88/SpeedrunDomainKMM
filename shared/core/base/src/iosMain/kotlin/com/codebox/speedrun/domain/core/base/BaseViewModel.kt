package com.codebox.speedrun.domain.core.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

actual open class BaseViewModel {
    private var hasCleared = false

    actual val scope: CoroutineScope by lazy {
        val result = CloseableCoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

        if (hasCleared)
            closeWithRuntimeException(result)

        result
    }

    protected actual open fun onCleared() {}

    /**
     * Closes the [viewModelScope] and cancels all its coroutines.
     * Should be called from main thread.
     */
    fun clear() {
        hasCleared = true
        closeWithRuntimeException(scope)
        onCleared()
    }

    private fun closeWithRuntimeException(obj: Any?) {
        if (obj is Closeable) {
            try {
                obj.close()
            } catch (e: Exception) {
                throw RuntimeException(e)
            }
        }
    }

}
