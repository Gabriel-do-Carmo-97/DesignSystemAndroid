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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Raio geográfico de busca do Zap Imóveis.
 */
enum class WgcZapSearchRadius(val label: String) {
    EXACT("Exato"),
    RADIUS_2KM("+2 km"),
    RADIUS_5KM("+5 km"),
    RADIUS_10KM("+10 km")
}

/**
 * Barra de busca com geolocalização e raio geográfico do Zap Imóveis.
 */
@Composable
fun WgcPropertyClassifiedsSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    selectedRadius: WgcZapSearchRadius = WgcZapSearchRadius.RADIUS_5KM,
    onRadiusSelect: (WgcZapSearchRadius) -> Unit = {},
    placeholderText: String = "Bairro, cidade, rua ou condomínio...",
    activeFiltersCount: Int = 0,
    onFilterClick: () -> Unit = {},
    onClearQuery: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Campo Principal de Busca
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                .background(Color(WgcCoreDsColors.propertyClassifiedsSurface))
                .border(
                    width = WgcCoreDsSpacing.xxxs2.dp,
                    color = Color(WgcCoreDsColors.propertyClassifiedsBorder),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp)
                )
                .padding(
                    horizontal = WgcCoreDsSpacing.sm12.dp,
                    vertical = WgcCoreDsSpacing.xs8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Buscar imóveis",
                tint = Color(WgcCoreDsColors.propertyClassifiedsPrimary),
                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
            )

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))

            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(
                    color = Color(WgcCoreDsColors.propertyClassifiedsDark),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Medium
                ),
                cursorBrush = SolidColor(Color(WgcCoreDsColors.propertyClassifiedsPrimary)),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) {
                        Text(
                            text = placeholderText,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                        )
                    }
                    innerTextField()
                }
            )

            if (query.isNotEmpty()) {
                IconButton(
                    onClick = onClearQuery,
                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Limpar busca",
                        tint = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                }
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
            }

            // Botão de Filtros com Badge
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.propertyClassifiedsPrimaryLight))
                    .clickable(onClick = onFilterClick)
                    .padding(WgcCoreDsSpacing.xs8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Tune,
                        contentDescription = "Abrir filtros",
                        tint = Color(WgcCoreDsColors.propertyClassifiedsPrimary),
                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                    )

                    if (activeFiltersCount > 0) {
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s18.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.propertyClassifiedsOrange)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = activeFiltersCount.toString(),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

        // Seletor de Raio Geográfico em Pílulas
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.NearMe,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.propertyClassifiedsBlue),
                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
            )
            Text(
                text = "Raio:",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
            )

            WgcZapSearchRadius.entries.forEach { radius ->
                val isSelected = selectedRadius == radius
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                        .background(
                            if (isSelected) {
                                Color(WgcCoreDsColors.propertyClassifiedsPrimary)
                            } else {
                                Color(WgcCoreDsColors.propertyClassifiedsBackground)
                            }
                        )
                        .border(
                            width = WgcCoreDsSpacing.xxxs2.dp,
                            color = if (isSelected) {
                                Color(WgcCoreDsColors.propertyClassifiedsPrimary)
                            } else {
                                Color(WgcCoreDsColors.propertyClassifiedsBorder)
                            },
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                        )
                        .clickable { onRadiusSelect(radius) }
                        .padding(
                            horizontal = WgcCoreDsSpacing.xs8.dp,
                            vertical = WgcCoreDsSpacing.xxs4.dp
                        )
                ) {
                    Text(
                        text = radius.label,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) Color.White else Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                    )
                }
            }
        }
    }
}

@Preview(name = "WgcPropertyClassifiedsSearchBar - Default", showBackground = true)
@Composable
private fun WgcZapSearchBarPreview() {
    MaterialTheme {
        Box(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            WgcPropertyClassifiedsSearchBar(
                query = "Pinheiros, São Paulo",
                onQueryChange = {},
                activeFiltersCount = 3
            )
        }
    }
}
