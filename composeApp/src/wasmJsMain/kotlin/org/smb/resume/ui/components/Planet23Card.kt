package org.smb.resume.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.browser.window
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.Spacing
import org.smb.resume.ui.theme.Typography

private val p23_bg = Color(0xFF07191A)
private val p23_teal = Color(0xFF0B2A2B)
private val p23_cream = Color(0xFFF0E6D2)
private val p23_yellow = Color(0xFFF3CB2B)
private val p23_pink = Color(0xFFFFB2C2)
private val p23_purple = Color(0xFF794BC4)
private val p23_green = Color(0xFF007048)
private val p23_red = Color(0xFFC0392B)
private val p23_zinc = Color(0xFF939F9F)

/** Planet 23 project card, themed after planet23.app, with a hover lift on the Z axis. */
@Composable
fun Planet23Card(modifier: Modifier = Modifier) {
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
                window.open("https://planet23.app", "_blank")
            },
        shape = RoundedCornerShape(16.dp),
        color = p23_bg,
        shadowElevation = elevation
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Spacing.spacingMedium)
        ) {
            Planet23Visual(lift, Modifier.fillMaxWidth().height(200.dp))
            Spacer(modifier = Modifier.height(Spacing.spacingMedium))
            Text(
                text = stringResource(Res.string.proj_p23_tag),
                style = Typography().labelSmall.copy(fontWeight = FontWeight.Bold),
                color = p23_yellow
            )
            Spacer(modifier = Modifier.height(Spacing.spacingSmall))
            Text(
                text = stringResource(Res.string.proj_p23_title),
                style = Typography().titleLarge.copy(fontWeight = FontWeight.Bold),
                color = p23_cream
            )
            Text(
                text = stringResource(Res.string.proj_p23_tagline),
                style = Typography().titleSmall,
                color = p23_pink
            )
            Spacer(modifier = Modifier.height(Spacing.spacingSmall))
            Text(
                text = stringResource(Res.string.proj_p23_desc),
                style = Typography().bodyMedium,
                color = p23_cream.copy(alpha = 0.75f)
            )
            Spacer(modifier = Modifier.height(Spacing.spacingMedium))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(p23_yellow, RoundedCornerShape(50))
                    .padding(vertical = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(Res.string.proj_p23_link),
                    style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = p23_bg
                )
            }
        }
    }
}

/** Planet with orbit rings and a swipeable game card, echoing the app's swipe-to-discover flow. */
@Composable
private fun Planet23Visual(lift: Float, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Canvas(Modifier.fillMaxSize()) {
            val c = center
            val r = size.height * 0.36f
            drawCircle(p23_teal, radius = r * 1.5f, center = c)
            drawCircle(p23_cream.copy(alpha = 0.18f), radius = r * 1.3f, center = c, style = Stroke(2f))
            drawCircle(p23_cream.copy(alpha = 0.12f), radius = r * 1.5f, center = c, style = Stroke(2f))
            drawCircle(p23_purple, radius = r, center = c)
            drawCircle(p23_pink.copy(alpha = 0.35f), radius = r * 0.35f, center = c + Offset(-r * 0.4f, -r * 0.35f))
            drawCircle(p23_green, radius = r * 0.2f, center = c + Offset(r * 0.45f, r * 0.3f))
            drawCircle(p23_yellow, radius = 8f, center = c + Offset(r * 1.3f, -r * 0.1f))
            drawCircle(p23_cream, radius = 5f, center = c + Offset(-r * 1.3f, r * 0.2f))
        }
        // Back card
        Surface(
            modifier = Modifier.size(width = 75.dp, height = 100.dp)
                .graphicsLayer {
                    rotationZ = -8f - 4f * lift
                    translationX = (-24.dp.toPx()) - 10.dp.toPx() * lift
                    translationY = -4.dp.toPx() * lift
                },
            shape = RoundedCornerShape(12.dp),
            color = p23_pink
        ) {}
        // Front game card
        Surface(
            modifier = Modifier.size(width = 75.dp, height = 100.dp)
                .graphicsLayer {
                    rotationZ = 6f + 4f * lift
                    translationX = 24.dp.toPx() + 10.dp.toPx() * lift
                    translationY = -12.dp.toPx() * lift
                    scaleX = 1f + 0.06f * lift
                    scaleY = 1f + 0.06f * lift
                },
            shape = RoundedCornerShape(12.dp),
            color = p23_cream
        ) {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Box(Modifier.fillMaxWidth().height(50.dp).background(p23_bg, RoundedCornerShape(6.dp)))
                Box(Modifier.fillMaxWidth(0.8f).height(6.dp).background(p23_bg, RoundedCornerShape(50)))
                Box(Modifier.fillMaxWidth(0.5f).height(6.dp).background(p23_zinc, RoundedCornerShape(50)))
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Box(Modifier.size(12.dp).background(p23_red, CircleShape))
                    Box(Modifier.size(12.dp).background(p23_green, CircleShape))
                }
            }
        }
    }
}
