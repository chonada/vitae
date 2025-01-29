package com.anoop.vitae.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anoop.common.result.ResumeResult
import com.anoop.domain.model.Resume
import com.anoop.domain.usecases.ResumeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResumeViewModel @Inject constructor(
    private val resumeUseCase: ResumeUseCase
) : ViewModel() {
    private val _viewState = resumeUseCase.resultFlow

    val viewState: StateFlow<ResumeResult<Resume>> = _viewState
        .stateIn(
            viewModelScope, SharingStarted.WhileSubscribed(),
            ResumeResult.Loading
        )

    private fun fetchResume() {
        viewModelScope.launch {
            resumeUseCase.launch()
        }
    }

    init {
        fetchResume()
    }
}