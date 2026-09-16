package br.com.wgc.ds_navigation_flows.checkout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.ds_templates.screens.cart.FakeStandardCartViewModel
import br.com.wgc.ds_templates.screens.cart.StandardCartScreenContent
import br.com.wgc.ds_templates.screens.cart.StandardCartUiState
import br.com.wgc.ds_templates.screens.receipt.WgcTransactionReceiptContent
import br.com.wgc.ds_templates.screens.receipt.WgcTransactionReceiptUiState
import kotlinx.serialization.Serializable

@Serializable
object WgcCheckoutGraphRoute

@Serializable
object WgcCheckoutCartRoute

@Serializable
object WgcCheckoutAddressRoute

@Serializable
object WgcCheckoutPaymentRoute

@Serializable
data class WgcCheckoutSuccessRoute(val orderId: String = "WGC-982104", val amount: String = "R$ 898,00")

/**
 * Grafo de navegação completo para fluxos de checkout e pagamentos (WgcCheckoutNavGraph).
 *
 * @param navController Controlador de navegação.
 * @param onCheckoutCompleted Callback disparado com o ID do pedido finalizado.
 * @param onCloseCheckout Callback disparado caso o usuário encerre o checkout.
 */
fun NavGraphBuilder.wgcCheckoutNavGraph(
    navController: NavController,
    onCheckoutCompleted: (orderId: String) -> Unit,
    onCloseCheckout: () -> Unit
) {
    navigation<WgcCheckoutGraphRoute>(startDestination = WgcCheckoutCartRoute) {
        composable<WgcCheckoutCartRoute> {
            StandardCartScreenContent(
                state = StandardCartUiState(),
                onCheckoutClick = {
                    navController.navigate(WgcCheckoutAddressRoute)
                }
            )
        }

        composable<WgcCheckoutAddressRoute> {
            WgcCheckoutAddressNavScreen(
                onNavigateBack = { navController.popBackStack() },
                onConfirmAddress = {
                    navController.navigate(WgcCheckoutPaymentRoute)
                }
            )
        }

        composable<WgcCheckoutPaymentRoute> {
            WgcCheckoutPaymentNavScreen(
                onNavigateBack = { navController.popBackStack() },
                onConfirmPayment = {
                    navController.navigate(WgcCheckoutSuccessRoute())
                }
            )
        }

        composable<WgcCheckoutSuccessRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<WgcCheckoutSuccessRoute>()
            WgcTransactionReceiptContent(
                state = WgcTransactionReceiptUiState(
                    title = "Pedido Confirmado",
                    statusText = "Seu pedido #${route.orderId} foi aprovado com sucesso!",
                    amountFormatted = route.amount
                ),
                onShareReceiptClick = {},
                onSavePdfClick = {},
                onCloseClick = { onCheckoutCompleted(route.orderId) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WgcCheckoutAddressNavScreen(
    onNavigateBack: () -> Unit,
    onConfirmAddress: () -> Unit
) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Endereço de Entrega") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            Surface(
                tonalElevation = WgcCoreDsSpacing.xs8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    WgcClassicButton(
                        textButton = "Ir para Pagamento",
                        onClick = onConfirmAddress,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            val addresses = listOf(
                "Avenida Paulista, 1000 - Bela Vista, São Paulo/SP",
                "Rua das Flores, 450 - Centro, Curitiba/PR"
            )

            addresses.forEachIndexed { index, addr ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                        .clickable { selectedIndex = index },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectedIndex == index) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        RadioButton(
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index }
                        )
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = addr,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WgcCheckoutPaymentNavScreen(
    onNavigateBack: () -> Unit,
    onConfirmPayment: () -> Unit
) {
    var selectedMethod by remember { mutableStateOf("pix") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Forma de Pagamento") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            Surface(
                tonalElevation = WgcCoreDsSpacing.xs8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    WgcClassicButton(
                        textButton = "Finalizar Pedido",
                        onClick = onConfirmPayment,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .clickable { selectedMethod = "pix" },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (selectedMethod == "pix") MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    RadioButton(
                        selected = selectedMethod == "pix",
                        onClick = { selectedMethod = "pix" }
                    )
                    Icon(imageVector = Icons.Default.QrCode, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Column {
                        Text(text = "PIX Instantâneo", style = MaterialTheme.typography.titleSmall)
                        Text(text = "Aprovação imediata com código ou QR Code", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .clickable { selectedMethod = "credit_card" },
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (selectedMethod == "credit_card") MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.md16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    RadioButton(
                        selected = selectedMethod == "credit_card",
                        onClick = { selectedMethod = "credit_card" }
                    )
                    Icon(imageVector = Icons.Default.CreditCard, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Column {
                        Text(text = "Cartão de Crédito Corporativo", style = MaterialTheme.typography.titleSmall)
                        Text(text = "Em até 12x sem juros", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}
