package org.smb.resume.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.components.IconsCarousel
import org.smb.resume.ui.components.IconsCarouselUiModel
import org.smb.resume.ui.fonts.spaceMonoFont
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography

@Composable
fun HeaderView(modifier: Modifier = Modifier) {
    Box {

        Row(
            modifier = modifier.height(IntrinsicSize.Max).padding(
                vertical = Spacing.spacingMedium,
                horizontal = Spacing.spacingLarge
            ),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingExtraLarge),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NameSection(modifier = Modifier.weight(weight = 1f))
            PhotoSection(modifier = Modifier.weight(weight = 1f), skills = getSkills())
        }
    }
}

@Composable
private fun NameSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
    ) {
        Text(
            text = stringResource(Res.string.name),
            style = Typography().displayLarge,
            fontFamily = spaceMonoFont()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
        ) {
            Text(
                text = "\\",
                style = Typography().headlineLarge,
                fontFamily = spaceMonoFont()
            )
            Text(
                text = stringResource(Res.string.role),
                style = Typography().headlineLarge,
                fontFamily = spaceMonoFont()
            )
        }
    }
}

@Composable
private fun PhotoSection(modifier: Modifier = Modifier, skills: List<IconsCarouselUiModel>) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconsCarousel(
            modifier = Modifier,
            carouselItems = skills
        )
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingSmall)
        ) {
            Image(
                imageVector = Icons.Outlined.LocationOn,
                contentDescription = null
            )
            Text(
                text = stringResource(Res.string.location),
                style = Typography().bodyMedium
            )
        }
    }
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