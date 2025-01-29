package com.anoop.data.respository

import com.anoop.common.result.ResumeResult
import com.anoop.data.model.ResumeData
import com.anoop.data.service.ResumeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface ResumeRepository {
    fun getResume(): Flow<ResumeResult<ResumeData>>
}

class ResumeRepositoryImpl @Inject constructor(
    private val resumeService: ResumeService
) : ResumeRepository {
        override fun getResume() = flow {
            emit(ResumeResult.Loading)
            val result = resumeService.getResume()
            emit(ResumeResult.Success(result))
        }
        .catch { emit(ResumeResult.Error(it)) }
        .flowOn(Dispatchers.IO)
}
