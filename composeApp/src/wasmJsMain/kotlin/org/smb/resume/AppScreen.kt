package org.smb.resume

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.smb.resume.desktop.DesktopView
import org.smb.resume.mobile.MobileView
import org.smb.resume.ui.theme.MyResumeTheme
import org.smb.resume.utils.WindowSizeClass
import org.smb.resume.utils.getWindowSizeClass
import org.smb.resume.utils.observeWindowSize

@Composable
fun AppScreen() {

    val (screenWidth, _) = observeWindowSize()
    val windowSizeClass = getWindowSizeClass(screenWidth.dp)

    MyResumeTheme {
        when (windowSizeClass) {
            WindowSizeClass.Compact -> MobileView()
            else -> DesktopView()
        }
    }
}