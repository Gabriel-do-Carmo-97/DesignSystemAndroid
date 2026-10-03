@file:Suppress("LongMethod", "MagicNumber")

package br.com.wgc.design_system.components.segmented

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * WgcSegmentedControl
 *
 * Alternador em pílula deslizante corporativo com seleção única stateless.
 *
 * @param items Lista de opções textuais.
 * @param selectedIndex Índice atualmente selecionado.
 * @param onItemSelected Callback disparado ao selecionar uma opção.
 * @param modifier Modificador de layout.
 */
@Composable
fun WgcSegmentedControl(
    items: List<String>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.pill.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(WgcCoreDsSpacing.xxs.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            items.forEachIndexed { index, title ->
                val isSelected = index == selectedIndex
                val backgroundColor by animateColorAsState(
                    targetValue = if (isSelected) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.surfaceVariant,
                    label = "segmented_bg"
                )
                val textColor by animateColorAsState(
                    targetValue = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                    label = "segmented_text"
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.pill.dp))
                        .background(backgroundColor)
                        .clickable { onItemSelected(index) }
                        .padding(vertical = WgcCoreDsSpacing.sm.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = textColor,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
