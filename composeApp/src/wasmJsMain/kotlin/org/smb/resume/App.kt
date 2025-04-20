package org.smb.resume

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.smb.resume.footer.FooterView
import org.smb.resume.header.HeaderView
import org.smb.resume.ui.theme.MyResumeTheme
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography


@Composable
fun App() {
    MyResumeTheme {
        Scaffold {
            Column(
                modifier = Modifier
                    .verticalScroll(state = rememberScrollState()),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
            ) {
                HeaderView(
                    modifier = Modifier.padding(all = Spacing.spacingExtraLarge)
                )
                Text("Projects section", style = Typography().displayMedium)
                HorizontalDivider()
                Text("All the logos of the companies I have working on with a small description")

               FooterView()
            }
        }
    }
}