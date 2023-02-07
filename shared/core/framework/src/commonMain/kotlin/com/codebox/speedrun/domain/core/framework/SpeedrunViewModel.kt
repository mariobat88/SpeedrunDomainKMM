package com.codebox.speedrun.domain.core.framework

import com.codebox.speedrun.domain.core.framework.async.Async
import com.codebox.speedrun.domain.core.framework.async.Fail
import com.codebox.speedrun.domain.core.framework.async.Loading
import com.codebox.speedrun.domain.core.framework.async.Success
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.reflect.KProperty1

abstract class SpeedrunViewModel<VS, I, E>(
    viewState: VS
) : BaseViewModel() {

    protected val _viewState: MutableStateFlow<VS> = MutableStateFlow(viewState)

    val intentChannel = MutableSharedFlow<I>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )

    protected val _sideEffects = Channel<E>(capacity = Int.MAX_VALUE)

    val viewState = _viewState.asStateFlow()
    val sideEffects = _sideEffects.receiveAsFlow()

    init {
        scope.launch {
            bind(intentChannel).collect()
        }
    }

    protected open suspend fun bind(intents: Flow<I>): Flow<Any> {
        return emptyFlow()
    }

    protected fun getViewState(): VS {
        return viewState.value
    }

    protected fun reduce(block: (VS) -> VS) {
        _viewState.update { block(it) }
    }

    open suspend fun onBackClicked() {}

    protected open suspend fun <T : Any?> (suspend () -> T).execute(
        retainValue: KProperty1<VS, Async<T>>? = null,
        reducer: suspend (Async<T>) -> Unit,
    ) {
        coroutineScope {
            runCatching {
                reducer(Loading(value = retainValue?.get(viewState.value)?.invoke()))
                val result = invoke()
                reducer(Success(result))
                result
            }.onFailure { ex ->
                ex.printStackTrace()
                Fail<T>(error = ex)
            }
        }
    }

    protected open suspend fun <T> Flow<T>.asAsync(
        retainValue: KProperty1<VS, Async<T>>? = null,
    ): Flow<Async<T>> {
        return this.map<T, Async<T>> { Success(it) }
            .onStart { emit(Loading(value = retainValue?.get(viewState.value)?.invoke())) }
            .catch { ex ->
                ex.printStackTrace()
                emit(Fail(error = ex))
            }
    }
}
