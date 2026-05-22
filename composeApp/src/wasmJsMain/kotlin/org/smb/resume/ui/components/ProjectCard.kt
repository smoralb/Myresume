package org.smb.resume.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.common.projects.ProjectUiModel
import org.smb.resume.ui.theme.Elevation
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_zinc_500

@Composable
fun ProjectCard(modifier: Modifier = Modifier, project: ProjectUiModel) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.elevationLarge
        ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Spacing.spacingLarge),
            verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                painter = painterResource(project.imageUrl),
                alignment = Alignment.Center,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(project.tag),
                style = Typography().labelSmall,
                color = color_zinc_500
            )
            Text(
                text = stringResource(project.title),
                style = Typography().titleLarge,
                color = color_black
            )
            Text(
                text = stringResource(project.description),
                style = Typography().bodyMedium,
                color = color_zinc_500
            )
            Spacer(modifier = Modifier.height(Spacing.spacingSmall))
            Text(
                text = stringResource(project.linkText),
                style = Typography().labelMedium,
                color = color_black
            )
        }
    }
}