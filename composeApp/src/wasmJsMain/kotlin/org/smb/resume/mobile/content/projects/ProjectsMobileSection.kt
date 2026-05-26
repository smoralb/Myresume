package org.smb.resume.mobile.content.projects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import org.smb.resume.ui.extensions.rememberIsVisibleEnough
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_blue_accent
import org.smb.resume.ui.theme.color_zinc_500

@Composable
fun ProjectsMobileSection(modifier: Modifier = Modifier) {
    val (isVisible, visibilityModifier) = rememberIsVisibleEnough()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.spacingExtraLarge, horizontal = Spacing.spacingLarge)
            .then(visibilityModifier),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingLarge)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
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
                isHovered = isVisible,
                textAlign = TextAlign.End,
                transformOrigin = TransformOrigin(1f, 0.5f)
            )
        }

        // Projects Grid - 1 column for mobile
        Column(
            verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
        ) {
            getProjects().forEach { project ->
                ProjectCard(project = project)
            }
        }
    }
}