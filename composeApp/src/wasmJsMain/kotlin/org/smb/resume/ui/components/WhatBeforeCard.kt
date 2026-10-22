package org.smb.resume.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.browser.window
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

private val wb_blue = Color(0xFF0047AB)
private val wb_blue_dark = Color(0xFF002D62)
private val wb_cream = Color(0xFFF5EEDC)
private val wb_yellow = Color(0xFFFFE135)
private val wb_pink = Color(0xFFFF6AD5)
private val wb_cyan = Color(0xFF72EFDD)
private val wb_purple = Color(0xFFC77DFF)
private val wb_black = Color(0xFF111111)

/** What Before! project card, themed after the game's pop-art comic style, with the same hover lift as Planet 23. */
@Composable
fun WhatBeforeCard(modifier: Modifier = Modifier) {
    val interaction = remember { MutableInteractionSource() }
    val hovered by interaction.collectIsHoveredAsState()
    val spec = spring<Float>(dampingRatio = 0.7f, stiffness = Spring.StiffnessLow)
    val lift by animateFloatAsState(if (hovered) 1f else 0f, spec)
    val elevation by animateDpAsState(if (hovered) 32.dp else 0.dp)

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .graphicsLayer {
                val s = 1f + 0.02f * lift
                scaleX = s
                scaleY = s
                translationY = -12.dp.toPx() * lift
            }
            .hoverable(interaction)
            .pointerHoverIcon(PointerIcon.Hand)
            .clickable(interactionSource = interaction, indication = null) {
                window.open("https://smoralb.github.io/WhatBefore/", "_blank")
            },
        shape = RoundedCornerShape(16.dp),
        color = wb_blue,
        shadowElevation = elevation
    ) {
        // SpaceBetween keeps the button at the bottom when a min height matches this card to its neighbour
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Spacing.spacingMedium),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                WhatBeforeVisual(lift, Modifier.fillMaxWidth().height(200.dp))
                Spacer(modifier = Modifier.height(Spacing.spacingMedium))
                Text(
                    text = stringResource(Res.string.proj_card2_tag),
                    style = Typography().labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = wb_yellow
                )
                Spacer(modifier = Modifier.height(Spacing.spacingSmall))
                Text(
                    text = stringResource(Res.string.proj_card2_title),
                    style = Typography().titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = wb_cream
                )
                Text(
                    text = stringResource(Res.string.proj_card2_tagline),
                    style = Typography().titleSmall,
                    color = wb_cyan
                )
                Spacer(modifier = Modifier.height(Spacing.spacingSmall))
                Text(
                    text = stringResource(Res.string.proj_card2_desc),
                    style = Typography().bodyMedium,
                    color = wb_cream.copy(alpha = 0.8f)
                )
                Spacer(modifier = Modifier.height(Spacing.spacingMedium))
            }
            // Comic-style button: black outline with a hard offset shadow
            Box(modifier = Modifier.fillMaxWidth()) {
                Box(
                    Modifier
                        .matchParentSize()
                        .offset(x = 4.dp, y = 4.dp)
                        .background(wb_black, RoundedCornerShape(50))
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(wb_yellow, RoundedCornerShape(50))
                        .border(2.dp, wb_black, RoundedCornerShape(50))
                        .padding(vertical = 14.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(Res.string.proj_card2_link),
                        style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = wb_black
                    )
                }
            }
        }
    }
}

/** Comic starburst over a halftone field, with two quiz answer tiles that fan out on hover. */
@Composable
private fun WhatBeforeVisual(lift: Float, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Canvas(Modifier.fillMaxSize()) {
            val c = center
            // Halftone dots, larger towards the centre
            val step = 14.dp.toPx()
            val maxDist = size.minDimension * 0.9f
            var y = step / 2
            while (y < size.height) {
                var x = step / 2
                while (x < size.width) {
                    val d = (Offset(x, y) - c).getDistance()
                    val r = (1f - d / maxDist).coerceIn(0f, 1f) * step * 0.28f
                    if (r > 0.5f) drawCircle(wb_blue_dark, radius = r, center = Offset(x, y))
                    x += step
                }
                y += step
            }
            // Starburst
            val outer = size.height * 0.46f
            val inner = outer * 0.72f
            val points = 14
            val burst = Path().apply {
                for (i in 0 until points * 2) {
                    val radius = if (i % 2 == 0) outer else inner
                    val angle = (PI * i / points).toFloat()
                    val p = c + Offset(cos(angle) * radius * 1.15f, sin(angle) * radius)
                    if (i == 0) moveTo(p.x, p.y) else lineTo(p.x, p.y)
                }
                close()
            }
            rotate(degrees = 6f * lift, pivot = c) {
                drawPath(burst, wb_black, style = Stroke(width = 4.dp.toPx()))
                drawPath(burst, wb_cream)
            }
            // Confetti shapes
            drawCircle(wb_cyan, radius = 10f, center = c + Offset(-outer * 1.3f, -outer * 0.6f))
            drawCircle(wb_pink, radius = 6f, center = c + Offset(outer * 1.3f, outer * 0.6f))
            val tri = Path().apply {
                val o = c + Offset(outer * 1.25f, -outer * 0.7f)
                moveTo(o.x, o.y - 9f); lineTo(o.x + 9f, o.y + 7f); lineTo(o.x - 9f, o.y + 7f); close()
            }
            drawPath(tri, wb_yellow)
        }
        // Answer A
        QuizTile(
            label = "A",
            color = wb_pink,
            modifier = Modifier.graphicsLayer {
                rotationZ = -8f - 4f * lift
                translationX = (-30.dp.toPx()) - 12.dp.toPx() * lift
                translationY = 6.dp.toPx() - 4.dp.toPx() * lift
            }
        )
        // Answer B
        QuizTile(
            label = "B",
            color = wb_cyan,
            modifier = Modifier.graphicsLayer {
                rotationZ = 6f + 4f * lift
                translationX = 30.dp.toPx() + 12.dp.toPx() * lift
                translationY = 6.dp.toPx() - 4.dp.toPx() * lift
            }
        )
        // Question bubble
        Box(
            modifier = Modifier
                .graphicsLayer {
                    translationY = -44.dp.toPx() - 8.dp.toPx() * lift
                    val s = 1f + 0.12f * lift
                    scaleX = s
                    scaleY = s
                }
                .size(40.dp)
                .background(wb_yellow, CircleShape)
                .border(3.dp, wb_black, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "?",
                style = Typography().titleLarge.copy(fontWeight = FontWeight.Black, fontSize = 22.sp),
                color = wb_black
            )
        }
    }
}

@Composable
private fun QuizTile(label: String, color: Color, modifier: Modifier = Modifier, shadow: Dp = 4.dp) {
    val shape = RoundedCornerShape(10.dp)
    Box(modifier = modifier.size(width = 68.dp, height = 84.dp)) {
        Box(
            Modifier
                .matchParentSize()
                .offset(x = shadow, y = shadow)
                .background(wb_black, shape)
        )
        Column(
            modifier = Modifier
                .matchParentSize()
                .background(color, shape)
                .border(3.dp, wb_black, shape)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = label,
                style = Typography().titleLarge.copy(fontWeight = FontWeight.Black, fontSize = 26.sp),
                color = wb_black
            )
            Box(Modifier.fillMaxWidth(0.85f).height(6.dp).background(wb_black.copy(alpha = 0.8f), RoundedCornerShape(50)))
            Box(Modifier.fillMaxWidth(0.55f).height(6.dp).background(wb_purple, RoundedCornerShape(50)))
        }
    }
}
