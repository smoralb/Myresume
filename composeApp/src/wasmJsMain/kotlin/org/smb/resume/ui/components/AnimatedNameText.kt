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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import org.smb.resume.ui.theme.color_black
import org.smb.resume.ui.theme.color_yellow_accent

@Composable
fun AnimatedNameText(
    line1: String,
    line2: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    lineSpacing: Dp = 32.dp,
    baseColor: Color = color_black,
    highlightColor: Color = color_yellow_accent,
    durationMillis: Int = 900,
    skewFraction: Float = 0.18f,
    autoShrinkToWidth: Boolean = false
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    var hasTriggered by remember { mutableStateOf(false) }
    val progress = remember { Animatable(0f) }

    LaunchedEffect(isHovered) {
        if (isHovered && !hasTriggered) {
            hasTriggered = true
        }
    }

    LaunchedEffect(hasTriggered) {
        if (hasTriggered) {
            progress.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = durationMillis,
                    easing = FastOutSlowInEasing
                )
            )
        }
    }

    if (autoShrinkToWidth) {
        BoxWithConstraints(modifier = modifier.hoverable(interactionSource)) {
            val measurer = rememberTextMeasurer()
            val effectiveStyle = remember(line1, line2, textStyle, constraints) {
                if (!constraints.hasBoundedWidth) {
                    textStyle
                } else {
                    val maxW = constraints.maxWidth
                    val w1 = measurer.measure(text = line1, style = textStyle, constraints = Constraints()).size.width
                    val w2 = measurer.measure(text = line2, style = textStyle, constraints = Constraints()).size.width
                    val widest = maxOf(w1, w2)
                    if (widest == 0 || widest <= maxW) {
                        textStyle
                    } else {
                        val scale = maxW.toFloat() / widest.toFloat()
                        textStyle.copy(
                            fontSize = if (textStyle.fontSize.isSpecified) textStyle.fontSize * scale else textStyle.fontSize,
                            lineHeight = if (textStyle.lineHeight.isSpecified) textStyle.lineHeight * scale else textStyle.lineHeight,
                            letterSpacing = if (textStyle.letterSpacing.isSpecified) textStyle.letterSpacing * scale else textStyle.letterSpacing
                        )
                    }
                }
            }
            AnimatedNameContent(
                line1 = line1,
                line2 = line2,
                textStyle = effectiveStyle,
                lineSpacing = lineSpacing,
                baseColor = baseColor,
                highlightColor = highlightColor,
                progress = { progress.value },
                skewFraction = skewFraction
            )
        }
    } else {
        Box(modifier = modifier.hoverable(interactionSource)) {
            AnimatedNameContent(
                line1 = line1,
                line2 = line2,
                textStyle = textStyle,
                lineSpacing = lineSpacing,
                baseColor = baseColor,
                highlightColor = highlightColor,
                progress = { progress.value },
                skewFraction = skewFraction
            )
        }
    }
}

@Composable
private fun BoxScope.AnimatedNameContent(
    line1: String,
    line2: String,
    textStyle: TextStyle,
    lineSpacing: Dp,
    baseColor: Color,
    highlightColor: Color,
    progress: () -> Float,
    skewFraction: Float
) {
    Column(verticalArrangement = Arrangement.spacedBy(lineSpacing)) {
        Text(text = line1, style = textStyle, color = baseColor)
        Text(text = line2, style = textStyle, color = baseColor)
    }
    YellowOverlay(progress = progress, skewFraction = skewFraction) {
        Column(verticalArrangement = Arrangement.spacedBy(lineSpacing)) {
            Text(text = line1, style = textStyle, color = highlightColor)
            Text(text = line2, style = textStyle, color = highlightColor)
        }
    }
}

@Composable
private fun BoxScope.YellowOverlay(
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
