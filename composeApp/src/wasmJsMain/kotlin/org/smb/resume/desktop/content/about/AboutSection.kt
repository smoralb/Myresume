package org.smb.resume.desktop.content.about

import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.components.AnimatedSectionTitle
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_yellow_accent
import org.smb.resume.ui.theme.color_zinc_400
import org.smb.resume.ui.theme.color_zinc_500

@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 100.dp, horizontal = 80.dp)
            .hoverable(interactionSource),
        horizontalArrangement = Arrangement.spacedBy(80.dp)
    ) {
        // Left column
        Column(
            modifier = Modifier.width(400.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
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
                isHovered = isHovered,
                transformOrigin = TransformOrigin(0f, 0.5f)
            )
        }

        // Right column
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text(
                text = stringResource(Res.string.about_p1),
                style = Typography().titleMedium,
                color = color_zinc_500
            )
            Text(
                text = stringResource(Res.string.about_p2),
                style = Typography().titleMedium,
                color = color_zinc_500
            )
            // Stats row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(60.dp)
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
}

@Composable
private fun StatItem(number: String, label: String) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            text = number,
            style = Typography().displaySmall,
            color = color_black
        )
        Text(
            text = label,
            style = Typography().labelSmall,
            color = color_zinc_400
        )
    }
}
