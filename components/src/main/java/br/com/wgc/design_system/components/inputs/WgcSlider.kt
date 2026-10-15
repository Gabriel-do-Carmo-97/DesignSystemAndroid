package br.com.wgc.design_system.components.inputs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.theme.WgcTheme

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

@Preview(showBackground = true, name = "WgcSlider Preview")
@Composable
private fun WgcSliderPreview() {
    WgcTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WgcSlider(
                value = 0.5f,
                onValueChange = {}
            )
            WgcSlider(
                value = 0.2f,
                onValueChange = {},
                isEnabled = false
            )
        }
    }
}
