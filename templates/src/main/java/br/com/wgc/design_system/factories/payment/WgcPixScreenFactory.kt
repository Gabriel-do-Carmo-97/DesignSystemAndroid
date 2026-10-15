package br.com.wgc.design_system.factories.payment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.factories.payment.templates.FakePixTransferViewModel
import br.com.wgc.design_system.factories.payment.templates.WgcPixQrCodePaymentTemplate
import br.com.wgc.design_system.factories.payment.templates.WgcPixQrPaymentUiState
import br.com.wgc.design_system.factories.payment.templates.WgcPixTransferTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Pix (WgcPixScreenFactory).
 */
@Composable
fun WgcPixScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcPixScreenVariant = WgcPixScreenVariant.STANDARD,
    customQrSlot: (@Composable () -> Unit)? = null,
    onPaymentConfirmed: () -> Unit = {}
) {
    if (customQrSlot != null) {
        Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                Text("Pagamento via PIX Copia e Cola / QR Code")
                customQrSlot()
                WgcButton(
                    text = "Confirmar Pagamento Realizado",
                    onClick = onPaymentConfirmed,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    } else {
        when (variant) {
            WgcPixScreenVariant.QR_CODE_PAYMENT -> WgcPixQrCodePaymentTemplate(
                uiState = WgcPixQrPaymentUiState(),
                onCopyPixCode = {},
                onCheckPaymentStatus = onPaymentConfirmed,
                modifier = modifier
            )
            WgcPixScreenVariant.TRANSFER,
            WgcPixScreenVariant.KEY_REGISTRATION,
            WgcPixScreenVariant.STANDARD -> WgcPixTransferTemplate(
                modifier = modifier,
                viewModel = FakePixTransferViewModel()
            )
        }
    }
}

@Preview(name = "WgcPixScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcPixScreenFactoryPreview() {
    WgcTheme {
        WgcPixScreenFactory()
    }
}
