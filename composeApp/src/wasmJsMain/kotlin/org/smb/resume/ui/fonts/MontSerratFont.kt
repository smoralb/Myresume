package org.smb.resume.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import myresume.composeapp.generated.resources.Montserrat
import myresume.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun montserratFamily() = FontFamily(
    Font(Res.font.Montserrat)
)