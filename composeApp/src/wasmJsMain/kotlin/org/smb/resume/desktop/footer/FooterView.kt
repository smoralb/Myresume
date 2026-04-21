package org.smb.resume.desktop.footer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.footer_copyright
import myresume.composeapp.generated.resources.footer_tagline
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_white
import org.smb.resume.ui.theme.color_zinc_400

@Composable
fun FooterView(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color_white)
            .border(width = 2.dp, color = color_black)
            .padding(vertical = 24.dp, horizontal = 80.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(Res.string.footer_copyright),
            style = Typography().bodySmall.copy(fontSize = Typography().bodySmall.fontSize),
            color = color_zinc_400
        )
        Text(
            text = stringResource(Res.string.footer_tagline),
            style = Typography().bodySmall.copy(fontSize = Typography().bodySmall.fontSize),
            color = color_zinc_400
        )
    }
}
