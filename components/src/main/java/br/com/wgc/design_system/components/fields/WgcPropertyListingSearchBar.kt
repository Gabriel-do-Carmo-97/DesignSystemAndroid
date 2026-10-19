package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Campo de busca e seletor de finalidade no estilo Property Listing (WgcPropertyListingSearchBar):
 * - Segmented switcher: Comprar | Alugar | Lançamentos
 * - Input com ícone de busca, placeholder e botão de limpar
 * - Botão lateral de filtros com badge laranja Property Listing
 */
@Composable
fun WgcPropertyListingSearchBar(
    modifier: Modifier = Modifier,
    purpose: WgcPropertyListingPurpose = WgcPropertyListingPurpose.Buy,
    onPurposeChange: (WgcPropertyListingPurpose) -> Unit = {},
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    placeholderText: String = "Digite a cidade, bairro ou rua",
    activeFilterCount: Int = 0,
    onFilterClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM12.dp)
    ) {
        // Seletor em Pílula: Comprar / Alugar / Lançamentos
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp))
                .background(Color(WgcCoreDsColors.blueLight37))
                .border(
                    width = WgcCoreDsSpacing.XXXS2.dp,
                    color = Color(WgcCoreDsColors.blueLight8),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp)
                )
                .padding(WgcCoreDsSpacing.XXS4.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            PurposePill(
                label = "Comprar",
                isSelected = purpose == WgcPropertyListingPurpose.Buy,
                onClick = { onPurposeChange(WgcPropertyListingPurpose.Buy) }
            )
            PurposePill(
                label = "Alugar",
                isSelected = purpose == WgcPropertyListingPurpose.Rent,
                onClick = { onPurposeChange(WgcPropertyListingPurpose.Rent) }
            )
            PurposePill(
                label = "Lançamentos",
                isSelected = purpose == WgcPropertyListingPurpose.NewDevelopments,
                onClick = { onPurposeChange(WgcPropertyListingPurpose.NewDevelopments) }
            )
        }

        // Barra de input e botão de filtro lateral
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XS8.dp)
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier
                    .weight(1f)
                    .height(WgcCoreDsSize.S52.dp),
                placeholder = {
                    Text(
                        text = placeholderText,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.blue22)
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = Color(WgcCoreDsColors.green14),
                        modifier = Modifier.size(WgcCoreDsSize.S22.dp)
                    )
                },
                trailingIcon = {
                    if (query.isNotEmpty()) {
                        IconButton(onClick = { onQueryChange("") }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Limpar busca",
                                tint = Color(WgcCoreDsColors.blue22),
                                modifier = Modifier.size(WgcCoreDsSize.S18.dp)
                            )
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(WgcCoreDsColors.green14),
                    unfocusedBorderColor = Color(WgcCoreDsColors.blueLight8),
                    focusedContainerColor = Color(WgcCoreDsColors.white),
                    unfocusedContainerColor = Color(WgcCoreDsColors.white),
                    cursorColor = Color(WgcCoreDsColors.green14)
                )
            )

            // Botão de Filtro com destaque Property Listing
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.S52.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp))
                    .background(Color(WgcCoreDsColors.green14))
                    .clickable(onClick = onFilterClick),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Tune,
                    contentDescription = "Filtros avançados",
                    tint = Color.White,
                    modifier = Modifier.size(WgcCoreDsSize.S22.dp)
                )

                if (activeFilterCount > 0) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(WgcCoreDsSpacing.XXS4.dp)
                            .size(WgcCoreDsSize.S18.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.orange18)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = activeFilterCount.toString(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PurposePill(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp))
            .background(
                if (isSelected) Color(WgcCoreDsColors.green14) else Color.Transparent
            )
            .clickable(onClick = onClick)
            .padding(
                horizontal = WgcCoreDsSpacing.MD16.dp,
                vertical = WgcCoreDsSpacing.XS8.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) Color.White else Color(WgcCoreDsColors.blue22)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPropertyListingSearchBarPreview() {
    WgcPropertyListingSearchBar(
        purpose = WgcPropertyListingPurpose.Buy,
        query = "Moema, São Paulo",
        activeFilterCount = 3
    )
}
