package org.smb.resume.content.experience

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.content_accenture
import myresume.composeapp.generated.resources.content_accenture_contrib
import myresume.composeapp.generated.resources.content_accenture_date
import myresume.composeapp.generated.resources.content_accenture_role
import myresume.composeapp.generated.resources.content_accenture_scope
import myresume.composeapp.generated.resources.content_accenture_tech
import myresume.composeapp.generated.resources.content_babel
import myresume.composeapp.generated.resources.content_babel_contrib
import myresume.composeapp.generated.resources.content_babel_date
import myresume.composeapp.generated.resources.content_babel_role
import myresume.composeapp.generated.resources.content_babel_scope
import myresume.composeapp.generated.resources.content_babel_tech
import myresume.composeapp.generated.resources.content_contributions
import myresume.composeapp.generated.resources.content_idealista
import myresume.composeapp.generated.resources.content_idealista_contrib
import myresume.composeapp.generated.resources.content_idealista_date
import myresume.composeapp.generated.resources.content_idealista_role
import myresume.composeapp.generated.resources.content_idealista_scope
import myresume.composeapp.generated.resources.content_idealista_tech
import myresume.composeapp.generated.resources.content_ipd
import myresume.composeapp.generated.resources.content_ipd_contrib
import myresume.composeapp.generated.resources.content_ipd_date
import myresume.composeapp.generated.resources.content_ipd_role
import myresume.composeapp.generated.resources.content_ipd_scope
import myresume.composeapp.generated.resources.content_ipd_tech
import myresume.composeapp.generated.resources.content_openbank
import myresume.composeapp.generated.resources.content_openbank_contrib
import myresume.composeapp.generated.resources.content_openbank_date
import myresume.composeapp.generated.resources.content_openbank_role
import myresume.composeapp.generated.resources.content_openbank_scope
import myresume.composeapp.generated.resources.content_openbank_tech
import myresume.composeapp.generated.resources.content_scope
import myresume.composeapp.generated.resources.content_talentomobile
import myresume.composeapp.generated.resources.content_talentomobile_contrib
import myresume.composeapp.generated.resources.content_talentomobile_date
import myresume.composeapp.generated.resources.content_talentomobile_role
import myresume.composeapp.generated.resources.content_talentomobile_scope
import myresume.composeapp.generated.resources.content_talentomobile_tech
import myresume.composeapp.generated.resources.content_tech_stack
import myresume.composeapp.generated.resources.content_timeline_present
import myresume.composeapp.generated.resources.content_timeline_start
import myresume.composeapp.generated.resources.content_title
import myresume.composeapp.generated.resources.ic_accenture
import myresume.composeapp.generated.resources.ic_babel
import myresume.composeapp.generated.resources.ic_idealista
import myresume.composeapp.generated.resources.ic_ipd
import myresume.composeapp.generated.resources.ic_openbank
import myresume.composeapp.generated.resources.ic_talentomobile
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.content.header.HeaderSectionView
import org.smb.resume.content.model.ExperienceUiModel
import org.smb.resume.content.model.JobDescription
import org.smb.resume.content.model.TechDescription
import org.smb.resume.ui.theme.Elevation
import org.smb.resume.ui.theme.Shapes
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_dark_blue
import org.smb.resume.ui.theme.color_grey
import org.smb.resume.ui.theme.color_inverse
import org.smb.resume.ui.theme.color_light_blue

@Composable
fun ExperienceSection() {

    val experiences = getExperiences()
    val indexToShow = remember { mutableStateOf(0) }

    HeaderSectionView(title = Res.string.content_title)

    Column(modifier = Modifier.padding(horizontal = Spacing.spacingLarge)) {
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
                        defaultElevation = if (indexToShow.value == index) Elevation.elevationSmall else Elevation.elevationMedium,
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
                        contentScale = ContentScale.Inside
                    )
                }
            }
        }
        TimeLineHeader(indexSelected = (indexToShow.value.toFloat()) / experiences.size)

        experiences[indexToShow.value].jobDescription.forEach {
            Column {
                Text(
                    modifier = Modifier.padding(vertical = Spacing.spacingSmall),
                    text = it.title,
                    style = Typography().titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
                when (it) {
                    is TechDescription -> {
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingSmall),
                            verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
                        ) {
                            it.description.split(",").forEach { technology ->
                                SuggestionChip(
                                    onClick = {},
                                    label = {
                                        Text(
                                            text = technology,
                                            style = Typography().labelSmall
                                        )
                                    },
                                    border = null,
                                    colors = AssistChipDefaults.assistChipColors(
                                        containerColor = color_light_blue,
                                        labelColor = color_dark_blue
                                    )
                                )
                            }
                        }
                    }

                    else -> {
                        Text(
                            text = it.description,
                            style = Typography().bodyMedium
                        )
                    }
                }
            }
        }
    }
}


