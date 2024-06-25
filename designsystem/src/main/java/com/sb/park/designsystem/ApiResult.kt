package com.sb.park.designsystem

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

sealed class ApiResult<out T> {
    data object Loading : ApiResult<Nothing>()
    data class Success<out T>(val data: T?) : ApiResult<T>()
    data class Error(val e: Throwable) : ApiResult<Nothing>()
}

inline fun <T> safeFlow(crossinline service: suspend () -> T): Flow<ApiResult<T>> =
    flow<ApiResult<T>> {
        emit(ApiResult.Success(service()))
    }.onStart {
        emit(ApiResult.Loading)
    }.catch {
        it.printStackTrace()
        emit(ApiResult.Error(it))
    }.flowOn(Dispatchers.IO)