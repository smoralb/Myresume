package org.smb.resume.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class ElevationType(
    val elevationExtraSmall : Dp,
    val elevationSmall : Dp,
    val elevationMedium : Dp,
    val elevationLarge : Dp,
    val elevationExtraLarge : Dp,
)

val Elevation = ElevationType(
    elevationExtraSmall = 4.dp,
    elevationSmall = 8.dp,
    elevationMedium = 12.dp,
    elevationLarge = 14.dp,
    elevationExtraLarge = 16.dp
)