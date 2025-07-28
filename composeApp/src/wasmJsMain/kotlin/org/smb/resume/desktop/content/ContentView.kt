package org.smb.resume.desktop.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.smb.resume.desktop.content.education.EducationSection
import org.smb.resume.desktop.content.experience.ExperienceSection
import org.smb.resume.ui.theme.Spacing

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(bottom = Spacing.spacingLarge),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingExtraLarge)
    ) {
        ExperienceSection()
        EducationSection()
    }
}