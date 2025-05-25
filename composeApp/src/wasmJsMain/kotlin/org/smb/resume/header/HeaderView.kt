package org.smb.resume.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Elevation
import org.smb.resume.ui.theme.Shapes
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography

@Composable
fun HeaderView(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacingExtraLarge),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NameSection(modifier = Modifier.weight(weight = 1f))
        PhotoSection(modifier = Modifier.weight(weight = 1f), skills = getSkills())
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
            style = Typography().displayLarge
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
        ) {
            Image(
                modifier = Modifier.size(40.dp),
                painter = painterResource(Res.drawable.ic_android),
                contentDescription = null
            )
            Text(
                text = stringResource(Res.string.role),
                style = Typography().headlineLarge
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
        ElevatedCard(
            modifier = Modifier.widthIn(max = 800.dp).aspectRatio(ratio = 1f),
            shape = Shapes.large,
            elevation = CardDefaults.cardElevation(defaultElevation = Elevation.elevationLarge),
            content = {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(resource = Res.drawable.resume_image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
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