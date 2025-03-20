package com.javalenciab90.data.di

import com.javalenciab90.data.datasource.remote.WeatherRemoteData
import com.javalenciab90.data.datasource.remote.WeatherRemoteDataImpl
import com.javalenciab90.data.mappers.NetworkMapper
import com.javalenciab90.service.api.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Singleton
    @Provides
    fun provideRestApiService(retrofit: Retrofit): WeatherService {
        return retrofit.create(WeatherService::class.java)
    }

    @Provides
    fun bindsWeatherRemoteData(
        weatherService: WeatherService,
        networkMapper: NetworkMapper
    ) : WeatherRemoteData {
        return WeatherRemoteDataImpl(
            weatherService, networkMapper
        )
    }
}
