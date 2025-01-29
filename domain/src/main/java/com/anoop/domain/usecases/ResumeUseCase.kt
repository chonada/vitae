package com.anoop.domain.usecases

import com.anoop.common.result.ResumeResult
import com.anoop.data.respository.ResumeRepository
import com.anoop.domain.mapper.DataToDomainMapper.mapResumeDataToDomain
import com.anoop.domain.model.Resume
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ResumeUseCase @Inject constructor(private val resumeRepository: ResumeRepository) :
    FlowUseCase<ResumeResult<Resume>>() {
    override fun performAction(): Flow<ResumeResult<Resume>> = resumeRepository.getResume().map {
        when (it) {
            is ResumeResult.Error -> ResumeResult.Error(it.exception)
            is ResumeResult.Loading -> ResumeResult.Loading
            is ResumeResult.Success -> ResumeResult.Success(mapResumeDataToDomain(it.data))
        }
    }
}