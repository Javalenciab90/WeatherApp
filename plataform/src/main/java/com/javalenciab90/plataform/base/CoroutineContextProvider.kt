package com.javalenciab90.plataform.base

import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
data class CoroutineContextProvider(
    val mainContext: CoroutineContext,
    val backgroundContext: CoroutineContext,
    val immediateContext: CoroutineContext
) {
    @Inject
    constructor() : this(
        mainContext = Dispatchers.Main,
        backgroundContext = Dispatchers.IO,
        immediateContext = Dispatchers.Main.immediate
    )
}