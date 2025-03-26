package com.javalenciab90.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.javalenciab90.data.room.entities.WeatherCurrentEntity
import com.javalenciab90.data.room.typeconverters.Converters

@Database(
    entities = [WeatherCurrentEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}