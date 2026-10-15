package br.com.wgc.design_system.factories.payment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Seleção de Método de Pagamento (WgcPaymentMethodSelectionFactory).
 */
@Composable
fun WgcPaymentMethodSelectionFactory(
    modifier: Modifier = Modifier,
    selectedMethod: WgcPaymentMethodVariant = WgcPaymentMethodVariant.CREDIT_CARD,
    onMethodSelected: (WgcPaymentMethodVariant) -> Unit = {},
    customOptionsSlot: (@Composable () -> Unit)? = null,
    onContinue: () -> Unit = {}
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Text("Selecione a Forma de Pagamento")

            if (customOptionsSlot != null) {
                customOptionsSlot()
            } else {
                DefaultPaymentMethodOptions(
                    selected = selectedMethod,
                    onSelected = onMethodSelected
                )
            }

            WgcButton(
                text = "Prosseguir com Pagamento",
                onClick = onContinue,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun DefaultPaymentMethodOptions(
    selected: WgcPaymentMethodVariant,
    onSelected: (WgcPaymentMethodVariant) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
        PaymentOptionCard(
            title = "Cartão de Crédito",
            selected = selected == WgcPaymentMethodVariant.CREDIT_CARD,
            onClick = { onSelected(WgcPaymentMethodVariant.CREDIT_CARD) }
        )
        PaymentOptionCard(
            title = "Pix (Aprovação imediata)",
            selected = selected == WgcPaymentMethodVariant.PIX,
            onClick = { onSelected(WgcPaymentMethodVariant.PIX) }
        )
        PaymentOptionCard(
            title = "Boleto Bancário",
            selected = selected == WgcPaymentMethodVariant.BOLETO,
            onClick = { onSelected(WgcPaymentMethodVariant.BOLETO) }
        )
    }
}

@Composable
private fun PaymentOptionCard(
    title: String,
    selected: Boolean,
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
            RadioButton(selected = selected, onClick = onClick)
            Text(text = title, modifier = Modifier.padding(start = WgcCoreDsSpacing.xs8.dp))
        }
    }
}

@Preview(name = "WgcPaymentMethodSelectionFactory - Preview", showBackground = true)
@Composable
private fun WgcPaymentMethodSelectionFactoryPreview() {
    WgcTheme {
        WgcPaymentMethodSelectionFactory()
    }
}
