package org.smb.resume.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography

@Composable
fun IconsCarousel(
    modifier: Modifier = Modifier,
    carouselItems: List<IconsCarouselUiModel>
) {
    Row(
        modifier = modifier.width(300.dp)
            .basicMarquee(
                iterations = Int.MAX_VALUE,
                spacing = MarqueeSpacing(spacing = Spacing.spacingSmall),
                initialDelayMillis = 0,
                repeatDelayMillis = 0
            ),
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacingSmall)
    ) {
        carouselItems.forEach { item ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(resource = item.iconReference),
                    contentDescription = null
                )
                Text(
                    text = stringResource(item.label),
                    style = Typography().labelLarge
                )
            }
        }
    }
}

data class IconsCarouselUiModel(
    val iconReference: DrawableResource,
    val label: StringResource
)