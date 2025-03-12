package com.javalenciab90.plataform.effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/**
 *  Use this approach when you need flexibility in how the effects are collected and handled,
    especially if you have multiple ways of handling the collected data and need to decouple the collection logic.
 *  It's ideal when you want more control over the lifecycle state of the flow collection and
    want to customize the collection behavior.
 */


@Composable
fun <Effect> CollectEffects(
    effects: Flow<Effect>,
    lifecycleOwner: LifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    collector: FlowCollector<Effect>
) {
    LaunchedEffect(effects, lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(minActiveState) {
            effects.collect(collector)
        }
    }
}

/**
 * Example!!!!!!
 *
 * // Define multiple events
 * sealed class UiEffect {
 *     data class ShowMessage(val message: String) : UiEffect()
 *     object NavigateToHome : UiEffect()
 *     data class ApiResponse(val data: String) : UiEffect()
 * }
 *
 * @Composable
 * fun ComplexEffectCollector() {
 *     // Create flows for each effect
 *     val showMessageFlow = remember { MutableSharedFlow<UiEffect.ShowMessage>() }
 *     val navigateFlow = remember { MutableSharedFlow<UiEffect.NavigateToHome>() }
 *     val apiResponseFlow = remember { MutableSharedFlow<UiEffect.ApiResponse>() }
 *
 *     // Using CollectEffects to collect and react to multiple flows
 *     CollectEffects(
 *         effects = showMessageFlow,
 *         collector = { effect ->
 *             when (effect) {
 *                 is UiEffect.ShowMessage -> {
 *                     Toast.makeText(LocalContext.current, effect.message, Toast.LENGTH_SHORT).show()
 *                 }
 *             }
 *         }
 *     )
 *
 *     CollectEffects(
 *         effects = navigateFlow,
 *         collector = {
 *             // Navigate to Home screen (Example navigation action)
 *             println("Navigating to Home screen")
 *         }
 *     )
 *
 *     CollectEffects(
 *         effects = apiResponseFlow,
 *         collector = { effect ->
 *             // Handle API response (e.g., update UI with data)
 *             println("Received API response: ${effect.data}")
 *         }
 *     )
 *
 *     // Simulate the events being emitted after some delay
 *     LaunchedEffect(Unit) {
 *         delay(1000)
 *         showMessageFlow.emit(UiEffect.ShowMessage("Welcome to the complex scenario!"))
 *         delay(1000)
 *         navigateFlow.emit(UiEffect.NavigateToHome)
 *         delay(1000)
 *         apiResponseFlow.emit(UiEffect.ApiResponse("Data from API"))
 *     }
 *
 *     // Content for the screen
 *     Column(modifier = Modifier.fillMaxSize()) {
 *         Text("Complex Effect Collector Example")
 *     }
 * }
 */