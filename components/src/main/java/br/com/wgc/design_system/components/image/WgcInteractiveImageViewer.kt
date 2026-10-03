package br.com.wgc.design_system.components.image

import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput

/**
 * Visualizador interativo de imagens com suporte a gestos de zoom (pinch-to-zoom) e pan.
 *
 * @param modifier Modificador de layout.
 * @param minScale Escala mínima permitida (padrão: 1.0f).
 * @param maxScale Escala máxima de ampliação (padrão: 4.0f).
 * @param content Conteúdo visual a ser ampliado (ex: AsyncImage, Image).
 */
@Composable
fun WgcInteractiveImageViewer(
    modifier: Modifier = Modifier,
    minScale: Float = 1.0f,
    maxScale: Float = 4.0f,
    content: @Composable () -> Unit
) {
    var scale by remember { mutableFloatStateOf(1f) }
    var offset by remember { mutableStateOf(Offset.Zero) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    scale = (scale * zoom).coerceIn(minScale, maxScale)
                    if (scale > 1f) {
                        offset += pan
                    } else {
                        offset = Offset.Zero
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                translationX = offset.x,
                translationY = offset.y
            )
        ) {
            content()
        }
    }
}
