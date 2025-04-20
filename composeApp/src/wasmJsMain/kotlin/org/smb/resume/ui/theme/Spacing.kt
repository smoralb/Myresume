package org.smb.resume.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SpacingType(
    val spacingNone: Dp,
    val spacingExtraSmall : Dp,
    val spacingSmall : Dp,
    val spacingMedium : Dp,
    val spacingLarge : Dp,
    val spacingExtraLarge : Dp,
)

val Spacing = SpacingType(
    spacingNone = 0.dp,
    spacingExtraSmall = 12.dp,
    spacingSmall = 14.dp,
    spacingMedium = 16.dp,
    spacingLarge = 24.dp,
    spacingExtraLarge = 42.dp
)