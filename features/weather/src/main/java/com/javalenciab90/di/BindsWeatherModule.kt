package com.javalenciab90.di

import com.javalenciab90.domain.repository.geo.GeoLocationRepositoryImpl
import com.javalenciab90.domain.repository.geo.GeoLocationRepository
import com.javalenciab90.domain.repository.weather.WeatherRepository
import com.javalenciab90.domain.repository.weather.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsWeatherModule {

    @Binds
    abstract fun bindsWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl) : WeatherRepository

    @Binds
    abstract fun bindsGeoLocationRepository(geoLocationRepository: GeoLocationRepositoryImpl) : GeoLocationRepository
}