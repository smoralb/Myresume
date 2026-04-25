package org.smb.resume.desktop

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Typography
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_zinc_500

@Composable
fun NavBar(scrollState: androidx.compose.foundation.ScrollState, getSectionOffset: (Int) -> Int) {
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp, horizontal = 80.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
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
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            NavItem(text = stringResource(Res.string.nav_about), sectionId = 0, scrollState = scrollState, getSectionOffset = getSectionOffset, coroutineScope = coroutineScope)
            NavItem(text = stringResource(Res.string.nav_experience), sectionId = 1, scrollState = scrollState, getSectionOffset = getSectionOffset, coroutineScope = coroutineScope)
            NavItem(text = stringResource(Res.string.nav_projects), sectionId = 2, scrollState = scrollState, getSectionOffset = getSectionOffset, coroutineScope = coroutineScope)
            NavItem(text = stringResource(Res.string.nav_contact), sectionId = 3, scrollState = scrollState, getSectionOffset = getSectionOffset, coroutineScope = coroutineScope)
        }
    }
}

@Composable
private fun NavItem(text: String, sectionId: Int, scrollState: androidx.compose.foundation.ScrollState, getSectionOffset: (Int) -> Int, coroutineScope: kotlinx.coroutines.CoroutineScope) {
    Text(
        text = text,
        style = Typography().labelMedium.copy(fontWeight = FontWeight.Medium),
        color = color_zinc_500,
        modifier = Modifier.clickable {
            coroutineScope.launch {
                val offset = getSectionOffset(sectionId)
                scrollState.scrollTo(offset)
            }
        }
    )
}
