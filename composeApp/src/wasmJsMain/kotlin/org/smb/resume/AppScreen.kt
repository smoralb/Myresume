package org.smb.resume

import androidx.compose.runtime.Composable
import org.smb.resume.desktop.DesktopView
import org.smb.resume.ui.theme.MyResumeTheme

@Composable
fun AppScreen() {
    MyResumeTheme {
        DesktopView()
    }
}