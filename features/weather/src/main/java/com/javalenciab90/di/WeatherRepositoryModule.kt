package com.javalenciab90.di

import com.javalenciab90.domain.repository.WeatherRepositoryImpl
import com.javalenciab90.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WeatherRepositoryModule {

    @Binds
    abstract fun bindsWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl) : WeatherRepository
}