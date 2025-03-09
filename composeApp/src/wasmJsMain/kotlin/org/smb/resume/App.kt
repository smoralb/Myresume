package org.smb.resume

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.smb.resume.header.HeaderView
import org.smb.resume.ui.theme.MyResumeTheme
import org.smb.resume.ui.theme.Spacing


@Composable
fun App() {
    MyResumeTheme {
        Scaffold(
            modifier = Modifier.padding(all = Spacing.spacingExtraLarge),
            topBar = {
                HeaderView()
            },
            content = {

            }
        )
    }
}