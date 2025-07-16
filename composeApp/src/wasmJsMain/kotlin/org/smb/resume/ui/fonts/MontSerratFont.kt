package org.smb.resume.ui.fonts

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import myresume.composeapp.generated.resources.Montserrat
import myresume.composeapp.generated.resources.MontserratExtraBold
import myresume.composeapp.generated.resources.MontserratSemiBold
import myresume.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun montserratFamily() = FontFamily(
    Font(Res.font.Montserrat, weight = FontWeight.Normal),
    Font(Res.font.MontserratExtraBold, weight = FontWeight.ExtraBold),
    Font(Res.font.MontserratSemiBold, weight = FontWeight.SemiBold)
)