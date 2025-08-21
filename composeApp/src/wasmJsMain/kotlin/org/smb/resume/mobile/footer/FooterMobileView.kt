package org.smb.resume.mobile.footer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.footer_language
import myresume.composeapp.generated.resources.footer_year
import myresume.composeapp.generated.resources.ic_compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.*

@Composable
fun FooterMobileView(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shadowElevation = Elevation.elevationLarge,
        color = color_grey,
        contentColor = color_inverse
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = Spacing.spacingLarge, horizontal = Spacing.spacingMedium)
        ) {
            Row(
                modifier = Modifier.align(Alignment.End),
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