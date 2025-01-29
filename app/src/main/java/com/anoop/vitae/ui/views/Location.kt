package com.anoop.vitae.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.anoop.domain.model.Location
import com.anoop.vitae.R
import com.anoop.vitae.ui.theme.VitaeTheme

@Composable
fun Location(location: Location) {
    Column(
        verticalArrangement = Arrangement.spacedBy(VitaeTheme.dimensions.spacing2)
    ) {
        Text(
            text = location.address,
            style = VitaeTheme.typography.labelSmall
        )
        Text(
            text = location.city,
            style = VitaeTheme.typography.labelSmall
        )
        Text(
            text = stringResource(
                R.string.address_sub,
                location.state,
                location.postalCode,
                location.countryCode
            ),
            style = VitaeTheme.typography.labelSmall
        )
    }
}