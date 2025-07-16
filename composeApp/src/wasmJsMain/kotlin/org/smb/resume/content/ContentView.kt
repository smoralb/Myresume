package org.smb.resume.content

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.model.ExperienceUiModel
import org.smb.resume.model.JobDescription
import org.smb.resume.model.StudiesUiModel
import org.smb.resume.model.TechDescription
import org.smb.resume.ui.components.GridItemView
import org.smb.resume.ui.fonts.spaceMonoFont
import org.smb.resume.ui.theme.*

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(bottom = Spacing.spacingLarge),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingExtraLarge)
    ) {
        ExperienceSection()
        StudiesSection()
    }
}

@Composable
private fun ExperienceSection() {

    val experiences = getExperiences()
    val indexToShow = remember { mutableStateOf(0) }

    HeaderSection(title = Res.string.content_title)


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
fun HeaderSection(title: StringResource) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .padding(vertical = Spacing.spacingMedium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "-", style = Typography().headlineMedium, fontFamily = spaceMonoFont(), color = Color.Green
        )
        Text(
            modifier = Modifier.padding(horizontal = Spacing.spacingMedium),
            text = stringResource(title),
            color = color_inverse,
            style = Typography().headlineLarge,
            textAlign = TextAlign.Center
        )
        Text(
            text = "-", style = Typography().headlineMedium, fontFamily = spaceMonoFont(), color = Color.Green
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun getExperiences(): List<ExperienceUiModel> {
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


@Composable
private fun StudiesSection() {
    HeaderSection(title = Res.string.content_studies_title)

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

@Composable
fun TimeLineHeader(indexSelected: Float) {

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