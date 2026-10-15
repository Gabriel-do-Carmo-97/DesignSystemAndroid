package br.com.wgc.design_system.factories.address

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.buttons.WgcButtonVariant
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Seleção de Endereço (WgcAddressSelectionFactory).
 */
@Composable
fun WgcAddressSelectionFactory(
    modifier: Modifier = Modifier,
    addresses: List<WgcSavedAddressItem> = defaultAddresses(),
    selectedAddressId: String = addresses.firstOrNull()?.id ?: "",
    onAddressSelected: (WgcSavedAddressItem) -> Unit = {},
    onAddNewAddress: () -> Unit = {},
    onConfirmAddress: (WgcSavedAddressItem) -> Unit = {}
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Text("Selecione o Endereço de Entrega")

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                items(addresses) { address ->
                    AddressItemCard(
                        address = address,
                        isSelected = address.id == selectedAddressId,
                        onClick = { onAddressSelected(address) }
                    )
                }
            }

            WgcButton(
                text = "+ Cadastrar Novo Endereço",
                variant = WgcButtonVariant.Outlined,
                onClick = onAddNewAddress,
                modifier = Modifier.fillMaxWidth()
            )

            WgcButton(
                text = "Entregar Neste Endereço",
                onClick = {
                    val selected = addresses.find { it.id == selectedAddressId } ?: addresses.firstOrNull()
                    if (selected != null) onConfirmAddress(selected)
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun AddressItemCard(
    address: WgcSavedAddressItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = isSelected, onClick = onClick)
            Column(modifier = Modifier.padding(start = WgcCoreDsSpacing.xs8.dp)) {
                Text(text = address.title)
                Text(text = "${address.street}, ${address.number} - ${address.city}/${address.state}")
                Text(text = "CEP: ${address.zipCode}")
            }
        }
    }
}

private fun defaultAddresses(): List<WgcSavedAddressItem> = listOf(
    WgcSavedAddressItem(
        id = "1",
        title = "Casa",
        street = "Av. Paulista",
        number = "1000",
        city = "São Paulo",
        state = "SP",
        zipCode = "01310-100",
        isDefault = true
    ),
    WgcSavedAddressItem(
        id = "2",
        title = "Trabalho",
        street = "Faria Lima",
        number = "3500",
        city = "São Paulo",
        state = "SP",
        zipCode = "04538-133",
        isDefault = false
    )
)

@Preview(name = "WgcAddressSelectionFactory - Preview", showBackground = true)
@Composable
private fun WgcAddressSelectionFactoryPreview() {
    WgcTheme {
        WgcAddressSelectionFactory()
    }
}
