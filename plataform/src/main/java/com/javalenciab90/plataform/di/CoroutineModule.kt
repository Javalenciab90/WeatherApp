package com.javalenciab90.plataform.di

import com.javalenciab90.plataform.base.CoroutineContextProvider
import com.javalenciab90.plataform.base.DefaultCoroutineContextProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class CoroutineModule {

    @Binds
    abstract fun bindCoroutineContextProvider(
        defaultCoroutineContextProvider: DefaultCoroutineContextProvider
    ): CoroutineContextProvider
}