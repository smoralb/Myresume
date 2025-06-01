package org.smb.resume.ui.fonts

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.SpaceMono_Bold
import org.jetbrains.compose.resources.Font

@Composable
fun spaceMonoFont() = FontFamily(
    Font(Res.font.SpaceMono_Bold)
)