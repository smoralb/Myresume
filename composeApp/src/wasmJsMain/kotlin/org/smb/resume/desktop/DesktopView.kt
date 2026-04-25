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
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
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
    val sectionOffsets = remember { mutableStateMapOf<Int, Int>() }

    val getSectionOffset: (Int) -> Int = { id -> sectionOffsets[id] ?: 0 }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
            .background(color_white)
    ) {
        NavBar(scrollState = scrollState, getSectionOffset = getSectionOffset)
        HeroSection()
        BlackDivider()
        AboutSection(modifier = Modifier.onGloballyPositioned { coords -> sectionOffsets[0] = coords.positionInRoot().y.toInt() })
        BlackDivider()
        ExperienceSection(modifier = Modifier.onGloballyPositioned { coords -> sectionOffsets[1] = coords.positionInRoot().y.toInt() })
        ProjectsSection(modifier = Modifier.onGloballyPositioned { coords -> sectionOffsets[2] = coords.positionInRoot().y.toInt() })
        BlackDivider()
        EducationSection(modifier = Modifier.onGloballyPositioned { coords -> sectionOffsets[3] = coords.positionInRoot().y.toInt() })
        ContactSection(modifier = Modifier.onGloballyPositioned { coords -> sectionOffsets[4] = coords.positionInRoot().y.toInt() })
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