package br.com.wgc.design_system.components.inputs

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Componente de Slider (WgcSlider) baseado no Material 3.
 */
@Composable
fun WgcSlider(
    modifier: Modifier = Modifier,
    value: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    isEnabled: Boolean = true
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        enabled = isEnabled,
        valueRange = valueRange,
        modifier = modifier
    )
}
