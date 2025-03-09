package org.smb.resume.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import myresume.composeapp.generated.resources.name
import myresume.composeapp.generated.resources.resume_image
import myresume.composeapp.generated.resources.role
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Elevation
import org.smb.resume.ui.theme.Shapes
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography

@Composable
fun HeaderView(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().verticalScroll(state = rememberScrollState()),
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
        Column (
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
        ) {
            Text(
                text = stringResource(Res.string.name),
                style = Typography().displayLarge
            )
            Text(
                text = stringResource(Res.string.role),
                style = Typography().displayMedium
            )
        }
    }
}