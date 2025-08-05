package org.smb.resume.mobile.content.experience

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.content_title
import org.smb.resume.common.experience.TechDescription
import org.smb.resume.common.experience.getExperiences
import org.smb.resume.desktop.content.header.HeaderSectionView
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_inverse

@Composable
fun ExperienceMobileSection() {

    val experiences = getExperiences()
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { experiences.size })

    val indexToShow = remember {
        derivedStateOf {
            pagerState.currentPage
        }
    }

    HeaderSectionView(title = Res.string.content_title)

    HorizontalPager(
        state = pagerState,
        pageSpacing = Spacing.spacingLarge,
        contentPadding = PaddingValues(horizontal = Spacing.spacingMedium)
    ) { pageIndex ->
        val itemExperience = remember { experiences[pageIndex] }

        OutlinedCard(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = color_inverse)
        ) {
            Column(modifier = Modifier.padding(all = Spacing.spacingLarge)) {
                HeaderExperienceView(itemExperience)
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = Spacing.spacingMedium)
                )
                experiences[indexToShow.value].jobDescription.forEach {
                    Column {
                        Text(
                            modifier = Modifier.padding(vertical = Spacing.spacingSmall),
                            text = it.title,
                            style = Typography().titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )
                        when (it) {
                            is TechDescription -> SuggestionChips(it)
                            else -> Text(
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