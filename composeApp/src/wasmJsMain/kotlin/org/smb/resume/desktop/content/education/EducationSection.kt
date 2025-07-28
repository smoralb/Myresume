package org.smb.resume.desktop.content.education

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.desktop.content.header.HeaderSectionView
import org.smb.resume.desktop.content.model.StudiesUiModel
import org.smb.resume.ui.components.GridItemView
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
            GridItemView(
                modifier = Modifier.weight(1f).fillMaxHeight(), item = studyItem
            )
        }
    }
}

@Composable
fun getStudies(): List<StudiesUiModel> {
    return listOf(
        StudiesUiModel(
            logoUrl = Res.drawable.ic_etsisi,
            name = stringResource(Res.string.content_etsisi_app),
            degree = stringResource(Res.string.content_etsisi_app_degree)
        ), StudiesUiModel(
            logoUrl = Res.drawable.ic_coursera,
            name = stringResource(Res.string.content_coursera),
            degree = stringResource(Res.string.content_coursera_degree)
        )
    )
}