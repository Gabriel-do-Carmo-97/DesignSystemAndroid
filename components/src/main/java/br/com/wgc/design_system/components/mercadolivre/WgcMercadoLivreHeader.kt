package br.com.wgc.design_system.components.mercadolivre

import androidx.compose.foundation.background
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
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.components.fields.SearchTextField

/**
 * Cabeçalho Amarelo Oficial do Mercado Livre (#FFE600) com Busca e Barra de Endereço (WgcMercadoLivreHeader).
 */
@Composable
fun WgcMercadoLivreHeader(
    modifier: Modifier = Modifier,
    address: String = "Enviar para Gabriel - Rua Augusta 1000",
    searchQuery: String = "",
    onAddressClick: () -> Unit = {},
    onSearchQueryChange: (String) -> Unit = {},
    onCartClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color(0xFFFFE600)
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
                        label = "Buscar no Mercado Livre",
                        leadingIcon = Icons.Default.Search
                    )
                }

                IconButton(onClick = onNotificationClick) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notificações",
                        tint = Color(0xFF3E3E3E)
                    )
                }

                IconButton(onClick = onCartClick) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Carrinho",
                        tint = Color(0xFF3E3E3E)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onAddressClick)
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    tint = Color(0xFF3E3E3E),
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = address,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF3E3E3E),
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcMercadoLivreHeaderPreview() {
    MaterialTheme {
        WgcMercadoLivreHeader()
    }
}
