package org.smb.resume.mobile.content.experience

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.content_title
import myresume.composeapp.generated.resources.ic_arrow_backward
import myresume.composeapp.generated.resources.ic_arrow_forward
import org.jetbrains.compose.resources.painterResource
import org.smb.resume.common.experience.TechDescription
import org.smb.resume.common.experience.getExperiences
import org.smb.resume.desktop.content.header.HeaderSectionView
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_inverse

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

    Row(
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacingSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val canGoBack = pagerState.currentPage > 0
        val canGoForward = pagerState.currentPage < experiences.size - 1

        IconButton(
            modifier = Modifier.size(50.dp).weight(1f),
            onClick = {
                if (canGoBack) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }
            },
            enabled = canGoBack
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_arrow_backward),
                contentDescription = "Anterior",
                tint = Color.Black,
                modifier = Modifier.alpha(if (canGoBack) 1f else 0.3f)
            )
        }

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

        IconButton(
            modifier = Modifier.size(50.dp).weight(1f),
            onClick = {
                if (canGoForward) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            },
            enabled = canGoForward
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_arrow_forward),
                contentDescription = "Siguiente",
                tint = Color.Black,
                modifier = Modifier.alpha(if (canGoForward) 1f else 0.3f)
            )
        }
    }
}