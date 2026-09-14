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
 * Modalidade imobiliária QuintoAndar: Alugar ou Comprar.
 */
enum class WgcQuintoAndarContractType {
    Rent,
    Buy
}

/**
 * Campo de busca e seletor de modalidade no estilo QuintoAndar (WgcQuintoAndarSearchBar):
 * - Seletor segmented pill para "Alugar" e "Comprar"
 * - Barra de pesquisa com ícone de localização/lupa e ação de limpar
 * - Botão lateral de filtros com badge de contagem
 */
@Composable
fun WgcQuintoAndarSearchBar(
    modifier: Modifier = Modifier,
    contractType: WgcQuintoAndarContractType = WgcQuintoAndarContractType.Rent,
    onContractTypeChange: (WgcQuintoAndarContractType) -> Unit = {},
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    placeholderText: String = "Onde você quer morar?",
    activeFilterCount: Int = 0,
    onFilterClick: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
    ) {
        // Seletor de Modalidade: Alugar / Comprar
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                .background(Color(WgcCoreDsColors.quintoAndarBackground))
                .border(
                    width = WgcCoreDsSpacing.xxxs2.dp,
                    color = Color(WgcCoreDsColors.quintoAndarBorder),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                )
                .padding(WgcCoreDsSpacing.xxs4.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            val isRent = contractType == WgcQuintoAndarContractType.Rent
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                    .background(
                        if (isRent) Color(WgcCoreDsColors.quintoAndarPrimary) else Color.Transparent
                    )
                    .clickable { onContractTypeChange(WgcQuintoAndarContractType.Rent) }
                    .padding(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.xs8.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Alugar",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = if (isRent) Color.White else Color(WgcCoreDsColors.quintoAndarSecondaryText)
                )
            }

            val isBuy = contractType == WgcQuintoAndarContractType.Buy
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                    .background(
                        if (isBuy) Color(WgcCoreDsColors.quintoAndarPrimary) else Color.Transparent
                    )
                    .clickable { onContractTypeChange(WgcQuintoAndarContractType.Buy) }
                    .padding(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.xs8.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Comprar",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = if (isBuy) Color.White else Color(WgcCoreDsColors.quintoAndarSecondaryText)
                )
            }
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
                        color = Color(WgcCoreDsColors.quintoAndarSecondaryText)
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Buscar imóveis",
                        tint = Color(WgcCoreDsColors.quintoAndarPrimary),
                        modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                    )
                },
                trailingIcon = {
                    if (query.isNotEmpty()) {
                        IconButton(onClick = { onQueryChange("") }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Limpar busca",
                                tint = Color(WgcCoreDsColors.quintoAndarSecondaryText),
                                modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                            )
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(WgcCoreDsColors.quintoAndarYellow),
                    unfocusedBorderColor = Color(WgcCoreDsColors.quintoAndarBorder),
                    focusedContainerColor = Color(WgcCoreDsColors.quintoAndarSurface),
                    unfocusedContainerColor = Color(WgcCoreDsColors.quintoAndarSurface),
                    cursorColor = Color(WgcCoreDsColors.quintoAndarPrimary)
                )
            )

            // Botão de Filtro
            Box(
                modifier = Modifier
                    .size(WgcCoreDsSize.s52.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                    .background(Color(WgcCoreDsColors.quintoAndarPrimary))
                    .clickable(onClick = onFilterClick),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Tune,
                    contentDescription = "Filtros avançados",
                    tint = Color(WgcCoreDsColors.quintoAndarYellow),
                    modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                )

                if (activeFilterCount > 0) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(WgcCoreDsSpacing.xxs4.dp)
                            .size(WgcCoreDsSize.s18.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.quintoAndarYellow)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = activeFilterCount.toString(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.quintoAndarPrimary)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcQuintoAndarSearchBarPreview() {
    WgcQuintoAndarSearchBar(
        query = "",
        contractType = WgcQuintoAndarContractType.Rent,
        activeFilterCount = 2
    )
}
