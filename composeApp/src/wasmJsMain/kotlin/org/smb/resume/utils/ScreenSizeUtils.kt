package org.smb.resume.utils

import kotlinx.browser.window
import androidx.compose.runtime.*
import org.w3c.dom.events.Event

@Composable
fun observeWindowSize(): Int {
    val width = remember { mutableStateOf(window.innerWidth) }

    DisposableEffect(Unit) {
        val listener: (Event) -> Unit = {
            width.value = window.innerWidth
        }
        window.addEventListener("resize", listener)

        onDispose {
            window.removeEventListener("resize", listener)
        }
    }

    return width.value
}

enum class ScreenSizeType(val value: Int) {
    COMPACT(600)
}
