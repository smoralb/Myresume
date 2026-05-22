package org.smb.resume.desktop.content.projects

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
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

        // Projects Grid - 3 columns
        LazyVerticalGrid(
            columns = androidx.compose.foundation.lazy.grid.GridCells.Fixed(3),
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
            verticalArrangement = Arrangement.spacedBy(Spacing.spacingLarge)
        ) {
            items(getProjects()) { project ->
                ProjectCard(project = project)
            }
        }
    }
}
