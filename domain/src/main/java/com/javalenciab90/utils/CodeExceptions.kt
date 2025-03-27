package com.javalenciab90.utils

object CodeExceptions {
    // From API directly
    const val BAD_REQUEST = 400
    const val NOT_FOUND = 404
    const val UNAUTHORIZED = 401
    const val TOO_MANY_REQUESTS = 429
    const val UNEXPECTED_ERROR = 500

    // Handle on App when Fetch data
    const val RESPONSE_BODY_NULL = -1
    const val GEO_LOCATION_MAPPER_LIST_EMPTY = -2

    // Generic Error
    const val GENERIC_ERROR = -100
}