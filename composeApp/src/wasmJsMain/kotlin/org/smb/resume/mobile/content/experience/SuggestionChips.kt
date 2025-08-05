package org.smb.resume.mobile.content.experience

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.smb.resume.common.experience.TechDescription
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_dark_blue
import org.smb.resume.ui.theme.color_light_blue


@Composable
fun SuggestionChips(description: TechDescription) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacingSmall),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingExtraSmall)
    ) {
        description.description.split(",").forEach { technology ->
            SuggestionChip(
                onClick = {},
                label = {
                    Text(
                        text = technology,
                        style = Typography().labelMedium
                    )
                },
                border = null,
                colors = AssistChipDefaults.assistChipColors(
                    containerColor = color_light_blue,
                    labelColor = color_dark_blue
                )
            )
        }
    }
}