package org.smb.resume

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myresume.composeapp.generated.resources.Res
import myresume.composeapp.generated.resources.ic_under_construction
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                Image(
                    modifier = Modifier.size(80.dp),
                    painter = painterResource(resource = Res.drawable.ic_under_construction),
                    contentDescription = null
                )
                Text(text = "Under construction", style = TextStyle(fontSize = 20.sp, color = Color.Black))
            }
        }
    }
}