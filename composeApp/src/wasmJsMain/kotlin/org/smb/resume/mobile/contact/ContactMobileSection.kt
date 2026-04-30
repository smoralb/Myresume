package org.smb.resume.mobile.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_white
import org.smb.resume.ui.theme.color_zinc_400
import org.smb.resume.ui.theme.color_zinc_500

@Composable
fun ContactMobileSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color_black)
            .padding(vertical = Spacing.spacingExtraLarge, horizontal = Spacing.spacingLarge),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Spacing.spacingLarge)
    ) {
        Text(
            text = stringResource(Res.string.contact_label),
            style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold),
            color = color_zinc_500
        )
        Text(
            text = stringResource(Res.string.contact_title),
            style = Typography().displaySmall,
            color = color_white,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(Res.string.contact_email),
            style = Typography().bodyMedium.copy(letterSpacing = Typography().bodyMedium.letterSpacing),
            color = color_zinc_400
        )

        Column(
            modifier = Modifier
                .background(color_white)
                .clickable {
                    window.open("mailto:smoralber@gmail.com")
                }
                .padding(vertical = Spacing.spacingMedium, horizontal = Spacing.spacingLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(Res.string.contact_cta),
                style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold, letterSpacing = Typography().labelLarge.letterSpacing),
                color = color_black
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
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