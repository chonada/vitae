package com.anoop.vitae.ui.screens

class ResumeViewModelContract {
    sealed interface ResumeUiState {
        data object Loading : ResumeUiState
        data class Error(val throwable: Throwable) : ResumeUiState
        data class Success(val data: List<String>) : ResumeUiState
    }
}
