package com.javalenciab90.data.datasource.remote

import com.javalenciab90.mapper.DataMapper
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface RemoteDataSource<INPUT, OUTPUT> {
    fun getData(
        apiCall: suspend () -> Response<INPUT>,
        mapper: DataMapper<INPUT, OUTPUT>
    ): Flow<OUTPUT>
}