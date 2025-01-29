package com.anoop.vitae.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val large: Dp = 16.dp,
    val extraLarge: Dp = 32.dp,

    val spacing0: Dp = 0.dp,
    val spacing2: Dp = 2.dp,
    val spacing4: Dp = 4.dp,
    val spacing8: Dp = 8.dp,
    val spacing16: Dp = 16.dp,
    val spacing32: Dp = 32.dp,
    val spacing64: Dp = 64.dp,
    val spacing128: Dp = 128.dp,
    val spacing256: Dp = 256.dp,

    val sizing0: Dp = 0.dp,
    val sizing1: Dp = 1.dp,
    val sizing2: Dp = 2.dp,
    val sizing4: Dp = 4.dp,
    val sizing8: Dp = 8.dp,
    val sizing16: Dp = 16.dp,
    val sizing32: Dp = 32.dp,
    val sizing64: Dp = 64.dp,
    val sizing128: Dp = 128.dp,
    val sizing256: Dp = 256.dp
)

internal val LocalDimensions = staticCompositionLocalOf { Dimensions() }