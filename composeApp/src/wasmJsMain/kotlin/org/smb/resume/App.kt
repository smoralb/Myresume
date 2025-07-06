package org.smb.resume

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import org.smb.resume.content.ContentView
import org.smb.resume.footer.FooterView
import org.smb.resume.header.HeaderView
import org.smb.resume.ui.extensions.parallaxLayoutModifier
import org.smb.resume.ui.theme.MyResumeTheme
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.color_inverse

@Composable
fun App() {
    MyResumeTheme {

        // Mantener la referencia al tamaño de la pantalla
        val screenSize = remember { mutableStateOf(Pair(-1, -1)) }
        val scrollState = rememberScrollState()

        // Layout con una columna scrollable
        Layout(
            content = {
                Column(
                    modifier = Modifier
                        .verticalScroll(state = scrollState)
                        .padding(horizontal = Spacing.spacingMedium),
                    verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
                ) {
                    // Calculamos la altura en DP para el HeaderView
                    val headerHeight = (screenSize.value.second / window.devicePixelRatio).toInt().dp

                    HeaderView(
                        modifier = Modifier
                            .height(headerHeight) // Asignamos la altura calculada al HeaderView
                            .parallaxLayoutModifier(scrollState = scrollState, 2) // Si quieres el efecto de parallax
                    )
                    ContentView(
                        modifier = Modifier
                            .background(color = color_inverse)
                            .padding(horizontal = Spacing.spacingExtraLarge)
                    )
                    FooterView()
                }
            },
            measurePolicy = { measurables, constraints ->
                val width = constraints.maxWidth
                val height = constraints.maxHeight

                // Asignando el tamaño de pantalla calculado (tamaño total)
                screenSize.value = Pair(width, height)

                println("Width: $width, Height: $height")

                // Medir y colocar los elementos hijos
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
}