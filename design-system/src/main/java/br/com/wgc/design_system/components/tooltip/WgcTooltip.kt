package br.com.wgc.design_system.components.tooltip

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Componente de Tooltip do Design System (WgcTooltip) baseado no Material 3.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcTooltip(
    modifier: Modifier = Modifier,
    text: String,
    content: @Composable () -> Unit
) {
    @Suppress("DEPRECATION")
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = {
            PlainTooltip {
                Text(text = text)
            }
        },
        state = rememberTooltipState(),
        modifier = modifier
    ) {
        content()
    }
}
