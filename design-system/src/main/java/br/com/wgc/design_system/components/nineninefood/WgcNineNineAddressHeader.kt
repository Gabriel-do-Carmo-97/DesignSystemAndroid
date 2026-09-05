package br.com.wgc.design_system.components.nineninefood

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
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
 * Cabeçalho de Endereço e Pesquisa da 99Food na cor Azul Escuro (#0B2545) - WgcNineNineAddressHeader.
 */
@Composable
fun WgcNineNineAddressHeader(
    modifier: Modifier = Modifier,
    address: String = "Av. Paulista, 1000",
    searchQuery: String = "",
    onAddressClick: () -> Unit = {},
    onSearchQueryChange: (String) -> Unit = {},
    onNotificationClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color(0xFF0B2545)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable(onClick = onAddressClick)
                ) {
                    Text(
                        text = "99Food • $address",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Selecionar endereço",
                        tint = Color.White
                    )
                }

                IconButton(onClick = onNotificationClick) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notificações",
                        tint = Color.White
                    )
                }
            }

            SearchTextField(
                value = searchQuery,
                onValueChange = onSearchQueryChange,
                label = "Pratos, restaurantes ou mercados 99Food",
                leadingIcon = Icons.Default.Search
            )
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcNineNineAddressHeaderPreview() {
    MaterialTheme {
        WgcNineNineAddressHeader(address = "Av. Faria Lima, 2000 - São Paulo, SP")
    }
}
