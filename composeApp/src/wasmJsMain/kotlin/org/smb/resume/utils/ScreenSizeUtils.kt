package org.smb.resume.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.w3c.dom.events.Event

@Composable
fun observeWindowSize(): Pair<Int, Int> {
    val width = remember { mutableStateOf(window.innerWidth) }
    val height = remember { mutableStateOf(window.innerHeight) }

    DisposableEffect(Unit) {
        val listener: (Event) -> Unit = {
            width.value = window.innerWidth
            height.value = window.innerHeight
        }
        window.addEventListener("resize", listener)

        onDispose {
            window.removeEventListener("resize", listener)
        }
    }

    return width.value to height.value
}

sealed class WindowSizeClass {
    object Compact : WindowSizeClass()
    object Medium : WindowSizeClass()
    object Expanded : WindowSizeClass()
}

fun getWindowSizeClass(widthDp: Dp): WindowSizeClass {
    return when {
        widthDp < 600.dp -> WindowSizeClass.Compact
        widthDp < 840.dp -> WindowSizeClass.Medium
        else -> WindowSizeClass.Expanded
    }
}
