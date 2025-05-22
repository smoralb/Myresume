package org.smb.resume

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.content.RowItem
import org.smb.resume.footer.FooterView
import org.smb.resume.header.HeaderView
import org.smb.resume.model.ExperienceUiModel
import org.smb.resume.ui.theme.MyResumeTheme
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography


@Composable
fun App() {
    MyResumeTheme {
        Scaffold {
            Box {
                Column(
                    modifier = Modifier
                        .verticalScroll(state = rememberScrollState()),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
                ) {
                    HeaderView(
                        modifier = Modifier.padding(all = Spacing.spacingExtraLarge)
                    )
                    Text(
                        text = stringResource(Res.string.content_title),
                        style = Typography().displayMedium
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
                    ) {
                        getExperiences().forEach { item ->
                            RowItem(item = item)
                        }
                    }
                    FooterView()
                }
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