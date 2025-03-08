package org.smb.resume.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SpacingType(
    val spacingExtraSmall : Dp,
    val spacingSmall : Dp,
    val spacingMedium : Dp,
    val spacingLarge : Dp,
    val spacingExtraLarge : Dp,
)

val Spacing = SpacingType(
    spacingExtraSmall = 4.dp,
    spacingSmall = 8.dp,
    spacingMedium = 12.dp,
    spacingLarge = 14.dp,
    spacingExtraLarge = 16.dp
)