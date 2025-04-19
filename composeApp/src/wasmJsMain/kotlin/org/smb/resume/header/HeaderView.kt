package org.smb.resume.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Elevation
import org.smb.resume.ui.theme.Shapes
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography

@Composable
fun HeaderView(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxHeight(),
        horizontalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
    ) {
        NameSection(modifier = Modifier.weight(weight = 2f))
        PhotoSection(modifier = Modifier.weight(weight = 1f))
    }
}

@Composable
private fun NameSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Start).fillMaxWidth(),
            text = stringResource(Res.string.name),
            style = Typography().displayLarge
        )
        Row(
            modifier = Modifier.align(Alignment.End),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
        ) {
            Image(
                modifier = Modifier.size(60.dp),
                painter = painterResource(Res.drawable.ic_android),
                contentDescription = null
            )
            Text(
                text = stringResource(Res.string.role),
                style = Typography().headlineLarge
            )
        }
    }
}

@Composable
private fun PhotoSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
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
        Text(
            modifier = Modifier.align(Alignment.End),
            text = stringResource(Res.string.location),
            style = Typography().labelMedium
        )
    }
}