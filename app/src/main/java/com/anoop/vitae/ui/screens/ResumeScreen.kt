package com.anoop.vitae.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.anoop.common.result.ResumeResult
import com.anoop.domain.model.Resume
import com.anoop.vitae.R
import com.anoop.vitae.ui.theme.VitaeTheme
import com.anoop.vitae.ui.views.AppBar
import com.anoop.vitae.ui.views.BasicInformation
import com.anoop.vitae.ui.views.EducationSection
import com.anoop.vitae.ui.views.ReferenceSection
import com.anoop.vitae.ui.views.SectionDivider
import com.anoop.vitae.ui.views.Skills
import com.anoop.vitae.ui.views.WorkSection

@Composable
fun ResumeScreen(
    modifier: Modifier,
    onBack: () -> Unit,
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
                modifier = modifier,
                onBack = onBack
            )
        }
    }
}

@Composable
fun ResumeContent(
    modifier: Modifier,
    onBack: () -> Unit,
    resume: Resume
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            AppBar(
                title = stringResource(R.string.main_title, resume.basics.name)
            )
        }
    ) {
        val scrollState = rememberScrollState()
        Column(
            verticalArrangement = Arrangement.spacedBy(
                VitaeTheme.dimensions.sizing16
            ),
            modifier = Modifier
                .verticalScroll(scrollState)
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding(),
                    start = VitaeTheme.dimensions.sizing8,
                    end = VitaeTheme.dimensions.sizing8
                )
        ) {
            Spacer(
                modifier = Modifier.height(
                    VitaeTheme.dimensions.sizing16
                )
            )
            BasicInformation(
                basics = resume.basics
            )
            SectionDivider()
            Skills(
                skills = resume.skills
            )
            SectionDivider()
            WorkSection(
                workList = resume.work
            )
            SectionDivider()
            EducationSection(
                eduList = resume.education
            )
            SectionDivider()
            ReferenceSection(
                referenceList = resume.references
            )
            Spacer(
                modifier = Modifier.height(
                    VitaeTheme.dimensions.sizing16
                )
            )
        }
        BackHandler(
            onBack = onBack
        )
    }
}


@Preview
@Composable
fun ResumeContentPreview() {
    VitaeTheme {
        Surface {
            ResumeContent(
                modifier = Modifier.fillMaxSize(),
                onBack = {},
                resume = DummyPreviewData.dummyResume
            )
        }
    }
}