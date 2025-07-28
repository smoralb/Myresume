package org.smb.resume.desktop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.smb.resume.desktop.content.ContentView
import org.smb.resume.desktop.footer.FooterView
import org.smb.resume.desktop.header.HeaderView
import org.smb.resume.ui.extensions.parallaxLayoutModifier
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.color_inverse


@Composable
fun DesktopView() {
    val screenSize = remember { mutableStateOf(Pair(-1, -1)) }
    val scrollState = rememberScrollState()

    Layout(
        content = {
            Column(
                modifier = Modifier.verticalScroll(state = scrollState),
                verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
            ) {
                val headerHeight = (screenSize.value.second / window.devicePixelRatio).toInt().dp

                HeaderView(
                    modifier = Modifier
                        .height(headerHeight)
                        .parallaxLayoutModifier(scrollState = scrollState, 2)
                )
                ContentView(
                    modifier = Modifier.background(color = color_inverse)
                )
                FooterView()
            }
        },
        measurePolicy = { measurables, constraints ->
            val width = constraints.maxWidth
            val height = constraints.maxHeight

            screenSize.value = Pair(width, height)

            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }

            layout(width, height) {
                var yPosition = 0
                placeables.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = yPosition)
                    yPosition += placeable.height
                }
            }
        }
    )
}