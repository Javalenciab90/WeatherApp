package com.javalenciab90.data.datasource.remote

import com.javalenciab90.plataform.mapper.WeatherMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

/**
 * @param INPUT Should be Dto from Service.
 * @param OUTPUT Could be DomainModel or Entity
 * @param mapper to Model or Entity, this case mapping of DTO model into Entity to catch on Room later
 * @RemoteDataSource interface to implement getData( apiCall: suspend () -> Response<INPUT>)
 * is lambda function to set the apiCall.
 *
 * This API response.isSuccessful for Response or Error
 */

abstract class FetchRemoteData<INPUT, OUTPUT> : RemoteDataSource<INPUT, OUTPUT> {

    override fun getData(
        apiCall: suspend () -> Response<INPUT>,
        mapper: WeatherMapper<INPUT, OUTPUT>
    ): Flow<OUTPUT> = flow {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                response.body()?.let {
                    val weather = mapper.map(it)
                    emit(weather)
                } ?: throw RuntimeException("response body is null")
            } else {
                /**
                 * If is not Successful we need to handle the Exception
                 * capture code and message to create OWN EXCEPTIONS and
                 * handle it on ViewModel
                 */
                throw RuntimeException("${response.code()}: ${response.message()}")
            }
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }
}