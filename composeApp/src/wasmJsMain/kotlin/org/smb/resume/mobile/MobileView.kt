package org.smb.resume.mobile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.smb.resume.mobile.contact.ContactMobileSection
import org.smb.resume.mobile.content.about.AboutMobileSection
import org.smb.resume.mobile.content.education.EducationMobileSection
import org.smb.resume.mobile.content.experience.ExperienceMobileSection
import org.smb.resume.mobile.content.projects.ProjectsMobileSection
import org.smb.resume.mobile.footer.FooterMobileView
import org.smb.resume.mobile.header.HeaderMobileView
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_white

@Composable
fun MobileView() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(state = scrollState)
            .background(color_white)
    ) {
        HeaderMobileView()
        BlackDivider()
        AboutMobileSection()
        BlackDivider()
        ExperienceMobileSection()
        ProjectsMobileSection()
        BlackDivider()
        EducationMobileSection()
        ContactMobileSection()
        FooterMobileView()
    }
}

@Composable
private fun BlackDivider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(3.dp)
            .background(color_black)
    )
}