package org.smb.resume.ui.fonts

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import myresume.composeapp.generated.resources.Outfit_Black
import myresume.composeapp.generated.resources.Outfit_Bold
import myresume.composeapp.generated.resources.Outfit_ExtraBold
import myresume.composeapp.generated.resources.Outfit_Medium
import myresume.composeapp.generated.resources.Outfit_Regular
import myresume.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun outfitFamily() = FontFamily(
    Font(Res.font.Outfit_Regular, weight = FontWeight.Normal),
    Font(Res.font.Outfit_Medium, weight = FontWeight.Medium),
    Font(Res.font.Outfit_Bold, weight = FontWeight.Bold),
    Font(Res.font.Outfit_ExtraBold, weight = FontWeight.ExtraBold),
    Font(Res.font.Outfit_Black, weight = FontWeight.Black),
)
