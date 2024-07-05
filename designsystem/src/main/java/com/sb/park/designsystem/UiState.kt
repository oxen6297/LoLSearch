package com.sb.park.designsystem

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

sealed interface UiState<out T> {
    data object Loading : UiState<Nothing>
    data class Success<out T>(val data: T?) : UiState<T>
    data class Error(val e: Throwable) : UiState<Nothing>
}

fun <T> UiState<T>.onSuccess(): T? = if (this is UiState.Success<T>) {
    data
} else {
    null
}

fun <T> UiState<T>.onError(): Throwable? = if (this is UiState.Error) {
    e
} else {
    null
}

inline fun <T> safeFlow(
    crossinline service: suspend () -> T
): Flow<UiState<T>> = flow<UiState<T>> {
    emit(UiState.Success(service()))
}.onStart {
    emit(UiState.Loading)
}.catch {
    it.printStackTrace()
    emit(UiState.Error(it))
}