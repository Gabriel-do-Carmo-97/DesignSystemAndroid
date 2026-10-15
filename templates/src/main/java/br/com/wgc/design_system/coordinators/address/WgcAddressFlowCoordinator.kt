package br.com.wgc.design_system.coordinators.address

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.address.WgcAddressRegistrationFactory
import br.com.wgc.design_system.factories.address.WgcAddressSelectionFactory
import br.com.wgc.design_system.factories.address.WgcSavedAddressItem
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Coordenador do Fluxo de Endereços (WgcAddressFlowCoordinator).
 */
@Composable
fun WgcAddressFlowCoordinator(
    step: WgcAddressFlowStep = WgcAddressFlowStep.Selection,
    modifier: Modifier = Modifier,
    addresses: List<WgcSavedAddressItem> = emptyList(),
    selectedAddressId: String = "",
    onAddressSelected: (WgcSavedAddressItem) -> Unit = {},
    onAddNewAddress: () -> Unit = {},
    onConfirmAddress: (WgcSavedAddressItem) -> Unit = {},
    onSaveNewAddress: (WgcSavedAddressItem) -> Unit = {},
    selectionScreen: @Composable () -> Unit = {
        if (addresses.isNotEmpty()) {
            WgcAddressSelectionFactory(
                modifier = modifier,
                addresses = addresses,
                selectedAddressId = selectedAddressId,
                onAddressSelected = onAddressSelected,
                onAddNewAddress = onAddNewAddress,
                onConfirmAddress = onConfirmAddress
            )
        } else {
            WgcAddressSelectionFactory(
                modifier = modifier,
                onAddressSelected = onAddressSelected,
                onAddNewAddress = onAddNewAddress,
                onConfirmAddress = onConfirmAddress
            )
        }
    },
    registrationScreen: @Composable () -> Unit = {
        WgcAddressRegistrationFactory(
            modifier = modifier,
            onSaveAddress = onSaveNewAddress
        )
    }
) {
    when (step) {
        WgcAddressFlowStep.Selection -> selectionScreen()
        WgcAddressFlowStep.Registration -> registrationScreen()
    }
}

@Preview(name = "WgcAddressFlowCoordinator - Preview", showBackground = true)
@Composable
private fun WgcAddressFlowCoordinatorPreview() {
    WgcTheme {
        WgcAddressFlowCoordinator()
    }
}
