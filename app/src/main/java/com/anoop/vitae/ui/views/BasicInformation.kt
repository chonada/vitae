package com.anoop.vitae.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.anoop.domain.model.Basics
import com.anoop.vitae.ui.theme.VitaeTheme

@Composable
fun BasicInformation(
    basics: Basics
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            VitaeTheme.dimensions.sizing8
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = basics.email,
                    style = VitaeTheme.typography.labelSmall
                )
                Spacer(
                    modifier = Modifier.height(
                        VitaeTheme.dimensions.sizing4
                    )
                )
                Text(
                    text = basics.phone,
                    style = VitaeTheme.typography.labelSmall
                )
            }
            Location(
                location = basics.location
            )
        }
        SectionDivider()
        Text(
            text = basics.summary,
            style = VitaeTheme.typography.bodyMedium
        )
    }
}