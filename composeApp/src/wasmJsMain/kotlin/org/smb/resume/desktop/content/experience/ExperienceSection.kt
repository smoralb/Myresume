package org.smb.resume.desktop.content.experience

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.content_title
import org.jetbrains.compose.resources.painterResource
import org.smb.resume.common.experience.TechDescription
import org.smb.resume.common.experience.getExperiences
import org.smb.resume.desktop.content.header.HeaderSectionView
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_inverse
import org.smb.resume.ui.theme.color_tomato

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExperienceSection() {

    val coroutineScope = rememberCoroutineScope()
    val experiences = getExperiences()
    val indexToShow = remember { mutableStateOf(0) }

    HeaderSectionView(title = Res.string.content_title)

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { experiences.size })

    LaunchedEffect(pagerState.currentPage) {
        indexToShow.value = pagerState.currentPage
    }

    Column(
        modifier = Modifier.padding(horizontal = Spacing.spacingMedium),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
    ) {
        PrimaryTabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = indexToShow.value,
            containerColor = color_inverse,
            indicator = {
                TabRowDefaults.PrimaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(indexToShow.value, matchContentSize = true),
                    width = Dp.Unspecified,
                    color = color_tomato
                )
            },
            divider = {

            },
            tabs = {
                experiences.forEachIndexed { index, model ->
                    Image(
                        modifier = Modifier.height(80.dp)
                            .clickable {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            },
                        painter = painterResource(model.logoUrl),
                        alignment = Alignment.Center,
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
            }
        )
        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            pageSpacing = Spacing.spacingLarge
        ) { pageIndex ->
            val itemExperience = remember { experiences[pageIndex] }

            OutlinedCard(
                modifier = Modifier.fillMaxWidth().padding(horizontal = Spacing.spacingMedium),
                colors = CardDefaults.cardColors(containerColor = color_inverse)
            ) {
                Column(modifier = Modifier.padding(all = Spacing.spacingLarge)) {
                    Text(text = itemExperience.role, style = Typography().titleLarge, color = Color.Black)
                    Text(text = itemExperience.date, style = Typography().titleMedium, color = Color.Black)
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
}