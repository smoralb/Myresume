package org.smb.resume

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.smb.resume.header.HeaderView
import org.smb.resume.ui.theme.MyResumeTheme
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography


@Composable
fun App() {
    MyResumeTheme {
        Scaffold(
            topBar = {
                HeaderView()
            },
            content = { contentPadding ->
                Column(
                    modifier = Modifier.fillMaxWidth().padding(contentPadding),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(Spacing.spacingExtraLarge)
                ) {
                    Text("Projects section", style = Typography().displayMedium)
                    HorizontalDivider()
                    Text("All the logos of the companies I have working on with a small description")
                }
            },
            bottomBar = {
                Surface(modifier = Modifier.fillMaxWidth(), color = Color.DarkGray) {
                    Text(text = "Contact and social media", color = Color.White)
                }
            }
        )
    }
}