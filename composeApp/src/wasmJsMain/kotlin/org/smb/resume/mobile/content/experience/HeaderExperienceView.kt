package org.smb.resume.mobile.content.experience

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.smb.resume.common.experience.ExperienceUiModel
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography

@Composable
fun HeaderExperienceView(itemExperience: ExperienceUiModel) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            modifier = Modifier.size(150.dp),
            painter = painterResource(itemExperience.logoUrl),
            alignment = Alignment.Center,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Text(text = itemExperience.role, style = Typography().titleLarge)
        Text(text = itemExperience.date, style = Typography().titleMedium)

    }
}