package com.javalenciab90.common_ui.errors.strategies

import com.javalenciab90.common_ui.R
import com.javalenciab90.common_ui.errors.ApiExceptionStrategy
import com.javalenciab90.common_ui.errors.ErrorDisplayUi
import javax.inject.Inject

class BadRequestStrategy @Inject constructor() : ApiExceptionStrategy {
    override fun getErrorDisplay(): ErrorDisplayUi {
        return ErrorDisplayUi(
            R.string.common_api_exception_title,
            R.string.common_api_exception_bad_request,
            R.drawable.ic_generic_error
        )
    }
}

class NotFoundStrategy @Inject constructor() : ApiExceptionStrategy {
    override fun getErrorDisplay(): ErrorDisplayUi {
        return ErrorDisplayUi(
            R.string.common_api_exception_title,
            R.string.common_api_exception_not_found,
            R.drawable.ic_generic_error
        )
    }
}

class UnauthorizedStrategy @Inject constructor() : ApiExceptionStrategy {
    override fun getErrorDisplay(): ErrorDisplayUi {
        return ErrorDisplayUi(
            R.string.common_api_exception_title,
            R.string.common_api_exception_unauthorized,
            R.drawable.ic_generic_error
        )
    }
}

class TooManyRequestsStrategy @Inject constructor() : ApiExceptionStrategy {
    override fun getErrorDisplay(): ErrorDisplayUi {
        return ErrorDisplayUi(
            R.string.common_api_exception_title,
            R.string.common_api_exception_too_many_requests,
            R.drawable.ic_generic_error
        )
    }
}

class ResponseBodyNullStrategy @Inject constructor() : ApiExceptionStrategy {
    override fun getErrorDisplay(): ErrorDisplayUi {
        return ErrorDisplayUi(
            R.string.common_api_exception_title,
            R.string.common_api_exception_response_body_null,
            R.drawable.ic_generic_error
        )
    }
}

class GeoLocationMapperListEmptyStrategy @Inject constructor() : ApiExceptionStrategy {
    override fun getErrorDisplay(): ErrorDisplayUi {
        return ErrorDisplayUi(
            R.string.common_api_exception_title,
            R.string.common_api_exception_geo_location_mapper_list_empty,
            R.drawable.ic_generic_error
        )
    }
}

class UnexpectedErrorStrategy @Inject constructor() : ApiExceptionStrategy {
    override fun getErrorDisplay(): ErrorDisplayUi {
        return ErrorDisplayUi(
            R.string.common_api_exception_title,
            R.string.common_api_exception_unexpected_error,
            R.drawable.ic_generic_error
        )
    }

    class GenericErrorStrategy @Inject constructor() : ApiExceptionStrategy {
        override fun getErrorDisplay(): ErrorDisplayUi {
            return ErrorDisplayUi(
                R.string.common_api_exception_title, R.string.common_default_error, R.drawable.ic_generic_error
            )
        }
    }
}