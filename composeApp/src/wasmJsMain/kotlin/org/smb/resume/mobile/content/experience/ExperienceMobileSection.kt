package org.smb.resume.mobile.content.experience

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.components.AnimatedSectionTitle
import org.smb.resume.ui.extensions.rememberIsVisibleEnough
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_green_accent
import org.smb.resume.ui.theme.color_white
import org.smb.resume.ui.theme.color_zinc_400
import org.smb.resume.ui.theme.color_zinc_500
import org.smb.resume.ui.theme.color_zinc_800

@Composable
fun ExperienceMobileSection(modifier: Modifier = Modifier) {
    val (isVisible, visibilityModifier) = rememberIsVisibleEnough()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color_black)
            .padding(vertical = Spacing.spacingExtraLarge, horizontal = Spacing.spacingLarge)
            .then(visibilityModifier),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingLarge)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
        ) {
            Text(
                text = stringResource(Res.string.exp_label),
                style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold),
                color = color_white
            )
            AnimatedSectionTitle(
                text = stringResource(Res.string.exp_title),
                textStyle = Typography().headlineLarge.copy(fontSize = 36.sp, lineHeight = 36.sp, letterSpacing = (-0.5).sp),
                baseColor = color_white,
                hoverColor = color_green_accent,
                isHovered = isVisible,
                textAlign = TextAlign.End,
                transformOrigin = TransformOrigin(1f, 0.5f)
            )
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            MobileDivider()
            MobileJobEntry(
                year = stringResource(Res.string.exp_job1_year),
                title = stringResource(Res.string.exp_job1_title),
                company = stringResource(Res.string.exp_job1_company),
                description = stringResource(Res.string.exp_job1_desc)
            )
            MobileDivider()
            MobileJobEntry(
                year = stringResource(Res.string.exp_job2_year),
                title = stringResource(Res.string.exp_job2_title),
                company = stringResource(Res.string.exp_job2_company),
                description = stringResource(Res.string.exp_job2_desc)
            )
            MobileDivider()
            MobileJobEntry(
                year = stringResource(Res.string.exp_job3_year),
                title = stringResource(Res.string.exp_job3_title),
                company = stringResource(Res.string.exp_job3_company),
                description = stringResource(Res.string.exp_job3_desc)
            )
            MobileDivider()
            MobileJobEntry(
                year = stringResource(Res.string.exp_job4_year),
                title = stringResource(Res.string.exp_job4_title),
                company = stringResource(Res.string.exp_job4_company),
                description = stringResource(Res.string.exp_job4_desc)
            )
            MobileDivider()
            MobileJobEntry(
                year = stringResource(Res.string.exp_job5_year),
                title = stringResource(Res.string.exp_job5_title),
                company = stringResource(Res.string.exp_job5_company),
                description = stringResource(Res.string.exp_job5_desc)
            )
            MobileDivider()
            MobileJobEntry(
                year = stringResource(Res.string.exp_job6_year),
                title = stringResource(Res.string.exp_job6_title),
                company = stringResource(Res.string.exp_job6_company),
                description = stringResource(Res.string.exp_job6_desc)
            )
            MobileDivider()
        }
    }
}

@Composable
private fun MobileJobEntry(
    year: String,
    title: String,
    company: String,
    description: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.spacingLarge),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingSmall)
    ) {
        Text(
            text = year,
            style = Typography().labelSmall,
            color = color_zinc_500
        )
        Text(
            text = title,
            style = Typography().titleLarge,
            color = color_white
        )
        Text(
            text = company,
            style = Typography().bodyMedium,
            color = color_zinc_500
        )
        Text(
            text = description,
            style = Typography().bodySmall,
            color = color_zinc_400
        )
    }
}

@Composable
private fun MobileDivider() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color_zinc_800)
    ) {}
}