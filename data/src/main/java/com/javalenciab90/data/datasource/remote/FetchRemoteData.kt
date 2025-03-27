package com.javalenciab90.data.datasource.remote

import com.javalenciab90.mapper.DataMapper
import com.javalenciab90.utils.ApiException
import com.javalenciab90.utils.CodeExceptions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

/**
 * @param INPUT Should be Dto from Service.
 * @param OUTPUT Could be DomainModel or Entity
 * @param mapper to Model or Entity, this case mapping of DTO model into Model to catch on Room later
 * @RemoteDataSource interface to implement getData( apiCall: suspend () -> Response<INPUT>)
 * is lambda function to set the apiCall.
 */

abstract class FetchRemoteData<INPUT, OUTPUT> : RemoteDataSource<INPUT, OUTPUT> {

    override fun getData(
        apiCall: suspend () -> Response<INPUT>,
        mapper: DataMapper<INPUT, OUTPUT>
    ): Flow<OUTPUT> = flow {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                response.body()?.let {
                    val weather = mapper.map(it)
                    emit(weather)
                } ?: throw ApiException(
                        errorCode = CodeExceptions.RESPONSE_BODY_NULL,
                        message = "Response body is null"
                )
            } else {
                throw ApiException(
                    errorCode = response.code(),
                    message = response.message()
                )
            }
        } catch (apiException: ApiException) {
            throw apiException
        } catch (e: Exception) {
            throw RuntimeException("Unexpected error: ${e.message}")
        }
    }
}