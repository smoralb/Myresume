package org.smb.resume.desktop.content.projects

import androidx.compose.foundation.layout.*
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
import org.smb.resume.ui.theme.*

@Composable
fun ProjectsSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 100.dp, horizontal = 80.dp),
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
            Text(
                text = stringResource(Res.string.proj_title),
                style = Typography().headlineLarge,
                color = color_black,
                textAlign = TextAlign.End
            )
        }

        // height(IntrinsicSize.Max) makes all cards in the row the same height
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
            verticalAlignment = Alignment.Top
        ) {
            getProjects().forEach { project ->
                ProjectCard(modifier = Modifier.weight(1f).fillMaxHeight(), project = project)
            }
        }
    }
}
