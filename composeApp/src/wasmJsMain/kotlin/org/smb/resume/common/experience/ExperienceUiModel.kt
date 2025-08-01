package org.smb.resume.common.experience

import androidx.compose.runtime.Composable
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.stringResource

data class ExperienceUiModel(
    val logoUrl: DrawableResource,
    val companyName: String,
    val date: String,
    val role: String,
    val jobDescription: List<BaseJobDescription>
)

open class BaseJobDescription(
    open val title: String,
    open val description: String
)

data class JobDescription(
    override val title: String,
    override val description: String
) : BaseJobDescription(title, description)

data class TechDescription(
    override val title: String,
    override val description: String
) : BaseJobDescription(title, description)

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


