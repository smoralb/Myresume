package org.smb.resume.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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

    var expanded by remember { mutableStateOf(false) }

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = Spacing.spacingLarge)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                expanded = !expanded
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.elevationMedium
        ),
        shape = Shapes.small,
        content = {
            Column(
                modifier = Modifier
                    .animateContentSize(tween(200))
                    .padding(all = Spacing.spacingLarge)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge)
                ) {
                    item.logoUrl?.let {
                        Image(
                            modifier = Modifier
                                .size(200.dp)
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
                                .clip(Shapes.small)
                                .background(color = color_inverse),
                            imageVector = Icons.Default.Warning,
                            alignment = Alignment.Center,
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.spacedBy(Spacing.spacingSmall)
                    ) {
                        Text(
                            text = item.companyName,
                            style = Typography().displaySmall
                        )
                        Text(
                            text = item.role,
                            style = Typography().titleMedium
                        )
                        Text(
                            text = item.date,
                            style = Typography().titleSmall
                        )
                    }
                }
                if (expanded) {
                    Text(
                        modifier = Modifier.padding(vertical = Spacing.spacingMedium),
                        text = item.jobDescription,
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    )
}