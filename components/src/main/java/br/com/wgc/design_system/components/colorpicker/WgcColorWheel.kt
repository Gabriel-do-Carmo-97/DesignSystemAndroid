package br.com.wgc.design_system.components.colorpicker

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin
import kotlin.math.sqrt

/**
 * Roda Cromática interativa construída via Jetpack Compose Canvas.
 * Permite selecionar matiz (Hue) e saturação (Saturation) por arrasto/toque
 * e ajustar luminosidade (Value) através de controle deslizante dedicado.
 */
@Suppress("LongMethod")
@Composable
fun WgcColorWheel(
    hue: Float,
    saturation: Float,
    value: Float,
    onHsvChange: (hue: Float, saturation: Float, value: Float) -> Unit,
    modifier: Modifier = Modifier,
    wheelSize: Dp = 220.dp,
    showBrightnessSlider: Boolean = true
) {
    var currentHue by remember(hue) { mutableFloatStateOf(hue) }
    var currentSaturation by remember(saturation) { mutableFloatStateOf(saturation) }
    var currentValue by remember(value) { mutableFloatStateOf(value) }

    val sweepColors = remember {
        listOf(
            Color.Red,
            Color.Yellow,
            Color.Green,
            Color.Cyan,
            Color.Blue,
            Color.Magenta,
            Color.Red
        )
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
    ) {
        Canvas(
            modifier = Modifier
                .size(wheelSize)
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        val (newH, newS) = calculateHueAndSaturation(offset, size.width.toFloat(), size.height.toFloat())
                        currentHue = newH
                        currentSaturation = newS
                        onHsvChange(newH, newS, currentValue)
                    }
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, _ ->
                        change.consume()
                        val (newH, newS) = calculateHueAndSaturation(change.position, size.width.toFloat(), size.height.toFloat())
                        currentHue = newH
                        currentSaturation = newS
                        onHsvChange(newH, newS, currentValue)
                    }
                }
        ) {
            val center = Offset(size.width / 2f, size.height / 2f)
            val radius = min(size.width, size.height) / 2f

            // 1. Gradiente de matiz (SweepGradient 360°)
            drawCircle(
                brush = Brush.sweepGradient(sweepColors, center),
                radius = radius,
                center = center
            )

            // 2. Gradiente radial para saturação (Branco no centro -> transparente na borda)
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.White.copy(alpha = currentValue), Color.Transparent),
                    center = center,
                    radius = radius
                ),
                radius = radius,
                center = center
            )

            // 3. Sobreposição de valor/luminosidade se menor que 1.0 (escurece até preto)
            if (currentValue < 1f) {
                drawCircle(
                    color = Color.Black.copy(alpha = 1f - currentValue),
                    radius = radius,
                    center = center
                )
            }

            // 4. Borda sutil de acabamento
            drawCircle(
                color = Color.LightGray.copy(alpha = 0.5f),
                radius = radius,
                center = center,
                style = Stroke(width = 2.dp.toPx())
            )

            // 5. Thumb/Indicador da posição selecionada
            val angleRad = Math.toRadians(currentHue.toDouble())
            val thumbDistance = currentSaturation * radius
            val thumbX = (center.x + thumbDistance * cos(angleRad)).toFloat()
            val thumbY = (center.y + thumbDistance * sin(angleRad)).toFloat()
            val thumbPos = Offset(thumbX, thumbY)

            val thumbColor = WgcColorPickerUtils.hsvToColor(currentHue, currentSaturation, currentValue)

            // Sombra do thumb
            drawCircle(
                color = Color.Black.copy(alpha = 0.35f),
                radius = 12.dp.toPx(),
                center = thumbPos
            )
            // Anel externo branco
            drawCircle(
                color = Color.White,
                radius = 10.dp.toPx(),
                center = thumbPos,
                style = Stroke(width = 3.dp.toPx())
            )
            // Preenchimento interno com a cor selecionada
            drawCircle(
                color = thumbColor,
                radius = 7.dp.toPx(),
                center = thumbPos
            )
        }

        if (showBrightnessSlider) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.sm12.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Brilho",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = "${(currentValue * 100).toInt()}%",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Slider(
                    value = currentValue,
                    onValueChange = { newVal ->
                        currentValue = newVal
                        onHsvChange(currentHue, currentSaturation, newVal)
                    },
                    valueRange = 0f..1f,
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.primary,
                        activeTrackColor = MaterialTheme.colorScheme.primary
                    )
                )
            }
        }
    }
}

@Suppress("MagicNumber")
private fun calculateHueAndSaturation(offset: Offset, width: Float, height: Float): Pair<Float, Float> {
    val centerX = width / 2f
    val centerY = height / 2f
    val dx = offset.x - centerX
    val dy = offset.y - centerY
    val maxRadius = min(width, height) / 2f

    val distance = sqrt(dx * dx + dy * dy)
    val saturation = (distance / maxRadius).coerceIn(0f, 1f)

    var angleDeg = Math.toDegrees(atan2(dy.toDouble(), dx.toDouble())).toFloat()
    if (angleDeg < 0f) {
        angleDeg += 360f
    }

    return Pair(angleDeg, saturation)
}
