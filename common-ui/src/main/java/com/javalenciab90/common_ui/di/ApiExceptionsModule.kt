package com.javalenciab90.common_ui.di

import com.javalenciab90.common_ui.errors.ApiExceptionStrategy
import com.javalenciab90.common_ui.errors.strategies.BadRequestStrategy
import com.javalenciab90.common_ui.errors.strategies.UnexpectedErrorStrategy
import com.javalenciab90.common_ui.errors.strategies.GeoLocationMapperListEmptyStrategy
import com.javalenciab90.common_ui.errors.strategies.NotFoundStrategy
import com.javalenciab90.common_ui.errors.strategies.ResponseBodyNullStrategy
import com.javalenciab90.common_ui.errors.strategies.TooManyRequestsStrategy
import com.javalenciab90.common_ui.errors.strategies.UnauthorizedStrategy
import com.javalenciab90.utils.CodeExceptions
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ViewModelComponent::class)
interface ApiExceptionsModule {

    @MapKey
    annotation class ApiExceptionCodeKey(val value: Int)

    @Binds
    @IntoMap
    @ApiExceptionCodeKey(value = CodeExceptions.GENERIC_ERROR)
    fun bindGenericErrorStrategy(impl: UnexpectedErrorStrategy.GenericErrorStrategy) : ApiExceptionStrategy

    @Binds
    @IntoMap
    @ApiExceptionCodeKey(value = CodeExceptions.UNEXPECTED_ERROR)
    fun bindUnexpectedErrorStrategy(impl: UnexpectedErrorStrategy) : ApiExceptionStrategy

    @Binds
    @IntoMap
    @ApiExceptionCodeKey(value = CodeExceptions.BAD_REQUEST)
    fun bindBadRequestStrategy(impl: BadRequestStrategy) : ApiExceptionStrategy

    @Binds
    @IntoMap
    @ApiExceptionCodeKey(value = CodeExceptions.NOT_FOUND)
    fun bindNotFoundStrategy(impl: NotFoundStrategy) : ApiExceptionStrategy

    @Binds
    @IntoMap
    @ApiExceptionCodeKey(value = CodeExceptions.UNAUTHORIZED)
    fun bindUnauthorizedStrategy(impl: UnauthorizedStrategy) : ApiExceptionStrategy

    @Binds
    @IntoMap
    @ApiExceptionCodeKey(value = CodeExceptions.GEO_LOCATION_MAPPER_LIST_EMPTY)
    fun bindGeoLocationMapperListEmptyStrategy(impl: GeoLocationMapperListEmptyStrategy) : ApiExceptionStrategy

    @Binds
    @IntoMap
    @ApiExceptionCodeKey(value = CodeExceptions.TOO_MANY_REQUESTS)
    fun bindTooManyRequestsStrategy(impl: TooManyRequestsStrategy) : ApiExceptionStrategy

    @Binds
    @IntoMap
    @ApiExceptionCodeKey(value = CodeExceptions.RESPONSE_BODY_NULL)
    fun bindResponseBodyNullStrategy(impl: ResponseBodyNullStrategy) : ApiExceptionStrategy
}
