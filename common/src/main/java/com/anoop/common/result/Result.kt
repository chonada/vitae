package com.anoop.common.result

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface ResumeResult<out T> {
    data class Success<T>(val data: T) : ResumeResult<T>
    data class Error(val exception: Throwable) : ResumeResult<Nothing>
    data object Loading : ResumeResult<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<ResumeResult<T>> = map<T, ResumeResult<T>> { ResumeResult.Success(it) }
    .onStart { emit(ResumeResult.Loading) }
    .catch { emit(ResumeResult.Error(it)) }
