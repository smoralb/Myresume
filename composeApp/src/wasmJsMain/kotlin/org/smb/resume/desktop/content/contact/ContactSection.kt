package org.smb.resume.desktop.content.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.*

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color_black)
            .padding(vertical = 120.dp, horizontal = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Text(
            text = stringResource(Res.string.contact_label),
            style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold),
            color = color_zinc_500
        )
        Text(
            text = stringResource(Res.string.contact_title),
            style = Typography().displayMedium,
            color = color_white,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(Res.string.contact_email),
            style = Typography().titleMedium.copy(letterSpacing = Typography().titleMedium.letterSpacing),
            color = color_zinc_400
        )

        // CTA Button
        Box(
            modifier = Modifier
                .background(color_white)
                .clickable {
                    window.open("mailto:smoralber@gmail.com")
                }
                .padding(vertical = 20.dp, horizontal = 48.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(Res.string.contact_cta),
                style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold, letterSpacing = Typography().labelLarge.letterSpacing),
                color = color_black
            )
        }

        // Social links
        Row(
            horizontalArrangement = Arrangement.spacedBy(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(Res.string.contact_social_github),
                style = Typography().labelMedium,
                color = color_zinc_500,
                modifier = Modifier.clickable { window.open("https://github.com/smoralb") }
            )
            Text(
                text = stringResource(Res.string.contact_social_linkedin),
                style = Typography().labelMedium,
                color = color_zinc_500,
                modifier = Modifier.clickable { window.open("https://www.linkedin.com/in/sergiomoralbermudez/") }
            )
        }
    }
}
