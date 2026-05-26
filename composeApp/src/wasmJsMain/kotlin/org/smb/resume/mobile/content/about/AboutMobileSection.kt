package org.smb.resume.mobile.content.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.components.AnimatedSectionTitle
import org.smb.resume.ui.extensions.rememberIsVisibleEnough
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_yellow_accent
import org.smb.resume.ui.theme.color_zinc_400
import org.smb.resume.ui.theme.color_zinc_500

@Composable
fun AboutMobileSection(modifier: Modifier = Modifier) {
    val (isVisible, visibilityModifier) = rememberIsVisibleEnough()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.spacingExtraLarge, horizontal = Spacing.spacingLarge)
            .then(visibilityModifier),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingLarge)
    ) {
        Text(
            text = stringResource(Res.string.about_label),
            style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold),
            color = color_black
        )
        AnimatedSectionTitle(
            text = stringResource(Res.string.about_title),
            textStyle = Typography().headlineLarge,
            baseColor = color_black,
            hoverColor = color_yellow_accent,
            isHovered = isVisible,
            transformOrigin = TransformOrigin(0f, 0.5f)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
        ) {
            Text(
                text = stringResource(Res.string.about_p1),
                style = Typography().bodyMedium,
                color = color_zinc_500
            )
            Text(
                text = stringResource(Res.string.about_p2),
                style = Typography().bodyMedium,
                color = color_zinc_500
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge)
        ) {
            StatItem(
                number = stringResource(Res.string.about_stat1_num),
                label = stringResource(Res.string.about_stat1_label)
            )
            StatItem(
                number = stringResource(Res.string.about_stat2_num),
                label = stringResource(Res.string.about_stat2_label)
            )
            StatItem(
                number = stringResource(Res.string.about_stat3_num),
                label = stringResource(Res.string.about_stat3_label)
            )
        }
    }
}

@Composable
private fun StatItem(number: String, label: String) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(
            text = number,
            style = Typography().headlineMedium,
            color = color_black
        )
        Text(
            text = label,
            style = Typography().labelSmall,
            color = color_zinc_400
        )
    }
}