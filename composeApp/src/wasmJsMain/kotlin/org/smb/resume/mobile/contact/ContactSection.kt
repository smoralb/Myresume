package org.smb.resume.mobile.contact

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.contact_socials
import myresume.composeapp.generated.resources.contact_socials_github
import myresume.composeapp.generated.resources.contact_socials_linkedin
import myresume.composeapp.generated.resources.contact_socials_medium
import myresume.composeapp.generated.resources.ic_old_pc
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_inverse
import org.smb.resume.ui.theme.color_tomato

@Composable
fun ContactSection(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.align(Alignment.TopEnd).background(
                color = color_tomato, shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
            ).padding(horizontal = Spacing.spacingExtraLarge).padding(bottom = Spacing.spacingLarge)
        ) {
            Row(
                modifier = Modifier.padding(vertical = Spacing.spacingMedium),
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