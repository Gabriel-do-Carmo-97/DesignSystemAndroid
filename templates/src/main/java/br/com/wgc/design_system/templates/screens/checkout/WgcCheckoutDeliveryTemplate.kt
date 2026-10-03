@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.templates.screens.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Estado da tela de checkout de entrega e pagamento.
 */
data class WgcCheckoutDeliveryUiState(
    val deliveryAddress: String = "Av. Paulista, 1000 - Bela Vista, São Paulo - SP",
    val deliveryMethod: String = "Entrega Expressa (Até 2 horas)",
    val deliveryCostFormatted: String = "R$ 9,90",
    val paymentMethod: String = "Cartão de Crédito final •••• 4242",
    val itemsSubtotalFormatted: String = "R$ 189,90",
    val totalAmountFormatted: String = "R$ 199,80"
)

/**
 * Template corporativo de checkout com endereço, entrega e método de pagamento.
 */
@Composable
fun WgcCheckoutDeliveryTemplate(
    uiState: WgcCheckoutDeliveryUiState,
    onChangeAddress: () -> Unit,
    onChangePayment: () -> Unit,
    onConfirmOrder: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            Text(
                text = "Finalizar Pedido",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Seção Endereço
            CheckoutCard(
                title = "Endereço de Entrega",
                description = uiState.deliveryAddress,
                actionLabel = "Alterar",
                onActionClick = onChangeAddress
            )

            // Seção Método de Entrega
            CheckoutCard(
                title = "Modalidade de Envio",
                description = "${uiState.deliveryMethod} - ${uiState.deliveryCostFormatted}",
                actionLabel = null,
                onActionClick = null
            )

            // Seção Pagamento
            CheckoutCard(
                title = "Forma de Pagamento",
                description = uiState.paymentMethod,
                actionLabel = "Trocar",
                onActionClick = onChangePayment
            )

            // Resumo Financeiro
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            ) {
                Column(
                    modifier = Modifier.padding(WgcCoreDsSpacing.md.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs.dp)
                ) {
                    Text(
                        text = "Resumo dos Valores",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Subtotal dos itens", style = MaterialTheme.typography.bodyMedium)
                        Text(text = uiState.itemsSubtotalFormatted, style = MaterialTheme.typography.bodyMedium)
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Taxa de entrega", style = MaterialTheme.typography.bodyMedium)
                        Text(text = uiState.deliveryCostFormatted, style = MaterialTheme.typography.bodyMedium)
                    }
                    HorizontalDivider(modifier = Modifier.padding(vertical = WgcCoreDsSpacing.xxs.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Total a pagar",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = uiState.totalAmountFormatted,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            WgcClassicButton(
                text = "Confirmar e Pagar",
                onClick = onConfirmOrder,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun CheckoutCard(
    title: String,
    description: String,
    actionLabel: String?,
    onActionClick: (() -> Unit)?
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            if (actionLabel != null && onActionClick != null) {
                WgcClassicButton(
                    text = actionLabel,
                    onClick = onActionClick
                )
            }
        }
    }
}
