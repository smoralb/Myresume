package org.smb.resume.desktop.content.hero

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_zinc_400
import org.smb.resume.ui.theme.color_zinc_500

@Composable
fun HeroSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 120.dp, horizontal = 80.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text(
            text = stringResource(Res.string.hero_label),
            style = Typography().labelLarge,
            color = color_zinc_400
        )
        Text(
            text = stringResource(Res.string.hero_name_1),
            style = Typography().displayLarge,
            color = color_black
        )
        Text(
            text = stringResource(Res.string.hero_name_2),
            style = Typography().displayLarge,
            color = color_black
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = stringResource(Res.string.hero_desc),
                style = Typography().bodyLarge,
                color = color_zinc_500,
                modifier = Modifier.widthIn(max = 500.dp)
            )
            Text(
                text = stringResource(Res.string.hero_scroll),
                style = Typography().labelMedium,
                color = color_zinc_400
            )
        }
    }
}
