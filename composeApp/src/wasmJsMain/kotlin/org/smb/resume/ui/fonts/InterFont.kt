package org.smb.resume.ui.fonts

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import myresume.composeapp.generated.resources.Inter_Regular
import myresume.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun interFamily() = FontFamily(
    Font(Res.font.Inter_Regular, weight = FontWeight.Normal),
)
