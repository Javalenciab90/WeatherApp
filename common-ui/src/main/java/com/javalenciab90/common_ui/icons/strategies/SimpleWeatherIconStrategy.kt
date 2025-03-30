package com.javalenciab90.common_ui.icons.strategies

import com.javalenciab90.common_ui.R
import com.javalenciab90.common_ui.icons.IconWeatherStrategy
import javax.inject.Inject

private const val SUN = "01d"
private const val MOON = "01n"
private const val FEW_CLOUDS_DAY = "02d"
private const val FEW_CLOUDS_NIGHT = "02n"
private const val SCATTERED_CLOUDS_DAY = "03d"
private const val SCATTERED_CLOUDS_NIGHT = "03n"
private const val BROKEN_CLOUDS_DAY = "04d"
private const val BROKEN_CLOUDS_NIGHT = "04n"
private const val SHOWER_RAIN_DAY = "09d"
private const val SHOWER_RAIN_NIGHT = "09n"
private const val RAIN_DAY = "10d"
private const val RAIN_NIGHT = "10n"
private const val THUNDERSTORM_DAY = "11d"
private const val THUNDERSTORM_NIGHT = "11n"
private const val SNOW_DAY = "13d"
private const val SNOW_NIGHT = "13n"
private const val MIST_DAY = "50d"
private const val MIS_NIGHT = "50n"

class SimpleWeatherIconStrategy @Inject constructor() : IconWeatherStrategy {

    private val weatherIconMap = mapOf(
        SUN to R.drawable.ic_weather_sun,
        MOON to R.drawable.ic_weather_moon_stars,
        FEW_CLOUDS_DAY to R.drawable.ic_weather_cloud_sun,
        FEW_CLOUDS_NIGHT to R.drawable.ic_weather_cloud_moon,
        SCATTERED_CLOUDS_DAY to R.drawable.ic_weather_cloud,
        SCATTERED_CLOUDS_NIGHT to R.drawable.ic_weather_cloud,
        BROKEN_CLOUDS_DAY to R.drawable.ic_weather_clouds,
        BROKEN_CLOUDS_NIGHT to R.drawable.ic_weather_clouds,
        SHOWER_RAIN_DAY to R.drawable.ic_weather_cloud_showers_heavy,
        SHOWER_RAIN_NIGHT to R.drawable.ic_weather_cloud_showers_heavy,
        RAIN_DAY to R.drawable.ic_weather_rain,
        RAIN_NIGHT to R.drawable.ic_weather_rain,
        THUNDERSTORM_DAY to R.drawable.ic_weather_thunderstorm,
        THUNDERSTORM_NIGHT to R.drawable.ic_weather_thunderstorm,
        SNOW_DAY to R.drawable.ic_weather_snow,
        SNOW_NIGHT to R.drawable.ic_weather_snow,
        MIST_DAY to R.drawable.ic_weather_mist,
        MIS_NIGHT to R.drawable.ic_weather_mist
    )

    override fun getIconWeather(iconId: String): Int {
        return weatherIconMap[iconId] ?: R.drawable.ic_generic_error
    }
}