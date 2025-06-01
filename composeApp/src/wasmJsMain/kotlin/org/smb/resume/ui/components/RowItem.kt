package org.smb.resume.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.smb.resume.model.ExperienceUiModel
import org.smb.resume.ui.theme.*

@Composable
fun RowItem(modifier: Modifier = Modifier, item: ExperienceUiModel) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth().padding(all = Spacing.spacingLarge),
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.elevationLarge
        ),
        content = {
            Row {
                item.logoUrl?.let {
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .padding(all = Spacing.spacingLarge)
                            .clip(Shapes.small)
                            .background(color = color_inverse),
                        painter = painterResource(it),
                        alignment = Alignment.Center,
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                } ?: run {
                    Image(
                        modifier = Modifier
                            .size(200.dp)
                            .padding(all = Spacing.spacingLarge)
                            .clip(Shapes.small)
                            .background(color = color_inverse),
                        imageVector = Icons.Default.Warning,
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
                        text = item.companyName,
                        style = Typography().titleLarge
                    )
                    Text(
                        text = item.role,
                        style = Typography().titleMedium
                    )
                    Text(
                        text = item.date,
                        style = Typography().titleSmall
                    )
                    Text(
                        text = item.jobDescription,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    )
}