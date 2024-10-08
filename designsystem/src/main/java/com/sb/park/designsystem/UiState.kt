package com.sb.park.designsystem

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart

@Stable
sealed interface UiState<out T> {
    @Immutable
    data object Loading : UiState<Nothing>
    @Immutable
    data class Success<out T>(val data: T) : UiState<T>
    @Immutable
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