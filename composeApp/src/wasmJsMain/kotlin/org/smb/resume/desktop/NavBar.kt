package org.smb.resume.desktop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_zinc_500

@Composable
fun NavBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp, horizontal = 80.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "SM.",
            style = Typography().headlineMedium.copy(
                fontWeight = FontWeight.Black,
                letterSpacing = (-1).sp
            ),
            color = color_black
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val navStyle = Typography().labelMedium.copy(fontWeight = FontWeight.Medium)
            Text(text = stringResource(Res.string.nav_about), style = navStyle, color = color_zinc_500)
            Text(text = stringResource(Res.string.nav_experience), style = navStyle, color = color_zinc_500)
            Text(text = stringResource(Res.string.nav_projects), style = navStyle, color = color_zinc_500)
            Text(text = stringResource(Res.string.nav_contact), style = navStyle, color = color_zinc_500)
        }
    }
}
