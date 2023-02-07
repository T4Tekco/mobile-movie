package com.android.t4tek.domain.result_handler

data class DataResult<T>(
    val status: StatusResult,
    var dataResult: T? = null,
    var appError: AppError? = null,
) {
    companion object {
        fun <T> resultSuccess(data: T): DataResult<T> {
            return DataResult(
                status = StatusResult.Success,
                data,
            )
        }

        fun <T> resultError(
            errorType: AppErrorType? = AppErrorType.Unknown,
            errorMessage: String? = "",
            data: T? = null
        ): DataResult<T> {
            return DataResult(
                status = StatusResult.Error,
                appError = AppError(errorType!!, errorMessage),
                dataResult = data
            )
        }
    }
}