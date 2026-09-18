package br.com.wgc.design_system.components.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.components.fields.SearchTextField

/**
 * Cabeçalho de Marketplace com Busca, Localização e Ações Rápidas (WgcMarketplaceSearchHeaderBar).
 */
@Composable
fun WgcMarketplaceSearchHeaderBar(
    modifier: Modifier = Modifier,
    address: String = "Enviar para Cliente - Av. Central, 1000",
    searchQuery: String = "",
    searchPlaceholder: String = "Buscar produtos, marcas e mais...",
    headerColor: Color = Color(WgcCoreDsColors.marketplaceYellow),
    onAddressClick: () -> Unit = {},
    onSearchQueryChange: (String) -> Unit = {},
    onCartClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = headerColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    SearchTextField(
                        value = searchQuery,
                        onValueChange = onSearchQueryChange,
                        label = searchPlaceholder,
                        leadingIcon = Icons.Default.Search
                    )
                }

                IconButton(onClick = onNotificationClick) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notificações",
                        tint = Color(WgcCoreDsColors.grey900)
                    )
                }

                IconButton(onClick = onCartClick) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Carrinho",
                        tint = Color(WgcCoreDsColors.grey900)
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onAddressClick)
                    .padding(bottom = WgcCoreDsSpacing.xxs4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = Color(WgcCoreDsColors.grey900)
                )
                Text(
                    text = address,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.grey900),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcMarketplaceSearchHeaderBarPreview() {
    MaterialTheme {
        WgcMarketplaceSearchHeaderBar(
            address = "Enviar para Gabriel - São Paulo, SP",
            searchQuery = "",
            onAddressClick = {},
            onSearchQueryChange = {},
            onCartClick = {},
            onNotificationClick = {}
        )
    }
}
