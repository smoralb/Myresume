package org.smb.resume.header

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Path
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.smb.resume.ui.theme.color_orange_strong
import org.smb.resume.ui.theme.color_violet_light
import kotlin.random.Random

@Composable
fun LavaLampBackground(modifier: Modifier = Modifier) {
    val blobs = remember { mutableStateListOf<OrganicLavaBlob>() }
    val repaintTrigger = remember { mutableStateOf(0) }
    val maxBlobs = 15

    LaunchedEffect(Unit) {
        repeat(3) { blobs.add(OrganicLavaBlob()) }

        while (true) {
            delay(3000L)

            if (blobs.size >= maxBlobs) {
                val overflow = blobs.size - maxBlobs + 1
                repeat(overflow) {
                    val dyingBlob = blobs.firstOrNull { !it.isDying }
                    dyingBlob?.isDying = true
                }
            }

            blobs.add(OrganicLavaBlob())
        }
    }

    blobs.forEach { blob ->
        blob.Animate {
            blobs.remove(blob)
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            repaintTrigger.value++
            delay(16L)
        }
    }

    Canvas(modifier = modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        blobs.forEach { blob ->
            val center = Offset(blob.x.value * width, blob.y.value * height)
            val radius = blob.baseRadius * width * blob.scale.value

            val path = createOrganicBlob(
                center = center,
                baseRadius = radius,
                wobbleX = blob.wobbleX.value,
                wobbleY = blob.wobbleY.value
            )

            drawPath(
                path = path,
                brush = Brush.radialGradient(
                    colors = listOf(
                        blob.color.copy(alpha = 0.5f * blob.alpha.value),
                        blob.color.copy(alpha = 0.1f * blob.alpha.value)
                    ),
                    center = center,
                    radius = radius
                )
            )
        }
    }
}

// Blob animado
@Stable
class OrganicLavaBlob {
    // Posiciones iniciales fuera del canvas
    val x = Animatable(startOutsideCanvas())
    val y = Animatable(startOutsideCanvas())
    val baseRadius = 0.08f + Random.nextFloat() * 0.05f
    private val colorList = listOf(color_orange_strong, color_violet_light)
    val color = colorList.random()

    val wobbleX = Animatable(1f)
    val wobbleY = Animatable(1f)
    val scale = Animatable(0.7f) // arranca más pequeño
    val alpha = Animatable(0f)
    var isDying by mutableStateOf(false)

    @Composable
    fun Animate(onFullyDissolved: () -> Unit = {}) {
        LaunchedEffect(Unit) {
            val targetX = Random.nextFloat()
            val targetY = Random.nextFloat()

            launch {
                x.animateTo(targetX, tween(2000, easing = LinearEasing))
            }
            launch {
                y.animateTo(targetY, tween(2000, easing = LinearEasing))
            }
            launch {
                alpha.animateTo(1f, tween(2000, easing = LinearEasing))
            }
            launch {
                scale.animateTo(1f, tween(2000, easing = LinearEasing))
            }
        }

        // Movimiento normal mientras no muere
        LaunchedEffect(Unit) {
            while (!isDying) {
                val targetX = Random.nextFloat()
                val targetY = Random.nextFloat()
                val duration = 5000 + Random.nextInt(4000)

                launch { x.animateTo(targetX, tween(duration, easing = LinearEasing)) }
                launch { y.animateTo(targetY, tween(duration, easing = LinearEasing)) }

                delay(duration.toLong())
            }
        }

        // Deformación
        LaunchedEffect(Unit) {
            while (!isDying) {
                val duration = 2000 + Random.nextInt(2000)
                val newWobbleX = 0.9f + Random.nextFloat() * 0.2f
                val newWobbleY = 0.9f + Random.nextFloat() * 0.2f

                launch { wobbleX.animateTo(newWobbleX, tween(duration, easing = LinearEasing)) }
                launch { wobbleY.animateTo(newWobbleY, tween(duration, easing = LinearEasing)) }

                delay(duration.toLong())
            }
        }

        // Disolución
        LaunchedEffect(isDying) {
            if (isDying) {
                alpha.animateTo(0f, tween(400, easing = LinearEasing))
                onFullyDissolved()
            }
        }
    }
}

fun startOutsideCanvas(): Float {
    return when (Random.nextInt(4)) {
        0 -> -0.2f                  // Izquierda
        1 -> 1.2f                   // Derecha
        2 -> Random.nextFloat()    // Horizontal random (arriba o abajo)
        else -> Random.nextFloat()
    }.let {
        if (Random.nextBoolean()) it else it // podés ajustar más adelante
    }
}


// Forma del blob animado
fun createOrganicBlob(center: Offset, baseRadius: Float, wobbleX: Float, wobbleY: Float): Path {
    val rX = baseRadius * wobbleX
    val rY = baseRadius * wobbleY
    val controlOffsetX = rX * 0.5f
    val controlOffsetY = rY * 0.5f

    return Path().apply {
        moveTo(center.x, center.y - rY)

        cubicTo(
            center.x + controlOffsetX, center.y - rY,
            center.x + rX, center.y - controlOffsetY,
            center.x + rX, center.y
        )

        cubicTo(
            center.x + rX, center.y + controlOffsetY,
            center.x + controlOffsetX, center.y + rY,
            center.x, center.y + rY
        )

        cubicTo(
            center.x - controlOffsetX, center.y + rY,
            center.x - rX, center.y + controlOffsetY,
            center.x - rX, center.y
        )

        cubicTo(
            center.x - rX, center.y - controlOffsetY,
            center.x - controlOffsetX, center.y - rY,
            center.x, center.y - rY
        )

        close()
    }
}
