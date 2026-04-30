package org.smb.resume.mobile.header

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_zinc_400
import org.smb.resume.ui.theme.color_zinc_500

@Composable
fun HeaderMobileView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.spacingExtraLarge, horizontal = Spacing.spacingLarge),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingLarge)
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
                style = Typography().bodyMedium,
                color = color_zinc_500,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }
        Text(
            text = stringResource(Res.string.hero_scroll),
            style = Typography().labelMedium,
            color = color_zinc_400
        )
    }
}