package com.anoop.vitae.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.anoop.domain.model.Reference
import com.anoop.vitae.R
import com.anoop.vitae.ui.theme.VitaeTheme

@Composable
fun ReferenceSection(referenceList: List<Reference>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            VitaeTheme.dimensions.spacing16
        )
    ) {
        Text(
            text = stringResource(R.string.references),
            style = VitaeTheme.typography.headlineMedium
        )
        referenceList.forEach { reference ->
            ReferenceItem(reference)
        }
    }
}

@Composable
private fun ReferenceItem(reference: Reference) =
    Column(
        verticalArrangement = Arrangement.spacedBy(
            VitaeTheme.dimensions.sizing4
        )
    ) {
        Text(
            text = reference.name,
            style = VitaeTheme.typography.bodySmall
        )
        Text(
            text = reference.reference,
            style = VitaeTheme.typography.bodyMedium
        )
    }