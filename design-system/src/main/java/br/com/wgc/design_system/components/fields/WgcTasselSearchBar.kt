package br.com.wgc.design_system.components.fields

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Campo de busca oficial do ecossistema Tassel (WgcTasselSearchBar).
 * Apresenta input com fundo cinza suave (#F4F4F6), ícone de lupa, placeholder e botão de filtro lateral.
 */
@Composable
fun WgcTasselSearchBar(
    modifier: Modifier = Modifier,
    query: String = "",
    placeholderText: String = "Search on Tassel",
    onQueryChange: (String) -> Unit = {},
    onFilterClick: () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier
                .weight(1f)
                .height(WgcCoreDsSize.s48.dp),
            placeholder = {
                Text(
                    text = placeholderText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.tasselSecondaryText)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color(WgcCoreDsColors.tasselSecondaryText),
                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(WgcCoreDsColors.tasselSurface),
                unfocusedContainerColor = Color(WgcCoreDsColors.tasselSurface),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )

        Box(
            modifier = Modifier
                .size(WgcCoreDsSize.s48.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                .background(Color(WgcCoreDsColors.tasselSurface))
                .clickable(onClick = onFilterClick),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Tune,
                contentDescription = "Filtros",
                tint = Color(WgcCoreDsColors.tasselDark),
                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselSearchBarPreview() {
    WgcTasselSearchBar()
}
