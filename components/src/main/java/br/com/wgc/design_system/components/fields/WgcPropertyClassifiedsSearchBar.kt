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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

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
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.LG12.dp))
                .background(Color(WgcCoreDsColors.white))
                .border(
                    width = WgcCoreDsSpacing.XXXS2.dp,
                    color = Color(WgcCoreDsColors.blueLight8),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.LG12.dp)
                )
                .padding(
                    horizontal = WgcCoreDsSpacing.SM12.dp,
                    vertical = WgcCoreDsSpacing.XS8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Buscar imóveis",
                tint = Color(WgcCoreDsColors.blueDark31),
                modifier = Modifier.size(WgcCoreDsSize.S20.dp)
            )

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XS8.dp))

            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier.weight(1f),
                textStyle = TextStyle(
                    color = Color(WgcCoreDsColors.blueDark10),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Medium
                ),
                cursorBrush = SolidColor(Color(WgcCoreDsColors.blueDark31)),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) {
                        Text(
                            text = placeholderText,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(WgcCoreDsColors.blue22)
                        )
                    }
                    innerTextField()
                }
            )

            if (query.isNotEmpty()) {
                IconButton(
                    onClick = onClearQuery,
                    modifier = Modifier.size(WgcCoreDsSize.S24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Limpar busca",
                        tint = Color(WgcCoreDsColors.blue22),
                        modifier = Modifier.size(WgcCoreDsSize.S16.dp)
                    )
                }
                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXS4.dp))
            }

            // Botão de Filtros com Badge
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                    .background(Color(WgcCoreDsColors.blueLight12))
                    .clickable(onClick = onFilterClick)
                    .padding(WgcCoreDsSpacing.XS8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Tune,
                        contentDescription = "Abrir filtros",
                        tint = Color(WgcCoreDsColors.blueDark31),
                        modifier = Modifier.size(WgcCoreDsSize.S18.dp)
                    )

                    if (activeFiltersCount > 0) {
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.XXS4.dp))
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.S18.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.orange17)),
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

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.XS8.dp))

        // Seletor de Raio Geográfico em Pílulas
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.XS8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.NearMe,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.blue17),
                modifier = Modifier.size(WgcCoreDsSize.S14.dp)
            )
            Text(
                text = "Raio:",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.blue22)
            )

            WgcZapSearchRadius.entries.forEach { radius ->
                val isSelected = selectedRadius == radius
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp))
                        .background(
                            if (isSelected) {
                                Color(WgcCoreDsColors.blueDark31)
                            } else {
                                Color(WgcCoreDsColors.blueLight37)
                            }
                        )
                        .border(
                            width = WgcCoreDsSpacing.XXXS2.dp,
                            color = if (isSelected) {
                                Color(WgcCoreDsColors.blueDark31)
                            } else {
                                Color(WgcCoreDsColors.blueLight8)
                            },
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp)
                        )
                        .clickable { onRadiusSelect(radius) }
                        .padding(
                            horizontal = WgcCoreDsSpacing.XS8.dp,
                            vertical = WgcCoreDsSpacing.XXS4.dp
                        )
                ) {
                    Text(
                        text = radius.label,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) Color.White else Color(WgcCoreDsColors.blue22)
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
        Box(modifier = Modifier.padding(WgcCoreDsSpacing.MD16.dp)) {
            WgcPropertyClassifiedsSearchBar(
                query = "Pinheiros, São Paulo",
                onQueryChange = {},
                activeFiltersCount = 3
            )
        }
    }
}
