package org.smb.resume.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.smb.resume.ui.theme.color_grey

@Composable
fun CircleShapeComponent() {
    Canvas(modifier = Modifier.size(10.dp)) {
        drawCircle(color = color_grey)
    }
}