package org.smb.resume.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_blue_accent
import org.smb.resume.ui.theme.color_green_accent
import org.smb.resume.ui.theme.color_magenta_accent
import org.smb.resume.ui.theme.color_yellow_accent

private val defaultHighlightColors = listOf(
    color_yellow_accent,
    color_green_accent,
    color_blue_accent,
    color_magenta_accent
)

@Composable
fun AnimatedNameText(
    line1: String,
    line2: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    lineSpacing: Dp = 32.dp,
    baseColor: Color = color_black,
    highlightColors: List<Color> = defaultHighlightColors,
    durationMillis: Int = 900,
    skewFraction: Float = 0.18f
) {
    require(highlightColors.isNotEmpty())

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    // colorIndex: which color from the list is about to be painted next
    var colorIndex by remember { mutableIntStateOf(0) }
    // settledIndex: the color currently showing as the base (-1 = original baseColor)
    var settledIndex by remember { mutableIntStateOf(-1) }
    var isAnimating by remember { mutableStateOf(false) }
    var triggerCount by remember { mutableIntStateOf(0) }
    val progress = remember { Animatable(0f) }

    val activeBaseColor = if (settledIndex < 0) baseColor else highlightColors[settledIndex]
    val overlayColor = highlightColors[colorIndex]

    // Arms the next animation on hover (only when idle)
    LaunchedEffect(isHovered) {
        if (isHovered && !isAnimating) {
            triggerCount++
        }
    }

    // Runs the animation to completion regardless of hover state.
    // Keyed on triggerCount so un-hover mid-animation does NOT cancel this coroutine.
    LaunchedEffect(triggerCount) {
        if (triggerCount > 0) {
            isAnimating = true
            progress.snapTo(0f)
            progress.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = durationMillis, easing = FastOutSlowInEasing)
            )
            // Lock in the painted color as the new base, then hide the overlay
            // before advancing colorIndex to avoid a one-frame flash of the wrong color.
            settledIndex = colorIndex
            progress.snapTo(0f)
            colorIndex = (colorIndex + 1) % highlightColors.size
            isAnimating = false
        }
    }

    Box(modifier = modifier.hoverable(interactionSource)) {
        Column(verticalArrangement = Arrangement.spacedBy(lineSpacing)) {
            Text(text = line1, style = textStyle, color = activeBaseColor)
            Text(text = line2, style = textStyle, color = activeBaseColor)
        }
        DiagonalOverlay(
            progress = { progress.value },
            skewFraction = skewFraction
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(lineSpacing)) {
                Text(text = line1, style = textStyle, color = overlayColor)
                Text(text = line2, style = textStyle, color = overlayColor)
            }
        }
    }
}

@Composable
private fun BoxScope.DiagonalOverlay(
    progress: () -> Float,
    skewFraction: Float,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .matchParentSize()
            .drawWithContent {
                val p = progress().coerceIn(0f, 1f)
                val skew = size.height * skewFraction
                val totalRange = size.width + skew
                val topX = p * totalRange
                val bottomX = topX - skew
                val path = Path().apply {
                    moveTo(0f, 0f)
                    lineTo(topX, 0f)
                    lineTo(bottomX, size.height)
                    lineTo(0f, size.height)
                    close()
                }
                clipPath(path) {
                    this@drawWithContent.drawContent()
                }
            }
    ) {
        content()
    }
}
