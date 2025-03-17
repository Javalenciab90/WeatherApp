package com.javalenciab90.data.di

import com.javalenciab90.data.datasource.WeatherRemoteData
import com.javalenciab90.data.datasource.WeatherRemoteDataImpl
import dagger.Binds
import dagger.Module

@Module
interface RemoteDataModule {

    @Binds
    fun bindsWeatherRemoteData(weatherRemoteDataImpl: WeatherRemoteDataImpl) : WeatherRemoteData
}
