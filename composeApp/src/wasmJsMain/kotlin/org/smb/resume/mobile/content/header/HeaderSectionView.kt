package org.smb.resume.mobile.content.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.fonts.spaceMonoFont
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_inverse

@Composable
fun HeaderSectionView(title: StringResource) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Black)
            .padding(vertical = Spacing.spacingMedium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "-", style = Typography().headlineMedium, fontFamily = spaceMonoFont(), color = Color.Green
        )
        Text(
            modifier = Modifier.padding(horizontal = Spacing.spacingMedium),
            text = stringResource(title),
            color = color_inverse,
            style = Typography().displayMedium,
            textAlign = TextAlign.Center
        )
        Text(
            text = "-", style = Typography().headlineMedium, fontFamily = spaceMonoFont(), color = Color.Green
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}