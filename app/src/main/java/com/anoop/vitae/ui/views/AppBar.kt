package com.anoop.vitae.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.anoop.vitae.R
import com.anoop.vitae.ui.theme.VitaeTheme
import androidx.compose.ui.unit.Dp as DP


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String,
    navigationType: AppBarNavigationType = AppBarNavigationType.None,
    elevation: DP = AppBarConfiguration.ElevationSmall
) {
    CenterAlignedTopAppBar(
        modifier = modifier.shadow(elevation),
        title = {
            Text(
                text = title,
                style = VitaeTheme.typography.headlineLarge
            )
        },
        navigationIcon = {
            navigationType.Button()
        }
    )
}

object AppBarConfiguration {
    val ElevationNone = 0.dp
    val ElevationSmall = 4.dp
}

sealed class AppBarNavigationType {
    data object None : AppBarNavigationType()
    data class Close(val onClose: () -> Unit) : AppBarNavigationType()
    data class Back(val onBack: () -> Unit) : AppBarNavigationType()

    @Composable
    fun Button() {
        return when (this) {
            is Close -> NavigateCloseButton(onClose)
            is Back -> NavigateUpButton(onBack)
            is None -> Unit
        }
    }
}

@Composable
private fun NavigateUpButton(navigateUp: () -> Unit) = IconButton(
    onClick = navigateUp,
    modifier = Modifier.padding(horizontal = 8.dp)
) {
    Icon(
        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = stringResource(R.string.navigate_up),
        tint = VitaeTheme.colorScheme.onSurface
    )
}

@Composable
private fun NavigateCloseButton(close: () -> Unit) = IconButton(
    onClick = close,
    modifier = Modifier.padding(horizontal = 8.dp)
) {
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = stringResource(R.string.navigate_up),
        tint = VitaeTheme.colorScheme.onSurface
    )
}