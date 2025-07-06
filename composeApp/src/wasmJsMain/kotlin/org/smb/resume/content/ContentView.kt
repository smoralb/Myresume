package org.smb.resume.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.model.ExperienceUiModel
import org.smb.resume.model.JobDescription
import org.smb.resume.model.StudiesUiModel
import org.smb.resume.ui.components.GridItemView
import org.smb.resume.ui.theme.*

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(vertical = Spacing.spacingLarge),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingExtraLarge)
    ) {
        ExperienceSection()
        StudiesSection()
    }
}

@Composable
private fun StudiesSection() {
    Text(
        modifier = Modifier.background(color = color_mindaro).padding(vertical = Spacing.spacingLarge),
        text = stringResource(Res.string.content_studies_title),
        style = Typography().displayMedium
    )
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = Spacing.spacingLarge).height(IntrinsicSize.Max),
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
private fun ExperienceSection() {

    val experiences = getExperiences()
    val indexToShow = remember { mutableStateOf(0) }

    Text(
        modifier = Modifier.background(color = color_mindaro).padding(vertical = Spacing.spacingLarge),
        text = stringResource(Res.string.content_title),
        style = Typography().displayMedium
    )
    Column {
        Row {
            Text(
                text = "Present",
                style = Typography().labelLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Start",
                style = Typography().labelLarge
            )
        }
        HorizontalDivider(modifier = Modifier.fillMaxWidth().padding(vertical = Spacing.spacingLarge))
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = Spacing.spacingLarge),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
        ) {
            experiences.forEachIndexed { index, experienceUiModel ->
                ElevatedCard(
                    modifier = Modifier.aspectRatio(ratio = 16 / 9f).weight(1f),
                    shape = Shapes.small,
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = color_inverse
                    ),
                    elevation = CardDefaults.elevatedCardElevation(
                        defaultElevation = Elevation.elevationMedium,
                        pressedElevation = Elevation.elevationSmall,
                        hoveredElevation = Elevation.elevationExtraLarge

                    ),
                    onClick = {
                        indexToShow.value = index
                    }
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(experienceUiModel.logoUrl),
                        alignment = Alignment.Center,
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }

        experiences[indexToShow.value].jobDescription.forEach {
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
}

@Composable
fun getExperiences(): List<ExperienceUiModel> {
    return listOf(
        ExperienceUiModel(
            logoUrl = Res.drawable.ic_idealista,
            companyName = stringResource(Res.string.content_idealista),
            date = stringResource(Res.string.content_idealista_date),
            role = stringResource(Res.string.content_idealista_role),
            jobDescription = listOf(
                JobDescription(
                    title = stringResource(Res.string.content_scope),
                    description = stringResource(Res.string.content_idealista_scope)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_tech),
                    description = stringResource(Res.string.content_idealista_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_idealista_contrib)
                )
            )
        ), ExperienceUiModel(
            logoUrl = Res.drawable.ic_openbank,
            companyName = stringResource(Res.string.content_openbank),
            date = stringResource(Res.string.content_openbank_date),
            role = stringResource(Res.string.content_openbank_role),
            jobDescription = listOf(
                JobDescription(
                    title = stringResource(Res.string.content_scope),
                    description = stringResource(Res.string.content_openbank_scope)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_tech),
                    description = stringResource(Res.string.content_openbank_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_openbank_contrib)
                )
            )
        ), ExperienceUiModel(
            logoUrl = Res.drawable.ic_ipd,
            companyName = stringResource(Res.string.content_ipd),
            date = stringResource(Res.string.content_ipd_date),
            role = stringResource(Res.string.content_ipd_role),
            jobDescription = listOf(
                JobDescription(
                    title = stringResource(Res.string.content_scope),
                    description = stringResource(Res.string.content_ipd_scope)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_tech),
                    description = stringResource(Res.string.content_ipd_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_ipd_contrib)
                )
            )
        ), ExperienceUiModel(
            logoUrl = Res.drawable.ic_accenture,
            companyName = stringResource(Res.string.content_accenture),
            date = stringResource(Res.string.content_accenture_date),
            role = stringResource(Res.string.content_accenture_role),
            jobDescription = listOf(
                JobDescription(
                    title = stringResource(Res.string.content_scope),
                    description = stringResource(Res.string.content_accenture_scope)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_tech),
                    description = stringResource(Res.string.content_accenture_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_accenture_contrib)
                )
            )
        ), ExperienceUiModel(
            logoUrl = Res.drawable.ic_talentomobile,
            companyName = stringResource(Res.string.content_talentomobile),
            date = stringResource(Res.string.content_talentomobile_date),
            role = stringResource(Res.string.content_talentomobile_role),
            jobDescription = listOf(
                JobDescription(
                    title = stringResource(Res.string.content_scope),
                    description = stringResource(Res.string.content_talentomobile_scope)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_tech),
                    description = stringResource(Res.string.content_talentomobile_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_talentomobile_contrib)
                )
            )
        ), ExperienceUiModel(
            logoUrl = Res.drawable.ic_babel,
            companyName = stringResource(Res.string.content_babel),
            date = stringResource(Res.string.content_babel_date),
            role = stringResource(Res.string.content_babel_role),
            jobDescription = listOf(
                JobDescription(
                    title = stringResource(Res.string.content_scope),
                    description = stringResource(Res.string.content_babel_scope)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_tech),
                    description = stringResource(Res.string.content_babel_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_babel_contrib)
                )
            )
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
        ), StudiesUiModel(
            logoUrl = Res.drawable.ic_coursera,
            name = stringResource(Res.string.content_coursera),
            degree = stringResource(Res.string.content_coursera_degree)
        )
    )
}