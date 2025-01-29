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
import com.anoop.domain.model.Work
import com.anoop.vitae.R
import com.anoop.vitae.ui.theme.VitaeTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WorkSection(workList: List<Work>) =
    FlowColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(VitaeTheme.dimensions.spacing16)
    ) {
        workList.forEach { work ->
            WorkItem(work)
        }
    }


@Composable
fun WorkItem(work: Work) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(VitaeTheme.dimensions.sizing2)
    ) {
        Text(
            text = work.company,
            style = VitaeTheme.typography.bodyLarge
        )
        Row {
            Text(
                text = stringResource(R.string.work_position),
                style = VitaeTheme.typography.labelSmall,
                color = VitaeTheme.colorScheme.primary
            )
            Text(
                text = work.position,
                style = VitaeTheme.typography.labelSmall,
                color = VitaeTheme.colorScheme.secondary
            )
        }
        Text(
            text = work.summary,
            style = VitaeTheme.typography.bodySmall,
            color = VitaeTheme.colorScheme.primary
        )
        Text(
            text = stringResource(R.string.dates_range, work.startDate, work.endDate),
            style = VitaeTheme.typography.bodyMedium,
            color = VitaeTheme.colorScheme.secondary
        )
    }
}