package org.smb.resume.desktop.content.education

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.content_studies_title
import org.smb.resume.common.studies.getStudies
import org.smb.resume.desktop.content.header.HeaderSectionView
import org.smb.resume.ui.components.EducationItemCard
import org.smb.resume.ui.theme.Spacing


@Composable
fun EducationSection() {
    HeaderSectionView(title = Res.string.content_studies_title)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = Spacing.spacingLarge,
                horizontal = Spacing.spacingLarge
            )
            .height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
    ) {
        getStudies().forEach { studyItem ->
            EducationItemCard(
                modifier = Modifier.weight(1f).fillMaxHeight(), item = studyItem
            )
        }
    }
}