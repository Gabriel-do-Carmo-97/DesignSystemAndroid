package br.com.wgc.design_system_wgc.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Cores de marca suportadas dinamicamente no Showcase para teste de multi-tenancy.
 */
val ShowcaseBrandPalettes = listOf(
    Color(0xFF0D47A1), // WGC Blue Corporativo
    Color(0xFF00796B), // WGC Emerald Green
    Color(0xFF512DA8), // WGC Fintech Purple
    Color(0xFFE65100)  // WGC Marketplace Orange
)

/**
 * Painel interativo para alternância de temas e simulação de multi-tenancy no Showcase.
 *
 * @param isDarkMode Estado atual do tema escuro
 * @param onToggleDarkMode Callback para alternar modo escuro
 * @param selectedColor Cor primária ativa selecionada
 * @param onColorSelect Callback para seleção de nova cor primária
 * @param modifier Modificador de layout
 */
@Composable
fun WgcThemeCustomizerBar(
    isDarkMode: Boolean,
    onToggleDarkMode: (Boolean) -> Unit,
    selectedColor: Color,
    onColorSelect: (Color) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                Icon(
                    imageVector = if (isDarkMode) Icons.Default.DarkMode else Icons.Default.LightMode,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                )
                Text(
                    text = if (isDarkMode) "Dark Mode" else "Light Mode",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium
                )
                Switch(
                    checked = isDarkMode,
                    onCheckedChange = onToggleDarkMode
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                for (color in ShowcaseBrandPalettes) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSpacing.lg24.dp)
                            .clip(CircleShape)
                            .background(color)
                            .clickable { onColorSelect(color) }
                    ) {
                        if (color == selectedColor) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSpacing.xs8.dp)
                                    .clip(CircleShape)
                                    .background(Color.White)
                                    .align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}
