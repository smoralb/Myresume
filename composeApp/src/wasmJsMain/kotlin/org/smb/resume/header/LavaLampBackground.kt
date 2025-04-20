package org.smb.resume.header

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.smb.resume.ui.theme.color_blue_light
import org.smb.resume.ui.theme.color_green_light
import org.smb.resume.ui.theme.color_orange_strong
import org.smb.resume.ui.theme.color_violet_light
import kotlin.random.Random

@Composable
fun LavaLampBackground(modifier: Modifier = Modifier) {
    // Configuración de blobs
    val blobCount = 5

    val animatedBlobs = remember(blobCount) {
        List(blobCount) {
            LavaBlobState()
        }
    }

    // Iniciar animaciones
    animatedBlobs.forEach { blob ->
        blob.Animate()
    }

    Canvas(modifier = modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        animatedBlobs.forEach { blob ->
            drawCircle(
                color = blob.color.copy(alpha = 0.7f),
                radius = blob.radius * canvasWidth,
                center = Offset(
                    blob.x.value * canvasWidth,
                    blob.y.value * canvasHeight
                )
            )
        }
    }
}

// Clase para definir un blob animado
@Stable
class LavaBlobState {
    val x = Animatable(Random.nextFloat())
    val y = Animatable(Random.nextFloat())
    val radius = 0.1f + Random.nextFloat() * 0.1f // tamaño relativo
    private val colorList = listOf(color_blue_light, color_green_light, color_violet_light, color_orange_strong)
    val color = colorList.random()

    @Composable
    fun Animate() {
        LaunchedEffect(Unit) {
            while (true) {
                val targetX = Random.nextFloat()
                val targetY = Random.nextFloat()
                val duration = 4000 + (Random.nextFloat() * 4000).toInt()

                launch {
                    x.animateTo(
                        targetX,
                        animationSpec = tween(durationMillis = duration, easing = LinearEasing)
                    )
                }
                launch {
                    y.animateTo(
                        targetY,
                        animationSpec = tween(durationMillis = duration, easing = LinearEasing)
                    )
                }

                delay(duration.toLong())
            }
        }
    }
}
