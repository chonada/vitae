package com.anoop.vitae.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.anoop.common.result.ResumeResult
import com.anoop.domain.model.Resume

@Composable
fun ResumeScreen(
    modifier: Modifier,
    viewModel: ResumeViewModel = hiltViewModel()
) {
    val viewState = viewModel.viewState.collectAsStateWithLifecycle()

    when (val result = viewState.value) {
        is ResumeResult.Error -> {
            ErrorScreen()
        }
        ResumeResult.Loading -> {
            LoadingScreen()
        }
        is ResumeResult.Success -> {
            ResumeContent(
                resume = result.data,
                modifier = modifier
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResumeContent(
    modifier: Modifier,
    resume: Resume
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Resume") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {

        }
    }
}