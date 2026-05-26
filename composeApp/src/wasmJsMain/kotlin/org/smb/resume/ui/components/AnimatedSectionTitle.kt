package org.smb.resume.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AnimatedSectionTitle(
    text: String,
    textStyle: TextStyle,
    baseColor: Color,
    hoverColor: Color,
    isHovered: Boolean,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null,
    transformOrigin: TransformOrigin = TransformOrigin.Center,
    hoverScale: Float = 1.08f,
    durationMillis: Int = 300
) {
    val animatedColor by animateColorAsState(
        targetValue = if (isHovered) hoverColor else baseColor,
        animationSpec = tween(durationMillis = durationMillis, easing = FastOutSlowInEasing)
    )
    val animatedScale by animateFloatAsState(
        targetValue = if (isHovered) hoverScale else 1f,
        animationSpec = tween(durationMillis = durationMillis, easing = FastOutSlowInEasing)
    )

    Text(
        text = text,
        style = textStyle,
        color = animatedColor,
        textAlign = textAlign ?: TextAlign.Unspecified,
        modifier = modifier.graphicsLayer {
            scaleX = animatedScale
            scaleY = animatedScale
            this.transformOrigin = transformOrigin
        }
    )
}
