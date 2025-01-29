package com.anoop.vitae.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.anoop.domain.model.Education
import com.anoop.vitae.R
import com.anoop.vitae.ui.theme.VitaeTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EducationSection(eduList: List<Education>) =
    FlowColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(VitaeTheme.dimensions.spacing16)
    ) {
        eduList.forEach { education ->
            EducationItem(education)
        }
    }


@Composable
fun EducationItem(education: Education) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(VitaeTheme.dimensions.sizing2)
    ) {
        Text(
            text = education.institution,
            style = VitaeTheme.typography.bodyLarge
        )
        Row {
            Text(
                text = stringResource(R.string.area),
                style = VitaeTheme.typography.labelSmall,
                color = VitaeTheme.colorScheme.primary
            )
            Text(
                text = education.area,
                style = VitaeTheme.typography.labelSmall,
                color = VitaeTheme.colorScheme.secondary
            )
        }
        Text(
            text = education.studyType,
            style = VitaeTheme.typography.bodyMedium,
            color = VitaeTheme.colorScheme.primary
        )
        Text(
            text = stringResource(R.string.dates_range, education.startDate, education.endDate),
            style = VitaeTheme.typography.bodyMedium,
            color = VitaeTheme.colorScheme.secondary
        )
    }
}