package org.smb.resume.desktop.content.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
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
        BasicText(
            text = stringResource(title),
            color = { color_inverse },
            autoSize = TextAutoSize.StepBased(
                minFontSize = Typography().displayLarge.fontSize,
                maxFontSize = Typography().displaySmall.fontSize,
                stepSize = 10.sp
            )
        )
        Text(
            text = "-", style = Typography().headlineMedium, fontFamily = spaceMonoFont(), color = Color.Green
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}