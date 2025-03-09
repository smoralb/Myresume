package org.smb.resume.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Typography() = Typography().run {
    val montserratFamily = montserratFamily()

    copy(
        displayLarge = TextStyle(
            fontSize = 56.sp,
            fontWeight = FontWeight.W600,
            fontFamily = montserratFamily
        ),
        displayMedium,
        displaySmall,
        headlineLarge,
        headlineMedium,
        headlineSmall,
        titleLarge,
        titleMedium,
        titleSmall,
        bodyLarge,
        bodyMedium,
        bodySmall,
        labelLarge,
        labelMedium = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            fontFamily = montserratFamily
        ),
        labelSmall
    )
}