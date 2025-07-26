package org.smb.resume.content.experience

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.content.header.HeaderSectionView
import org.smb.resume.content.model.ExperienceUiModel
import org.smb.resume.content.model.JobDescription
import org.smb.resume.content.model.TechDescription
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_inverse

@Composable
fun ExperienceSection() {

    val experiences = getExperiences()
    val indexToShow = remember { mutableStateOf(0) }

    HeaderSectionView(title = Res.string.content_title)

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { experiences.size })

    Row(
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(50.dp).weight(1f),
            painter = painterResource(Res.drawable.ic_arrow_backward),
            contentDescription = null,
            tint = Color.Black
        )
        HorizontalPager(
            modifier = Modifier.weight(4f),
            state = pagerState,
            pageSpacing = Spacing.spacingLarge
        ) { pageIndex ->

            val itemExperience = remember { experiences[pageIndex] }

            OutlinedCard(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = color_inverse)
            ) {
                Column(modifier = Modifier.padding(all = Spacing.spacingLarge)) {
                    HeaderExperienceView(itemExperience)
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
                                    SuggestionChips(it)
                                }

                                else -> {
                                    Text(
                                        text = it.description,
                                        style = Typography().bodyLarge
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        Icon(
            modifier = Modifier.size(50.dp).weight(1f),
            painter = painterResource(Res.drawable.ic_arrow_forward),
            contentDescription = null,
            tint = Color.Black
        )
    }
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

