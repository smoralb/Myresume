package org.smb.resume.ui.utils

import kotlinx.browser.window
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object ScreenSizeUtil {
    private val _width = MutableStateFlow(window.innerWidth)
    val width = _width.asStateFlow()

    init {
        window.onresize = {
            _width.value = window.innerWidth
        }
    }
}