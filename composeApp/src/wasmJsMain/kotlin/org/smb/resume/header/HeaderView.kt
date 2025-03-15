package org.smb.resume.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.smb.resume.ui.theme.Elevation
import org.smb.resume.ui.theme.Shapes
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography

@Composable
fun HeaderView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth().padding(all = Spacing.spacingLarge).verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedCard(
            shape = Shapes.large,
            elevation = CardDefaults.cardElevation(defaultElevation = Elevation.elevationLarge),
            content = {
                Image(
                    painter = painterResource(resource = Res.drawable.resume_image),
                    contentDescription = null
                )
            }
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
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