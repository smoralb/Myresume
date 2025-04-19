package org.smb.resume

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import org.smb.resume.footer.FooterView
import org.smb.resume.header.HeaderView
import org.smb.resume.ui.theme.MyResumeTheme
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography


@Composable
fun App() {
    MyResumeTheme {
        val screenSize = remember { mutableStateOf(Pair(-1, -1)) }
        Layout(
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(state = rememberScrollState()),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(Spacing.spacingMedium)
                ) {
                    HeaderView(
                        modifier = Modifier.height(screenSize.value.first.dp).padding(all = Spacing.spacingExtraLarge)
                    )
                    Text("Projects section", style = Typography().displayMedium)
                    HorizontalDivider()
                    Text("All the logos of the companies I have working on with a small description")

                    FooterView()
                }
            },
            measurePolicy = { measurables, constraints ->
                // Use the max width and height from the constraints
                val width = constraints.maxWidth
                val height = constraints.maxHeight

                screenSize.value = Pair(width, height)
                println("Width: $width, height: $height")

                // Measure and place children composables
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