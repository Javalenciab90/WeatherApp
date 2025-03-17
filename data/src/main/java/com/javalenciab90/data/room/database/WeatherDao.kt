package com.javalenciab90.data.room.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.javalenciab90.data.room.entities.WeatherEntity

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherInfo(weatherEntity: WeatherEntity)

    @Query("SELECT * FROM weather_info")
    fun getWeatherInfo() : WeatherEntity
}