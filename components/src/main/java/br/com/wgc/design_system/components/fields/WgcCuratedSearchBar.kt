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
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Campo de busca oficial do ecossistema Tassel (WgcCuratedSearchBar).
 * Apresenta input com fundo cinza suave (#F4F4F6), ícone de lupa, placeholder e botão de filtro lateral.
 */
@Composable
fun WgcCuratedSearchBar(
    modifier: Modifier = Modifier,
    query: String = "",
    placeholderText: String = "Search on Tassel",
    onQueryChange: (String) -> Unit = {},
    onFilterClick: () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.SM12.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier
                .weight(1f)
                .height(WgcCoreDsSize.S48.dp),
            placeholder = {
                Text(
                    text = placeholderText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.gray10)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    tint = Color(WgcCoreDsColors.gray10),
                    modifier = Modifier.size(WgcCoreDsSize.S20.dp)
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(WgcCoreDsColors.blueLight26),
                unfocusedContainerColor = Color(WgcCoreDsColors.blueLight26),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )

        Box(
            modifier = Modifier
                .size(WgcCoreDsSize.S48.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp))
                .background(Color(WgcCoreDsColors.blueLight26))
                .clickable(onClick = onFilterClick),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Tune,
                contentDescription = "Filtros",
                tint = Color(WgcCoreDsColors.grayDark9),
                modifier = Modifier.size(WgcCoreDsSize.S20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselSearchBarPreview() {
    WgcCuratedSearchBar()
}
