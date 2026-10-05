package br.com.wgc.design_system.components.picker

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Seletor de cores corporativo para personalização visual dinâmica e whitelabel.
 */
@Suppress("MagicNumber")
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WgcColorPicker(
    selectedColor: Color,
    onColorSelected: (Color) -> Unit,
    modifier: Modifier = Modifier,
    colorsPalette: List<Color> = listOf(
        Color(0xFF1E88E5), // Blue
        Color(0xFF43A047), // Green
        Color(0xFFE53935), // Red
        Color(0xFFFB8C00), // Orange
        Color(0xFF8E24AA), // Purple
        Color(0xFF00ACC1), // Cyan
        Color(0xFF3949AB), // Indigo
        Color(0xFF2E7D32), // Forest
        Color(0xFFF4511E), // Deep Orange
        Color(0xFF263238)  // Dark Slate
    )
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Paleta de Cores",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "#%08X".format(selectedColor.value.toLong()),
                style = MaterialTheme.typography.labelMedium,
                fontFamily = FontFamily.Monospace,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp)
        ) {
            colorsPalette.forEach { color ->
                val isSelected = color == selectedColor

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(color)
                        .border(
                            width = if (isSelected) 3.dp else 1.dp,
                            color = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.outlineVariant,
                            shape = CircleShape
                        )
                        .clickable { onColorSelected(color) },
                    contentAlignment = Alignment.Center
                ) {
                    if (isSelected) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Cor selecionada",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}
