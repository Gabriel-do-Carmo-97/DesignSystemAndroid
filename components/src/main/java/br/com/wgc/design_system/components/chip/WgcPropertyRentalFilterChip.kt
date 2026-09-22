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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Chip de Filtro rápido no estilo Property Rental (WgcPropertyRentalFilterChip):
 * - Estado ativo: Fundo azul marinho escuro (#1C2A44), texto branco e ícone de fechar opcional
 * - Estado inativo: Fundo branco/superfície, borda suave (#E2E8F0), texto escuro e ícone temático
 * - Suporta ícone inicial temático (ex: Pet, Metrô, Cama, etc.)
 */
@Composable
fun WgcPropertyRentalFilterChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    badgeValue: String? = null
) {
    val stateDesc = if (isSelected) "Filtro ativo: $label" else "Filtro inativo: $label"

    val backgroundColor = if (isSelected) {
        Color(WgcCoreDsColors.propertyRentalPrimary)
    } else {
        Color(WgcCoreDsColors.propertyRentalSurface)
    }

    val contentColor = if (isSelected) {
        Color.White
    } else {
        Color(WgcCoreDsColors.propertyRentalDark)
    }

    val borderColor = if (isSelected) {
        Color(WgcCoreDsColors.propertyRentalPrimary)
    } else {
        Color(WgcCoreDsColors.propertyRentalBorder)
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
                    tint = if (isSelected) Color(WgcCoreDsColors.propertyRentalYellow) else contentColor,
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
                    color = if (isSelected) Color(WgcCoreDsColors.propertyRentalYellow) else Color(WgcCoreDsColors.propertyRentalSecondaryText)
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
private fun WgcPropertyRentalFilterChipPreview() {
    Row(
        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        WgcPropertyRentalFilterChip(
            label = "Preço",
            isSelected = false,
            onClick = {}
        )
        WgcPropertyRentalFilterChip(
            label = "2+ quartos",
            isSelected = true,
            onClick = {}
        )
        WgcPropertyRentalFilterChip(
            label = "Aceita pet",
            isSelected = false,
            onClick = {}
        )
    }
}
