package org.smb.resume.mobile.contact

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_inverse
import org.smb.resume.ui.theme.color_tomato

@Composable
fun ContactMobileSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = color_tomato)
            .padding(vertical = Spacing.spacingMedium)
            .padding(horizontal = Spacing.spacingMedium)
            .padding(bottom = Spacing.spacingSmall)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Spacing.spacingLarge),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(Res.string.contact_socials),
                style = Typography().headlineMedium,
                color = color_inverse
            )
            Image(
                modifier = Modifier.size(80.dp),
                painter = painterResource(Res.drawable.ic_old_pc),
                contentDescription = null
            )
        }
        ContactText(
            text = stringResource(Res.string.contact_socials_linkedin),
            url = "https://www.linkedin.com/in/sergiomoralbermudez/"
        )
        ContactText(
            text = stringResource(Res.string.contact_socials_github), url = "https://github.com/smoralb"
        )
        ContactText(
            text = stringResource(Res.string.contact_socials_medium), url = "https://medium.com/@smoralber"
        )
    }
}

@Composable
fun ContactText(modifier: Modifier = Modifier, text: String, url: String) {
    Text(
        modifier = modifier.clickable {
            window.open(url = url)
        }.padding(start = Spacing.spacingSmall),
        text = text,
        style = Typography().headlineSmall,
        textDecoration = TextDecoration.Underline,
        color = color_inverse
    )
}