package org.smb.resume

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.resume_image
import org.jetbrains.compose.resources.painterResource
import org.smb.resume.ui.theme.*


@Composable
fun App() {
    MyResumeTheme {
        Row(
            modifier = Modifier.fillMaxWidth().verticalScroll(state = rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
            verticalAlignment = Alignment.Top
        ) {
            ElevatedCard(
                shape = Shapes.medium,
                elevation = CardDefaults.cardElevation(defaultElevation = Elevation.elevationLarge),
                content = {
                    Image(
                        painter = painterResource(resource = Res.drawable.resume_image),
                        contentDescription = null
                    )
                }
            )
            Text(
                text = "Sergio Moral Bermúdez",
                style = Typography().displayLarge
            )
        }
    }
}