package org.smb.resume.mobile.content.projects

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.common.projects.getProjects
import org.smb.resume.ui.components.ProjectCard
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_zinc_500

@Composable
fun ProjectsMobileSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.spacingExtraLarge, horizontal = Spacing.spacingLarge),
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
            Text(
                text = stringResource(Res.string.proj_title),
                style = Typography().headlineLarge,
                color = color_black,
                textAlign = TextAlign.End
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