package org.smb.resume.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.common.projects.ProjectUiModel
import org.smb.resume.ui.theme.Elevation
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_white
import org.smb.resume.ui.theme.color_zinc_100
import org.smb.resume.ui.theme.color_zinc_400
import org.smb.resume.ui.theme.color_zinc_500

@Composable
fun ProjectCard(modifier: Modifier = Modifier, project: ProjectUiModel) {
    if (project.isCompact) {
        // Minimal placeholder card with dashed border
        Box(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 180.dp)
                .drawBehind {
                    drawRoundRect(
                        color = color_zinc_400,
                        style = Stroke(
                            width = 2f,
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
                        ),
                        cornerRadius = CornerRadius(12.dp.toPx())
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(Spacing.spacingMedium)
            ) {
                Text(
                    text = stringResource(project.title),
                    style = Typography().titleLarge,
                    color = color_zinc_500
                )
                Spacer(modifier = Modifier.height(Spacing.spacingSmall))
                Text(
                    text = stringResource(project.description),
                    style = Typography().bodyMedium,
                    color = color_zinc_500
                )
            }
        }
    } else {
        // Full project card
        ElevatedCard(
            modifier = modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = Elevation.elevationLarge),
            colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Spacing.spacingMedium)
            ) {
                if (project.imageUrl != null) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(color_zinc_100),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier.fillMaxWidth().height(200.dp),
                            painter = painterResource(project.imageUrl),
                            alignment = Alignment.Center,
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )
                    }
                    Spacer(modifier = Modifier.height(Spacing.spacingMedium))
                }
                Text(
                    text = stringResource(project.tag),
                    style = Typography().labelSmall,
                    color = color_zinc_500
                )
                Spacer(modifier = Modifier.height(Spacing.spacingSmall))
                Text(
                    text = stringResource(project.title),
                    style = Typography().titleLarge,
                    color = color_black
                )
                Spacer(modifier = Modifier.height(Spacing.spacingSmall))
                Text(
                    text = stringResource(project.description),
                    style = Typography().bodyMedium,
                    color = color_zinc_500
                )
                Spacer(modifier = Modifier.height(Spacing.spacingMedium))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color_black)
                        .then(
                            if (project.url != null)
                                Modifier.clickable { window.open(project.url, "_blank") }
                            else Modifier
                        )
                        .padding(vertical = 14.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(project.linkText),
                        style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = if (project.url != null) color_white else color_zinc_500
                    )
                }
            }
        }
    }
}
