package br.com.wgc.design_system.components.chip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Chip para seleção de numeração e tamanhos de calçados e vestuário (WgcSizeSelectorChip).
 * Comum em fluxos de e-commerce e catálogo de produtos.
 */
@Composable
fun WgcSizeSelectorChip(
    modifier: Modifier = Modifier,
    size: String,
    isSelected: Boolean = false,
    isEnabled: Boolean = true,
    onClick: () -> Unit
) {
    val stateDesc = if (isSelected) "Tamanho $size selecionado" else "Tamanho $size não selecionado"
    val shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm.dp)

    val activeColor = Color(WgcCoreDsColors.trendFashionPink)
    val inactiveBg = Color(WgcCoreDsColors.white)
    val inactiveBorder = Color(WgcCoreDsColors.trendFashionBorderGray)

    val backgroundColor = when {
        !isEnabled -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
        isSelected -> activeColor
        else -> inactiveBg
    }

    val textColor = when {
        !isEnabled -> MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
        isSelected -> Color.White
        else -> Color(WgcCoreDsColors.trendFashionDark)
    }

    val border = if (isSelected || !isEnabled) null else BorderStroke(1.dp, inactiveBorder)

    Surface(
        modifier = modifier
            .semantics(mergeDescendants = true) {
                role = Role.RadioButton
                stateDescription = stateDesc
            }
            .clip(shape)
            .clickable(enabled = isEnabled, onClick = onClick),
        shape = shape,
        color = backgroundColor,
        border = border
    ) {
        Box(
            modifier = Modifier
                .sizeIn(minWidth = 48.dp, minHeight = 36.dp)
                .padding(horizontal = WgcCoreDsSpacing.sm.dp, vertical = WgcCoreDsSpacing.xs.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = size,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                ),
                color = textColor
            )
        }
    }
}

@Preview(name = "Size Selector States", showBackground = true)
@Composable
private fun WgcSizeSelectorChipPreview() {
    Row(
        modifier = Modifier.padding(WgcCoreDsSpacing.md.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WgcSizeSelectorChip(
            size = "6 UK",
            isSelected = false,
            onClick = {}
        )
        Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xs.dp))
        WgcSizeSelectorChip(
            size = "7 UK",
            isSelected = true,
            onClick = {}
        )
        Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.xs.dp))
        WgcSizeSelectorChip(
            size = "8 UK",
            isEnabled = false,
            onClick = {}
        )
    }
}
