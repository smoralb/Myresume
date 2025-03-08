package org.smb.resume

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.ic_under_construction
import org.jetbrains.compose.resources.painterResource
import org.smb.resume.ui.theme.MyResumeTheme
import org.smb.resume.ui.theme.Typography


@Composable
fun App() {
    MyResumeTheme {
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(state = rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Image(
                modifier = Modifier.aspectRatio(16f / 9f),
                painter = painterResource(resource = Res.drawable.ic_under_construction),
                contentDescription = null
            )
            Text(
                text = "Under constructionnnn",
                style = Typography().labelMedium
            )
        }
    }
}