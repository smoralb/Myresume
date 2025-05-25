package org.smb.resume

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.smb.resume.content.ContentView
import org.smb.resume.footer.FooterView
import org.smb.resume.header.HeaderView
import org.smb.resume.ui.theme.MyResumeTheme
import org.smb.resume.ui.theme.Spacing


@Composable
fun App() {
    MyResumeTheme {
        Scaffold(
            content = { contentPadding ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues = contentPadding)
                        .verticalScroll(state = rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
                ) {
                    HeaderView(
                        modifier = Modifier.padding(horizontal = Spacing.spacingExtraLarge)
                    )
                    ContentView(
                        modifier = Modifier.padding(horizontal = Spacing.spacingExtraLarge))
                    FooterView()
                }
            }
        )
    }
}