package com.javalenciab90.data.datasource.remote

import com.javalenciab90.plataform.mapper.WeatherMapper
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RemoteDataSource<INPUT, OUTPUT> {
    fun getData(
        apiCall: suspend () -> Response<INPUT>,
        mapper: WeatherMapper<INPUT, OUTPUT>
    ): Flow<OUTPUT>
}