package br.com.wgc.design_system.components.ifood

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
 * Cabeçalho de Endereço e Pesquisa oficial do iFood.
 */
@Composable
fun IFoodAddressHeader(
    modifier: Modifier = Modifier,
    address: String = "Rua Augusta, 1000",
    searchQuery: String = "",
    onAddressClick: () -> Unit = {},
    onSearchQueryChange: (String) -> Unit = {},
    onNotificationClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
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
                    text = address,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Selecionar endereço",
                    tint = Color(0xFFEA1D2C)
                )
            }

            IconButton(onClick = onNotificationClick) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notificações",
                    tint = Color(0xFFEA1D2C)
                )
            }
        }

        SearchTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            label = "Item ou restaurante",
            leadingIcon = Icons.Default.Search
        )
    }
}

@WgcComponentPreviews
@Composable
private fun IFoodAddressHeaderPreview() {
    MaterialTheme {
        IFoodAddressHeader(address = "Av. Paulista, 1500 - São Paulo, SP")
    }
}
