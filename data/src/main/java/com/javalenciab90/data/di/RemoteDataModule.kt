package com.javalenciab90.data.di

import com.javalenciab90.data.datasource.remote.geolocation.GeoLocationRemoteData
import com.javalenciab90.data.datasource.remote.geolocation.GeoLocationRemoteDataImpl
import com.javalenciab90.data.datasource.remote.weather.WeatherRemoteData
import com.javalenciab90.data.datasource.remote.weather.WeatherRemoteDataImpl
import com.javalenciab90.data.mappers.GeoLocationNetworkMapper
import com.javalenciab90.data.mappers.WeatherNetworkMapper
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
        weatherNetworkMapper: WeatherNetworkMapper
    ) : WeatherRemoteData {
        return WeatherRemoteDataImpl(
            weatherService, weatherNetworkMapper
        )
    }

    @Provides
    fun bindsGeoLocationRemoteData(
        weatherService: WeatherService,
        geoLocationNetworkMapper: GeoLocationNetworkMapper
    ) : GeoLocationRemoteData {
        return GeoLocationRemoteDataImpl(
            weatherService, geoLocationNetworkMapper
        )
    }

}
