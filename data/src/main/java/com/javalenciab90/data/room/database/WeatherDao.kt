package com.javalenciab90.data.room.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.javalenciab90.data.room.entities.WeatherCurrentEntity

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherInfo(weatherEntity: WeatherCurrentEntity)

    /**
     * The @Query get Entity when name fields contains the query.
     */
    @Query("SELECT * FROM weather_table WHERE name LIKE '%' || :query || '%' LIMIT 1")
    fun getWeatherInfo(query: String): WeatherCurrentEntity?
}