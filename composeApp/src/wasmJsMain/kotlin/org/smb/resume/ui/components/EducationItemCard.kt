package org.smb.resume.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.common.studies.StudiesUiModel
import org.smb.resume.ui.theme.Elevation
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_inverse

@Composable
fun EducationItemCard(modifier: Modifier = Modifier, item: StudiesUiModel) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.elevationLarge
        ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = color_inverse
        ),
        content = {
            Column(
                modifier = Modifier.fillMaxWidth().padding(all = Spacing.spacingLarge),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(Spacing.spacingSmall)
            ) {
                item.logoUrl?.let {
                    Image(
                        modifier = Modifier
                            .size(100.dp)
                            .padding(vertical = Spacing.spacingLarge),
                        painter = painterResource(it),
                        alignment = Alignment.Center,
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
                Text(
                    text = stringResource(item.name),
                    style = Typography().titleLarge
                )
                Text(
                    text = stringResource(item.degree),
                    style = Typography().titleMedium
                )
            }
        }
    )
}