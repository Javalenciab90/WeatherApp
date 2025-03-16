package com.javalenciab90.plataform.base

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class MviViewModel<STATE : Any, EFFECT : Any, INTENT : Any>(
    private val context: CoroutineContextProvider
) : ViewModel() {

    /**
     * CoroutineExceptionHandler is used to handle uncaught exceptions in coroutines,
     * which adds more robustness to the implementation.
     */
    private val handler = CoroutineExceptionHandler { _, throwable ->
        handleError(throwable)
    }

    @CallSuper
    open fun handleError(exception: Throwable) {
        //Todo: Check the way to Handle Error
    }
    private val initialState by lazy { setInitialState() }


    private val _mutableUiState = MutableStateFlow(initialState)
    val uiState = _mutableUiState.asStateFlow()
    val currentUiState: STATE get() = uiState.value

    open fun handleIntent(intent: INTENT) {}

    private val _effect: Channel<EFFECT> = Channel()
    val sideEffect = _effect.receiveAsFlow()

    abstract fun setInitialState(): STATE

    /**
     * @param mutex
     * Handles concurrency explicitly by using a Mutex to synchronize access to state.
     * This ensures that only one coroutine can modify the state at a time.
     */
    private val mutex: Mutex = Mutex()

    /**
     * There are multiple ways to update state,
     * including synchronous (updateNow), asynchronous (updateAsync),
     */
    protected fun updateAsync(reducer: (STATE) -> STATE) {
        launchInMain {
            mutex.withLock {
                _mutableUiState.update {
                    reducer(it)
                }
            }
        }
    }

    fun updateNow(reducer: (STATE) -> STATE) {
        launchInImmediate {
            mutex.withLock {
                _mutableUiState.update(reducer)
            }
        }
    }

    /**
     * The side effects are posted with postSideEffect(),
     * which runs in the main context, ensuring that side effects
     * are triggered on the UI thread.
     */
    protected fun postSideEffect(effectValue: EFFECT) {
        launchInMain {
            _effect.send(effectValue)
        }
    }

    protected fun launchInImmediate(
        onStart: (suspend () -> Unit)? = null,
        onFinish: (suspend () -> Unit)? = null,
        block: suspend CoroutineScope.() -> Unit
    ) = launch(block, Dispatchers.Main.immediate, onStart, onFinish)


    protected fun launchInMain(
        onStart: (suspend () -> Unit)? = null,
        onFinish: (suspend () -> Unit)? = null,
        block: suspend CoroutineScope.() -> Unit
    ) = launch(block, context.immediateContext, onStart, onFinish)

    protected fun launchInBackground(
        onStart: (suspend () -> Unit)? = null,
        onFinish: (suspend () -> Unit)? = null,
        block: suspend CoroutineScope.() -> Unit
    ) = launch(block, context.backgroundContext, onStart, onFinish)


    /**
     * Launching the coroutine: The launch function starts a coroutine in the viewModelScope.
     * The handler is used to catch any uncaught exceptions that might occur during the
     * execution of the coroutine.
     *
     * Context Switching: Inside the coroutine, withContext(coroutineContext)
     * is used to switch the coroutine's context to the one provided by the caller.
     * This allows the block to run on a different thread or dispatcher
     * (such as Dispatchers.Main, Dispatchers.IO, etc.).
     *
     * Executing the onStart callback: If the onStart callback is provided,
     * it is invoked before the block() starts executing.
     * This is where you could set up pre-execution work,
     * such as showing a loading indicator.
     *
     * Running the block: The main work (block()) is then executed in the coroutine.
     * This is where the main logic of the coroutine should reside.
     * Executing the onFinish callback: After the block has completed,
     * the onFinish callback is invoked, if provided.
     * This is where you might perform post-execution tasks,
     * such as hiding the loading indicator or processing results.
     */
    private fun launch(
        block: suspend CoroutineScope.() -> Unit,
        coroutineContext: CoroutineContext,
        onStart: (suspend () -> Unit)? = null,
        onFinish: (suspend () -> Unit)? = null
    ) = viewModelScope.launch(handler) {
        withContext(coroutineContext) {
            onStart?.invoke()
            block()
            onFinish?.invoke()
        }
    }
}