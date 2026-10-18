package br.com.wgc.design_system.commons.shimmer

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import br.com.wgc.design_system.commons.constants.ComponentsConstants

/**
 * Desenha um gradiente animado enquanto o item está carregando.
 *
 * Use no modificador de um placeholder para indicar visualmente uma operação em andamento.
 * Quando [isLoading] é `false`, o modificador não acrescenta desenho. No estado de loading este
 * modificador desenha o gradiente como conteúdo do draw pass, portanto aplique-o ao placeholder
 * cuja superfície deve receber o shimmer.
 *
 * ```kotlin
 * Box(Modifier.size(width, height).shimmerEffect(isLoading = true))
 * ```
 *
 * @param isLoading Se `true`, ativa a animação contínua do gradiente.
 */
fun Modifier.shimmerEffect(
    isLoading: Boolean,
): Modifier = composed {
    if (!isLoading) return@composed this

    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = ComponentsConstants.Shimmer.ALPHA_HIGH),
        Color.LightGray.copy(alpha = ComponentsConstants.Shimmer.ALPHA_LOW),
        Color.LightGray.copy(alpha = ComponentsConstants.Shimmer.ALPHA_HIGH),
    )

    var size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition(label = "ShimmerTransition")

    val startOffsetX by transition.animateFloat(
        initialValue = -ComponentsConstants.Shimmer.OFFSET_MULTIPLIER * size.width.toFloat(),
        targetValue = ComponentsConstants.Shimmer.OFFSET_MULTIPLIER * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = ComponentsConstants.Shimmer.DURATION_MS),
        ),
        label = "ShimmerStartOffsetX",
    )

    onGloballyPositioned { layoutCoordinates ->
        size = layoutCoordinates.size
    }
        .drawWithContent {
            drawRect(
                brush = Brush.linearGradient(
                    colors = shimmerColors,
                    start = Offset(startOffsetX, 0f),
                    end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat()),
                ),
            )
        }
}
