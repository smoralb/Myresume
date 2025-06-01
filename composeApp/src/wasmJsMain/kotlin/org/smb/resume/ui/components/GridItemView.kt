package org.smb.resume.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.smb.resume.model.StudiesUiModel
import org.smb.resume.ui.theme.Elevation
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography

@Composable
fun GridItemView(modifier: Modifier = Modifier, item: StudiesUiModel) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.elevationLarge
        ),
        content = {
            Row {
                item.logoUrl?.let {
                    Image(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(all = Spacing.spacingLarge),
                        painter = painterResource(it),
                        alignment = Alignment.Center,
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
                Column(
                    modifier = Modifier.padding(all = Spacing.spacingMedium),
                    verticalArrangement = Arrangement.spacedBy(Spacing.spacingSmall)
                ) {
                    Text(
                        text = item.name,
                        style = Typography().titleLarge
                    )
                    Text(
                        text = item.degree,
                        style = Typography().titleMedium
                    )
                }
            }
        }
    )
}