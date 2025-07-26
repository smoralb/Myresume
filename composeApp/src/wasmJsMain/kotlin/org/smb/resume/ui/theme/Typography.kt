package org.smb.resume.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.smb.resume.ui.fonts.montserratFamily

@Composable
fun Typography() = Typography().run {
    val montserratFamily = montserratFamily()

    copy(
        displayLarge = TextStyle(
            fontSize = 100.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = montserratFamily
        ),
        displayMedium = TextStyle(
            fontSize = 54.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = montserratFamily
        ),
        displaySmall = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 36.sp,
            lineHeight = 44.sp
        ),
        headlineLarge = TextStyle(
            fontSize = 54.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = montserratFamily
        ),
        headlineMedium = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 36.sp,
            lineHeight = 44.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 28.sp,
            lineHeight = 36.sp
        ),
        titleLarge = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            lineHeight = 28.sp
        ),
        titleMedium = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),
        titleSmall = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        bodySmall = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            lineHeight = 16.sp
        ),
        labelLarge = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        labelMedium = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 16.sp
        ),
        labelSmall = TextStyle(
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Light,
            fontSize = 10.sp,
            lineHeight = 12.sp
        )
    )
}