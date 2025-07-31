package org.smb.resume

import androidx.compose.runtime.Composable
import org.smb.resume.desktop.DesktopView
import org.smb.resume.mobile.MobileView
import org.smb.resume.ui.theme.MyResumeTheme
import org.smb.resume.utils.ScreenSizeType
import org.smb.resume.utils.observeWindowSize

@Composable
fun AppScreen() {

    val screenSize = observeWindowSize()

    MyResumeTheme {
        when {
            screenSize < ScreenSizeType.COMPACT.value -> MobileView()
            else -> DesktopView()
        }
    }
}