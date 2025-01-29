package com.anoop.vitae.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.anoop.vitae.ui.theme.VitaeTheme

@Composable
fun SectionDivider() {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = VitaeTheme.dimensions.sizing1,
        color = VitaeTheme.colorScheme.inversePrimary
    )
}