@Composable
private fun TimeLineHeader(indexSelected: Float) {

    val animatedProgress by animateFloatAsState(
        targetValue = indexSelected + 0.05f,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    Row {
        Text(
            text = stringResource(Res.string.content_timeline_start),
            style = Typography().labelLarge
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = stringResource(Res.string.content_timeline_present),
            style = Typography().bodySmall
        )

    }

    LinearProgressIndicator(
        progress = { animatedProgress },
        modifier = Modifier.fillMaxWidth(),
        color = color_grey,
        trackColor = color_light_blue,
        strokeCap = ProgressIndicatorDefaults.LinearStrokeCap
    )
}

@Composable
private fun getExperiences(): List<ExperienceUiModel> {
    return listOf(
        ExperienceUiModel(
            logoUrl = Res.drawable.ic_babel,
            companyName = stringResource(Res.string.content_babel),
            date = stringResource(Res.string.content_babel_date),
            role = stringResource(Res.string.content_babel_role),
            jobDescription = listOf(
                JobDescription(
                    title = stringResource(Res.string.content_scope),
                    description = stringResource(Res.string.content_babel_scope)
                ),
                TechDescription(
                    title = stringResource(Res.string.content_tech_stack),
                    description = stringResource(Res.string.content_babel_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_babel_contrib)
                )
            )
        ),
        ExperienceUiModel(
            logoUrl = Res.drawable.ic_talentomobile,
            companyName = stringResource(Res.string.content_talentomobile),
            date = stringResource(Res.string.content_talentomobile_date),
            role = stringResource(Res.string.content_talentomobile_role),
            jobDescription = listOf(
                JobDescription(
                    title = stringResource(Res.string.content_scope),
                    description = stringResource(Res.string.content_talentomobile_scope)
                ),
                TechDescription(
                    title = stringResource(Res.string.content_tech_stack),
                    description = stringResource(Res.string.content_talentomobile_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_talentomobile_contrib)
                )
            )
        ),
        ExperienceUiModel(
            logoUrl = Res.drawable.ic_accenture,
            companyName = stringResource(Res.string.content_accenture),
            date = stringResource(Res.string.content_accenture_date),
            role = stringResource(Res.string.content_accenture_role),
            jobDescription = listOf(
                JobDescription(
                    title = stringResource(Res.string.content_scope),
                    description = stringResource(Res.string.content_accenture_scope)
                ),
                TechDescription(
                    title = stringResource(Res.string.content_tech_stack),
                    description = stringResource(Res.string.content_accenture_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_accenture_contrib)
                )
            )
        ),
        ExperienceUiModel(
            logoUrl = Res.drawable.ic_ipd,
            companyName = stringResource(Res.string.content_ipd),
            date = stringResource(Res.string.content_ipd_date),
            role = stringResource(Res.string.content_ipd_role),
            jobDescription = listOf(
                JobDescription(
                    title = stringResource(Res.string.content_scope),
                    description = stringResource(Res.string.content_ipd_scope)
                ),
                TechDescription(
                    title = stringResource(Res.string.content_tech_stack),
                    description = stringResource(Res.string.content_ipd_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_ipd_contrib)
                )
            )
        ),
        ExperienceUiModel(
            logoUrl = Res.drawable.ic_openbank,
            companyName = stringResource(Res.string.content_openbank),
            date = stringResource(Res.string.content_openbank_date),
            role = stringResource(Res.string.content_openbank_role),
            jobDescription = listOf(
                JobDescription(
                    title = stringResource(Res.string.content_scope),
                    description = stringResource(Res.string.content_openbank_scope)
                ),
                TechDescription(
                    title = stringResource(Res.string.content_tech_stack),
                    description = stringResource(Res.string.content_openbank_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_openbank_contrib)
                )
            )
        ),
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
                TechDescription(
                    title = stringResource(Res.string.content_tech_stack),
                    description = stringResource(Res.string.content_idealista_tech)
                ),
                JobDescription(
                    title = stringResource(Res.string.content_contributions),
                    description = stringResource(Res.string.content_idealista_contrib)
                )
            )
        )
    )
}

