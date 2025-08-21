package org.smb.resume.mobile.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.ic_programming
import myresume.composeapp.generated.resources.name
import myresume.composeapp.generated.resources.role
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.fonts.spaceMonoFont
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_inverse
import org.smb.resume.utils.observeWindowSize

@Composable
fun HeaderMobileView(modifier: Modifier = Modifier) {

    val (_, screenHeight) = observeWindowSize()

    Column(
        modifier = modifier.height(screenHeight.dp).padding(horizontal = Spacing.spacingLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NameSection()
        Image(
            painter = painterResource(Res.drawable.ic_programming),
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun NameSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier, verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
    ) {
        Text(
            text = stringResource(Res.string.name), style = Typography().displayLarge, fontFamily = spaceMonoFont()
        )
        Row(modifier = Modifier.padding(bottom = Spacing.spacingLarge).drawBehind { drawRect(color = Color.Black) }
            .padding(vertical = Spacing.spacingSmall, horizontal = Spacing.spacingMedium),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingExtraSmall)) {
            Text(
                text = "\\", style = Typography().headlineMedium, fontFamily = spaceMonoFont(), color = Color.Green
            )
            Text(
                text = stringResource(Res.string.role),
                style = Typography().headlineMedium,
                fontFamily = spaceMonoFont(),
                color = color_inverse
            )
        }
    }
}