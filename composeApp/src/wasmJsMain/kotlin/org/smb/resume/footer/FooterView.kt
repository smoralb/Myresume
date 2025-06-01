package org.smb.resume.footer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.*

@Composable
fun FooterView(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth().padding(top = Spacing.spacingLarge),
        shadowElevation = Elevation.elevationLarge,
        color = color_inverse,
        contentColor = color_inverse
    ) {
        Column(modifier = Modifier.padding(all = Spacing.spacingLarge)) {
            Text(
                text = stringResource(Res.string.name),
                color = color_accent,
                style = Typography().displayLarge
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
                ) {
                    Text(text = stringResource(Res.string.footer_socials), style = Typography().labelMedium)
                    Text(text = stringResource(Res.string.footer_socials_linkedin), style = Typography().labelMedium)
                    Text(text = stringResource(Res.string.footer_socials_github), style = Typography().labelMedium)
                    Text(text = stringResource(Res.string.footer_socials_medium), style = Typography().labelMedium)
                }
                Spacer(modifier = Modifier.weight(1f))
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(Spacing.spacingSmall)
                    ) {
                        Image(
                            modifier = Modifier.size(40.dp),
                            painter = painterResource(Res.drawable.ic_compose_multiplatform),
                            contentDescription = null
                        )
                        Text(text = stringResource(Res.string.footer_language), style = Typography().labelMedium)
                    }
                    Text(
                        modifier = Modifier.align(Alignment.End),
                        text = stringResource(Res.string.footer_year),
                        style = Typography().labelMedium
                    )
                }
            }
        }
    }
}