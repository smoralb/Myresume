package org.smb.resume.desktop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.smb.resume.desktop.content.about.AboutSection
import org.smb.resume.desktop.content.contact.ContactSection
import org.smb.resume.desktop.content.education.EducationSection
import org.smb.resume.desktop.content.experience.ExperienceSection
import org.smb.resume.desktop.content.hero.HeroSection
import org.smb.resume.desktop.content.projects.ProjectsSection
import org.smb.resume.desktop.footer.FooterView
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_white

@Composable
fun DesktopView() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .background(color_white)
    ) {
        NavBar()
        HeroSection()
        BlackDivider()
        AboutSection()
        BlackDivider()
        ExperienceSection()
        ProjectsSection()
        BlackDivider()
        EducationSection()
        ContactSection()
        FooterView()
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
