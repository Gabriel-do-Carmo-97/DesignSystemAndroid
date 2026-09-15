package br.com.wgc.design_system.components.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Chip de Filtro no estilo Viva Real (WgcVivaRealFilterChip):
 * - Estado ativo: Fundo verde oficial (#1C9963), texto branco e botão de desmarcar
 * - Estado inativo: Fundo branco/superfície, borda suave (#E2E8F0) e texto escuro
 */
@Composable
fun WgcVivaRealFilterChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    badgeValue: String? = null
) {
    val stateDesc = if (isSelected) "Filtro ativo: $label" else "Filtro inativo: $label"

    val backgroundColor = if (isSelected) {
        Color(WgcCoreDsColors.vivaRealPrimary)
    } else {
        Color(WgcCoreDsColors.vivaRealSurface)
    }

    val contentColor = if (isSelected) {
        Color.White
    } else {
        Color(WgcCoreDsColors.vivaRealDark)
    }

    val borderColor = if (isSelected) {
        Color(WgcCoreDsColors.vivaRealPrimary)
    } else {
        Color(WgcCoreDsColors.vivaRealBorder)
    }

    Box(
        modifier = modifier
            .semantics {
                role = Role.Checkbox
                stateDescription = stateDesc
            }
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
            .background(backgroundColor)
            .border(
                width = WgcCoreDsSpacing.xxxs2.dp,
                color = borderColor,
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
            )
            .clickable(onClick = onClick)
            .padding(
                horizontal = WgcCoreDsSpacing.sm12.dp,
                vertical = WgcCoreDsSpacing.xs8.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                )
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
            }

            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = contentColor
            )

            if (badgeValue != null) {
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                Text(
                    text = "($badgeValue)",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = if (isSelected) Color(WgcCoreDsColors.vivaRealOrangeLight) else Color(WgcCoreDsColors.vivaRealSecondaryText)
                )
            }

            if (isSelected) {
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Remover filtro",
                    tint = Color.White,
                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcVivaRealFilterChipPreview() {
    Row(
        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        WgcVivaRealFilterChip(
            label = "Apartamento",
            isSelected = true,
            onClick = {}
        )
        WgcVivaRealFilterChip(
            label = "Casa",
            isSelected = false,
            onClick = {}
        )
        WgcVivaRealFilterChip(
            label = "Com Tour Virtual",
            isSelected = false,
            onClick = {}
        )
    }
}
