package br.com.wgc.design_system.components.previews

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Overlay de inspeção de layout ("Inspect Mode") para depuração visual no Showcase.
 */
@Composable
fun WgcInspectOverlay(
    tokenLabel: String,
    isEnabled: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    if (!isEnabled) {
        content()
        return
    }

    Box(
        modifier = modifier.border(width = 1.dp, color = Color(0xFFFF5722))
    ) {
        content()
        Text(
            text = tokenLabel,
            style = MaterialTheme.typography.labelSmall,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(WgcCoreDsSpacing.xxs4.dp)
        )
    }
}
