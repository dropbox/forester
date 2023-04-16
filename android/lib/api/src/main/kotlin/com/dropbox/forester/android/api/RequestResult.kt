package com.dropbox.forester.android.api

sealed class RequestResult<out Output : Any> {
    data class Success<Output : Any>(
        val data: Output
    ) : RequestResult<Output>()

    data class Failure(
        val error: Throwable
    ) : RequestResult<Nothing>()
}