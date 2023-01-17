package com.example.rawg.base.data

/**
 * @author SamuelSep on 4/20/2021.
 */
enum class ResponseStatus {
    SUCCESS,
    ERROR,
    LOADING
}

data class ResultState<out T>(
    val status: ResponseStatus,
    val data: T?,
    val message: String?
) {
    companion object {
        fun <T> success(data: T, message: String? = null): ResultState<T> =
                ResultState(status = ResponseStatus.SUCCESS, data = data, message = message)

        fun <T> error(data: T?, message: String): ResultState<T> =
                ResultState(status = ResponseStatus.ERROR, data = data, message = message)

        fun <T> loading(data: T?): ResultState<T> =
                ResultState(status = ResponseStatus.LOADING, data = data, message = null)
    }
}

