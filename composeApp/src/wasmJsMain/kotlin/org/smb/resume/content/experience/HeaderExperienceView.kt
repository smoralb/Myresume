package org.smb.resume.content.experience

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.smb.resume.content.model.ExperienceUiModel
import org.smb.resume.ui.theme.Spacing

@Composable
fun HeaderExperienceView(itemExperience: ExperienceUiModel) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge)
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(itemExperience.logoUrl),
            alignment = Alignment.Center,
            contentDescription = null,
            contentScale = ContentScale.Inside
        )
        Text(text = "Android developer")

    }
}