package com.sb.park.designsystem

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

sealed interface UiState<out T> {
    data object Loading : UiState<Nothing>
    data class Success<out T>(val data: T) : UiState<T>
    data class Error(val e: Throwable) : UiState<Nothing>
}

fun <T> UiState<T>.onSuccess(): T = (this as UiState.Success).data

fun <T> UiState<T>.onError(): Throwable  = (this as UiState.Error).e


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