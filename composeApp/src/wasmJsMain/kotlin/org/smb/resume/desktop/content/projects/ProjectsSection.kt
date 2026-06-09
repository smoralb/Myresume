package org.smb.resume.desktop.content.projects

import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.common.projects.getProjects
import org.smb.resume.ui.components.AnimatedSectionTitle
import org.smb.resume.ui.components.ProjectCard
import org.smb.resume.ui.theme.*

@Composable
fun ProjectsSection(modifier: Modifier = Modifier) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 100.dp, horizontal = 80.dp)
            .hoverable(interactionSource),
        verticalArrangement = Arrangement.spacedBy(60.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = stringResource(Res.string.proj_label),
                style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold),
                color = color_black
            )
            AnimatedSectionTitle(
                text = stringResource(Res.string.proj_title),
                textStyle = Typography().headlineLarge,
                baseColor = color_black,
                hoverColor = color_blue_accent,
                isHovered = isHovered,
                textAlign = TextAlign.End,
                transformOrigin = TransformOrigin(1f, 0.5f)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
            verticalAlignment = Alignment.Top
        ) {
            getProjects().forEach { project ->
                ProjectCard(
                    modifier = Modifier.weight(1f).widthIn(max = 500.dp),
                    project = project
                )
            }
        }
    }
}
