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
import br.com.wgc.design_system.factories.payment.templates.FakeCardManagementViewModel
import br.com.wgc.design_system.factories.payment.templates.WgcCardManagementTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Cartão (WgcCardScreenFactory).
 */
@Composable
fun WgcCardScreenFactory(
    modifier: Modifier = Modifier,
    customFormSlot: (@Composable () -> Unit)? = null,
    onPaymentSuccess: () -> Unit = {}
) {
    if (customFormSlot != null) {
        Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                Text("Dados do Cartão")
                customFormSlot()
                WgcButton(
                    text = "Pagar com Cartão",
                    onClick = onPaymentSuccess,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    } else {
        WgcCardManagementTemplate(
            modifier = modifier,
            viewModel = FakeCardManagementViewModel()
        )
    }
}

@Preview(name = "WgcCardScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcCardScreenFactoryPreview() {
    WgcTheme {
        WgcCardScreenFactory()
    }
}
