package org.smb.resume.mobile.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.smb.resume.mobile.content.education.EducationMobileSection
import org.smb.resume.mobile.content.experience.ExperienceMobileSection
import org.smb.resume.ui.theme.Spacing

@Composable
fun ContentMobileView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(bottom = Spacing.spacingLarge),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingExtraLarge)
    ) {
        ExperienceMobileSection()
        EducationMobileSection()
    }
}