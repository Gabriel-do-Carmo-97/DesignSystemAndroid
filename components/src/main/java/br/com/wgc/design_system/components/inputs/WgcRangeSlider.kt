@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.components.inputs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * WgcRangeSlider
 *
 * Slider com dois seletores para faixas de valores (ex: intervalo de preços, idades, distâncias).
 *
 * @param values Faixa de valores selecionada.
 * @param onValuesChange Callback ao mover os cursores.
 * @param valueRange Limites totais permitidos.
 * @param steps Quantidade de divisões discretas (0 para contínuo).
 * @param label Rótulo do campo.
 * @param modifier Modificador de layout.
 */
@Composable
fun WgcRangeSlider(
    values: ClosedFloatingPointRange<Float>,
    onValuesChange: (ClosedFloatingPointRange<Float>) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = 0f..100f,
    steps: Int = 0,
    label: String? = null,
    isEnabled: Boolean = true
) {
    Column(modifier = modifier.fillMaxWidth()) {
        if (label != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "${values.start.toInt()} - ${values.endInclusive.toInt()}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        RangeSlider(
            value = values,
            onValueChange = onValuesChange,
            valueRange = valueRange,
            steps = steps,
            enabled = isEnabled,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
