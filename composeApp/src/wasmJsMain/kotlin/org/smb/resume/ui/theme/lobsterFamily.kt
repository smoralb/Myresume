package org.smb.resume.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import myresume.composeapp.generated.resources.Lobster_Regular
import myresume.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun lobsterFamily() = FontFamily(
    Font(Res.font.Lobster_Regular)
)