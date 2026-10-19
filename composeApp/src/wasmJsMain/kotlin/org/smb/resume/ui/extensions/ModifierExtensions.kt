package org.smb.resume.ui.extensions

import androidx.compose.foundation.ScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.onGloballyPositioned

@Composable
fun Modifier.parallaxLayoutModifier(scrollState: ScrollState, rate: Int) =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val height = if (rate > 0) scrollState.value / rate else scrollState.value
        layout(placeable.width, placeable.height) {
            placeable.place(0, height)
        }
    }

@Composable
fun rememberIsVisibleEnough(threshold: Float = 0.30f): Pair<Boolean, Modifier> {
    var isVisible by remember { mutableStateOf(false) }
    val visibilityModifier = Modifier.onGloballyPositioned { coordinates ->
        val sectionHeight = coordinates.size.height.toFloat()
        val visibleHeight = coordinates.boundsInWindow().height
        isVisible = sectionHeight > 0f && (visibleHeight / sectionHeight) >= threshold
    }
    return isVisible to visibilityModifier
}
