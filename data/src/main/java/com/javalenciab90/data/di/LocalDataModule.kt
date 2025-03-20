package com.javalenciab90.data.di

import android.app.Application
import androidx.room.Room
import com.javalenciab90.data.datasource.local.WeatherLocalData
import com.javalenciab90.data.datasource.local.WeatherLocalDataImpl
import com.javalenciab90.data.datasource.remote.WeatherRemoteData
import com.javalenciab90.data.datasource.remote.WeatherRemoteDataImpl
import com.javalenciab90.data.mappers.LocalMapper
import com.javalenciab90.data.mappers.NetworkMapper
import com.javalenciab90.data.room.database.WeatherDao
import com.javalenciab90.data.room.database.WeatherDatabase
import com.javalenciab90.service.api.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val NAME_DATABASE = "WeatherAppDatabase"

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    @Singleton
    fun providesWeatherDatabase(app: Application): WeatherDatabase {
        return Room.databaseBuilder(
            app,
            WeatherDatabase::class.java,
            NAME_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideMoviesDao(weatherDatabase: WeatherDatabase): WeatherDao {
        return weatherDatabase.weatherDao()
    }

    @Provides
    fun provideWeatherLocalData(
        weatherDao: WeatherDao,
        localMapper: LocalMapper
    ) : WeatherLocalData {
        return WeatherLocalDataImpl(
            weatherDao, localMapper
        )
    }
}