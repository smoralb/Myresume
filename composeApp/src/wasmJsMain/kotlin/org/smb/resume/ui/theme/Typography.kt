package org.smb.resume.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.smb.resume.ui.fonts.interFamily
import org.smb.resume.ui.fonts.outfitFamily

@Composable
fun Typography() = Typography().run {
    val outfit = outfitFamily()
    val inter = interFamily()

    copy(
        displayLarge = TextStyle(
            fontSize = 180.sp,
            fontWeight = FontWeight.Black,
            fontFamily = outfit,
            letterSpacing = (-8).sp,
            lineHeight = (180 * 0.85).sp
        ),
        displayMedium = TextStyle(
            fontSize = 96.sp,
            fontWeight = FontWeight.Black,
            fontFamily = outfit,
            letterSpacing = (-4).sp,
            lineHeight = (96 * 0.9).sp
        ),
        displaySmall = TextStyle(
            fontFamily = outfit,
            fontWeight = FontWeight.Black,
            fontSize = 48.sp,
            letterSpacing = (-2).sp
        ),
        headlineLarge = TextStyle(
            fontSize = 48.sp,
            fontWeight = FontWeight.ExtraBold,
            fontFamily = outfit,
            letterSpacing = (-1).sp,
            lineHeight = 48.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = outfit,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            letterSpacing = (-0.5).sp
        ),
        headlineSmall = TextStyle(
            fontFamily = outfit,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp
        ),
        titleLarge = TextStyle(
            fontFamily = outfit,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        ),
        titleMedium = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = (18 * 1.6).sp
        ),
        titleSmall = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = (16 * 1.5).sp
        ),
        bodyLarge = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = (18 * 1.5).sp
        ),
        bodyMedium = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = (16 * 1.5).sp
        ),
        bodySmall = TextStyle(
            fontFamily = inter,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = (14 * 1.5).sp
        ),
        labelLarge = TextStyle(
            fontFamily = outfit,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            letterSpacing = 4.sp
        ),
        labelMedium = TextStyle(
            fontFamily = outfit,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            letterSpacing = 2.sp
        ),
        labelSmall = TextStyle(
            fontFamily = outfit,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            letterSpacing = 2.sp
        )
    )
}
