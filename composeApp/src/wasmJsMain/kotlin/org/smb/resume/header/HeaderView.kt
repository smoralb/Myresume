package org.smb.resume.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.browser.window
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.components.IconsCarouselUiModel
import org.smb.resume.ui.fonts.spaceMonoFont
import org.smb.resume.ui.theme.*

@Composable
fun HeaderView(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(horizontal = Spacing.spacingLarge),
        verticalAlignment = Alignment.Top
    ) {
        NameSection(
            modifier = Modifier
                .weight(weight = 1f)
        )
        Box(
            modifier = Modifier
                .weight(weight = 2f)
                .fillMaxHeight()
        ) {
            Image(
                modifier = Modifier.align(Alignment.BottomStart),
                painter = painterResource(Res.drawable.ic_programming),
                contentDescription = null
            )
            ContactSection(modifier = Modifier.align(Alignment.TopEnd).padding(end = Spacing.spacingLarge))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun NameSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
    ) {
        BasicText(
            text = stringResource(Res.string.name),
            autoSize = TextAutoSize.StepBased(
                minFontSize = Typography().labelLarge.fontSize,
                maxFontSize = Typography().displayLarge.fontSize,
                stepSize = 10.sp
            )
        )
        Row(
            modifier = Modifier
                .drawBehind { drawRect(color = Color.Black) }
                .padding(vertical = Spacing.spacingSmall, horizontal = Spacing.spacingMedium),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingExtraSmall)
        ) {
            Text(
                text = "\\",
                style = Typography().headlineLarge,
                fontFamily = spaceMonoFont(),
                color = Color.Green
            )
            Text(
                text = stringResource(Res.string.role),
                style = Typography().headlineLarge,
                fontFamily = spaceMonoFont(),
                color = color_inverse
            )
        }
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingMedium),
            verticalArrangement = Arrangement.spacedBy(Spacing.spacingSmall)
        ) {
            getSkills().forEach {
                SuggestionChip(
                    onClick = {},
                    label = {
                        Text(
                            text = stringResource(it.label)
                        )
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.size(12.dp),
                            painter = painterResource(resource = it.iconReference),
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.align(Alignment.TopEnd)
                .background(
                    color = color_tomato,
                    shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                )
                .padding(horizontal = Spacing.spacingExtraLarge)
                .padding(bottom = Spacing.spacingExtraLarge)
        ) {
            Row(
                modifier = Modifier.padding(vertical = Spacing.spacingMedium),
                horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(Res.string.contact_socials),
                    style = Typography().headlineMedium,
                    color = color_inverse
                )
                Image(
                    modifier = Modifier.size(80.dp),
                    painter = painterResource(Res.drawable.ic_old_pc),
                    contentDescription = null
                )
            }
            ContactText(
                text = stringResource(Res.string.contact_socials_linkedin),
                url = "https://www.linkedin.com/in/sergiomoralbermudez/"
            )
            ContactText(
                text = stringResource(Res.string.contact_socials_github),
                url = "https://github.com/smoralb"
            )
            ContactText(
                text = stringResource(Res.string.contact_socials_medium),
                url = "https://medium.com/@smoralber"
            )
        }
    }
}

@Composable
fun ContactText(modifier: Modifier = Modifier, text: String, url: String) {
    Text(
        modifier = modifier.clickable {
            window.open(url = url)
        }.padding(start = Spacing.spacingSmall),
        text = text,
        style = Typography().headlineSmall,
        textDecoration = TextDecoration.Underline,
        color = color_inverse
    )
}

@Composable
fun getSkills(): List<IconsCarouselUiModel> {
    return listOf(
        IconsCarouselUiModel(
            iconReference = Res.drawable.ic_android,
            label = Res.string.android
        ),
        IconsCarouselUiModel(
            iconReference = Res.drawable.ic_apple,
            label = Res.string.ios
        ),
        IconsCarouselUiModel(
            iconReference = Res.drawable.ic_compose_multiplatform,
            label = Res.string.multiPlatform
        ),
        IconsCarouselUiModel(
            iconReference = Res.drawable.ic_kotlin,
            label = Res.string.kotlin
        ),
        IconsCarouselUiModel(
            iconReference = Res.drawable.ic_java,
            label = Res.string.java
        ),
        IconsCarouselUiModel(
            iconReference = Res.drawable.ic_swift,
            label = Res.string.swift
        ),
    )
}