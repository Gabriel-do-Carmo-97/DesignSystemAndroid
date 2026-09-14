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
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Modalidade imobiliária Viva Real: Comprar, Alugar ou Lançamentos.
 */
enum class WgcVivaRealPurpose {
    Buy,
    Rent,
    NewDevelopments
}

/**
 * Campo de busca e seletor de finalidade no estilo Viva Real (WgcVivaRealSearchBar):
 * - Segmented switcher: Comprar | Alugar | Lançamentos
 * - Input com ícone de busca, placeholder e botão de limpar
 * - Botão lateral de filtros com badge laranja Viva Real
 */
@Composable
fun WgcVivaRealSearchBar(
    modifier: Modifier = Modifier,
    purpose: WgcVivaRealPurpose = WgcVivaRealPurpose.Buy,
    onPurposeChange: (WgcVivaRealPurpose) -> Unit = {},
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    placeholderText: String = "Digite a cidade, bairro ou rua",
    activeFilterCount: Int = 0,
    onFilterClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
    ) {
        // Seletor em Pílula: Comprar / Alugar / Lançamentos
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                .background(Color(WgcCoreDsColors.vivaRealBackground))
                .border(
                    width = WgcCoreDsSpacing.xxxs2.dp,
                    color = Color(WgcCoreDsColors.vivaRealBorder),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                )
                .padding(WgcCoreDsSpacing.xxs4.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            PurposePill(
                label = "Comprar",
                isSelected = purpose == WgcVivaRealPurpose.Buy,
                onClick = { onPurposeChange(WgcVivaRealPurpose.Buy) }
            )
            PurposePill(
                label = "Alugar",
                isSelected = purpose == WgcVivaRealPurpose.Rent,
                onClick = { onPurposeChange(WgcVivaRealPurpose.Rent) }
            )
            PurposePill(
                label = "Lançamentos",
                isSelected = purpose == WgcVivaRealPurpose.NewDevelopments,
                onClick = { onPurposeChange(WgcVivaRealPurpose.NewDevelopments) }
            )
        }

        // Barra de input e botão de filtro lateral
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier
                    .weight(1f)
                    .height(WgcCoreDsSize.s52.dp),
                placeholder = {
                    Text(
                        text = placeholderText,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(WgcCoreDsColors.vivaRealSecondaryText)
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar",
                        tint = Color(WgcCoreDsColors.vivaRealPrimary),
                        modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                    )
                },
                trailingIcon = {
                    if (query.isNotEmpty()) {
                        IconButton(onClick = { onQueryChange("") }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Limpar busca",
                                tint = Color(WgcCoreDsColors.vivaRealSecondaryText),
                                modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                            )
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(WgcCoreDsColors.vivaRealPrimary),
                    unfocusedBorderColor = Color(WgcCoreDsColors.vivaRealBorder),
                    focusedContainerColor = Color(WgcCoreDsColors.vivaRealSurface),
                    unfocusedContainerColor = Color(WgcCoreDsColors.vivaRealSurface),
                    cursorColor = Color(WgcCoreDsColors.vivaRealPrimary)
                )
            )

            // Botão de Filtro com destaque Viva Real
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s52.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                    .background(Color(WgcCoreDsColors.vivaRealPrimary))
                    .clickable(onClick = onFilterClick),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Tune,
                    contentDescription = "Filtros avançados",
                    tint = Color.White,
                    modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                )

                if (activeFilterCount > 0) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(WgcCoreDsSpacing.xxs4.dp)
                            .size(WgcCoreDsSize.s18.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.vivaRealOrange)),
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
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
            .background(
                if (isSelected) Color(WgcCoreDsColors.vivaRealPrimary) else Color.Transparent
            )
            .clickable(onClick = onClick)
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.xs8.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) Color.White else Color(WgcCoreDsColors.vivaRealSecondaryText)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcVivaRealSearchBarPreview() {
    WgcVivaRealSearchBar(
        purpose = WgcVivaRealPurpose.Buy,
        query = "Moema, São Paulo",
        activeFilterCount = 3
    )
}
