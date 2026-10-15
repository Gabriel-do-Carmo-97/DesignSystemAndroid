package br.com.wgc.design_system.components.tooltip

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.previews.multi.theme.ThemePreviews
import br.com.wgc.design_system.theme.WgcTheme

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

@ThemePreviews
@Composable
private fun WgcTooltipPreview() {
    WgcTheme {
        WgcTooltip(
            modifier = Modifier.padding(16.dp),
            text = "Tooltip explicativo de ajuda ao usuário"
        ) {
            Text(text = "Toque ou passe o mouse aqui para exibir o Tooltip")
        }
    }
}
