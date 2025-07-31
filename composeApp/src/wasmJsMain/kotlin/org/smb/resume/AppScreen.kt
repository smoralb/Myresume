package org.smb.resume

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import org.smb.resume.desktop.DesktopView
import org.smb.resume.mobile.MobileView
import org.smb.resume.ui.theme.MyResumeTheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun AppScreen() {

    val screenSize = calculateWindowSizeClass()

    MyResumeTheme {
        when (screenSize.widthSizeClass) {
            WindowWidthSizeClass.Compact -> MobileView()
            else -> DesktopView()
        }
    }
}