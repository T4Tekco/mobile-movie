package com.android.t4tek.domain.result_handler

class AppError (
    var errorType: AppErrorType = AppErrorType.Unknown,
    var errorCode: String? = "",
    var errorMessage: String? = "",
)