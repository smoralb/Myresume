package org.smb.resume.content

import androidx.compose.foundation.layout.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.model.ExperienceUiModel
import org.smb.resume.model.StudiesUiModel
import org.smb.resume.ui.components.GridItemView
import org.smb.resume.ui.components.RowItem
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContentView(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(Res.string.content_title),
            style = Typography().displayMedium
        )

        getExperiences().forEach { experienceItem ->
            RowItem(item = experienceItem)
        }
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth()
                .padding(
                    horizontal = Spacing.spacingLarge,
                    vertical = Spacing.spacingLarge
                )
        )
        Text(
            text = stringResource(Res.string.content_studies_title),
            style = Typography().displayMedium
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingMedium),
            verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium),
            maxItemsInEachRow = 2
        ) {
            getStudies().forEach { studyItem ->
                GridItemView(
                    modifier = Modifier.weight(1f).height(IntrinsicSize.Max),
                    item = studyItem
                )
            }
        }
    }
}

@Composable
private fun getExperiences(): List<ExperienceUiModel> {
    return listOf(
        ExperienceUiModel(
            logoUrl = Res.drawable.ic_idealista,
            companyName = stringResource(Res.string.content_idealista),
            date = stringResource(Res.string.content_idealista_date),
            role = stringResource(Res.string.content_idealista_role),
            jobDescription = stringResource(Res.string.content_idealista_description)
        ),
        ExperienceUiModel(
            logoUrl = Res.drawable.ic_openbank,
            companyName = stringResource(Res.string.content_openbank),
            date = stringResource(Res.string.content_openbank_date),
            role = stringResource(Res.string.content_openbank_role),
            jobDescription = stringResource(Res.string.content_openbank_description)
        ),
        ExperienceUiModel(
            logoUrl = Res.drawable.ic_ipd,
            companyName = stringResource(Res.string.content_ipd),
            date = stringResource(Res.string.content_ipd_date),
            role = stringResource(Res.string.content_ipd_role),
            jobDescription = stringResource(Res.string.content_ipd_description)
        ),
        ExperienceUiModel(
            logoUrl = Res.drawable.ic_accenture,
            companyName = stringResource(Res.string.content_accenture),
            date = stringResource(Res.string.content_accenture_date),
            role = stringResource(Res.string.content_accenture_role),
            jobDescription = stringResource(Res.string.content_accenture_description)
        ),
        ExperienceUiModel(
            logoUrl = Res.drawable.ic_talentomobile,
            companyName = stringResource(Res.string.content_talentomobile),
            date = stringResource(Res.string.content_talentomobile_date),
            role = stringResource(Res.string.content_talentomobile_role),
            jobDescription = stringResource(Res.string.content_talentomobile_description)
        ),
        ExperienceUiModel(
            companyName = stringResource(Res.string.content_babel),
            date = stringResource(Res.string.content_babel_date),
            role = stringResource(Res.string.content_babel_role),
            jobDescription = stringResource(Res.string.content_babel_description)
        )
    )
}

@Composable
fun getStudies(): List<StudiesUiModel> {
    return listOf(
        StudiesUiModel(
            logoUrl = Res.drawable.ic_etsisi,
            name = stringResource(Res.string.content_etsisi_app),
            degree = stringResource(Res.string.content_etsisi_app_degree)
        ),
        StudiesUiModel(
            logoUrl = Res.drawable.ic_coursera,
            name = stringResource(Res.string.content_coursera),
            degree = stringResource(Res.string.content_coursera_degree)
        )
    )
}