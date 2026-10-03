@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system_wgc.showcase

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * LiveTokenEditor
 *
 * Painel interativo para ajuste dinâmico em tempo real de tokens de espaçamento e raios de borda.
 */
@Composable
fun LiveTokenEditor(
    spacingScale: Float,
    onSpacingScaleChange: (Float) -> Unit,
    radiusScale: Float,
    onRadiusScaleChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
        ) {
            Text(
                text = "⚡ Editor Dinâmico de Tokens em Tempo Real",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Controle de Espaçamento
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Escala de Espaçamento", style = MaterialTheme.typography.bodySmall)
                    Text(text = "${(spacingScale * 100).toInt()}%", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
                }
                Slider(
                    value = spacingScale,
                    onValueChange = onSpacingScaleChange,
                    valueRange = 0.5f..2.0f
                )
            }

            // Controle de Borda
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Multiplicador de Raio de Borda", style = MaterialTheme.typography.bodySmall)
                    Text(text = "${(radiusScale * 100).toInt()}%", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
                }
                Slider(
                    value = radiusScale,
                    onValueChange = onRadiusScaleChange,
                    valueRange = 0.0f..3.0f
                )
            }
        }
    }
}
