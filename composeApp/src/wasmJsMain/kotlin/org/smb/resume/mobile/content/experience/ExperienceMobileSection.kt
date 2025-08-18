package org.smb.resume.mobile.content.experience

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.content_title
import org.jetbrains.compose.resources.painterResource
import org.smb.resume.common.experience.ExperienceUiModel
import org.smb.resume.common.experience.getExperiences
import org.smb.resume.desktop.content.header.HeaderSectionView
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_inverse

@Composable
fun ExperienceMobileSection() {

    val experiences = getExperiences()

    HeaderSectionView(title = Res.string.content_title)
    Column {
        experiences.forEach {
            OutlinedCard(
                modifier = Modifier.fillMaxWidth().padding(all = Spacing.spacingLarge),
                colors = CardDefaults.cardColors(
                    containerColor = color_inverse,
                    contentColor = Color.Black
                )
            ) {
                Column(modifier = Modifier.padding(all = Spacing.spacingLarge)) {
                    HeaderMobileExperienceView(it)
                }
            }
        }
    }
}

@Composable
fun HeaderMobileExperienceView(itemExperience: ExperienceUiModel) {
    Column(
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
        horizontalAlignment = Alignment.Start
    ) {
        Image(
            modifier = Modifier.size(80.dp).align(Alignment.CenterHorizontally),
            painter = painterResource(itemExperience.logoUrl),
            alignment = Alignment.Center,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Text(text = itemExperience.role, style = Typography().titleLarge)
        Text(text = itemExperience.date, style = Typography().titleMedium)

    }
}