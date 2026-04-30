package org.smb.resume.mobile.content.education

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_zinc_500
import org.smb.resume.ui.theme.color_zinc_800

@Composable
fun EducationMobileSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.spacingExtraLarge, horizontal = Spacing.spacingLarge),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingLarge)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
        ) {
            Text(
                text = stringResource(Res.string.edu_label),
                style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold),
                color = color_black
            )
            Text(
                text = stringResource(Res.string.edu_title),
                style = Typography().headlineLarge,
                color = color_black,
                textAlign = TextAlign.End
            )
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            MobileDivider()
            MobileEducationEntry(
                institution = stringResource(Res.string.edu_1_name),
                degree = stringResource(Res.string.edu_1_degree)
            )
            MobileDivider()
            MobileEducationEntry(
                institution = stringResource(Res.string.edu_2_name),
                degree = stringResource(Res.string.edu_2_degree)
            )
            MobileDivider()
        }
    }
}

@Composable
private fun MobileEducationEntry(
    institution: String,
    degree: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.spacingLarge),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingSmall)
    ) {
        Text(
            text = institution,
            style = Typography().titleLarge,
            color = color_black
        )
        Text(
            text = degree,
            style = Typography().bodyMedium,
            color = color_zinc_500
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