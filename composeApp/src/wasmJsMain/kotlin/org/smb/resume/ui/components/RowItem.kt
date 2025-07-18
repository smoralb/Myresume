package org.smb.resume.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.elevatedCardColors
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.ic_not_found
import org.jetbrains.compose.resources.painterResource
import org.smb.resume.content.model.ExperienceUiModel
import org.smb.resume.ui.theme.*

@Composable
fun RowItem(modifier: Modifier = Modifier, item: ExperienceUiModel) {

    var expanded by remember { mutableStateOf(false) }

    ElevatedCard(
        modifier = modifier
            .padding(all = Spacing.spacingExtraSmall)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                expanded = !expanded
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = Elevation.elevationMedium
        ),
        colors = elevatedCardColors(
            containerColor = color_inverse,
        ),
        shape = Shapes.small,
        content = {
            Column(
                modifier = Modifier
                    .animateContentSize(tween(200))
                    .padding(all = Spacing.spacingLarge),
                verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
            ) {
                CardHeader(item)
                if (expanded) {
                    CardContent(item)
                }
            }
        }
    )
}

@Composable
fun CardContent(item: ExperienceUiModel) {
    item.jobDescription.forEach {
        Column(
            verticalArrangement = Arrangement.spacedBy(Spacing.spacingSmall)
        ) {
            Text(
                text = it.title,
                style = Typography().titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = it.description,
                style = Typography().labelLarge
            )
        }
    }
}

@Composable
fun CardHeader(item: ExperienceUiModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge)
    ) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .clip(Shapes.small)
                .background(color = color_inverse),
            painter = painterResource(item.logoUrl ?: Res.drawable.ic_not_found),
            alignment = Alignment.Center,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )

        Column(modifier = Modifier.height(100.dp).align(Alignment.CenterVertically)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.companyName,
                    style = Typography().displaySmall
                )
                Text(
                    text = " - ",
                    style = Typography().headlineLarge
                )
                Text(
                    text = item.role,
                    style = Typography().headlineSmall,
                    color = color_grey
                )
            }
            Text(
                text = item.date,
                style = Typography().titleSmall
            )
        }
    }
}