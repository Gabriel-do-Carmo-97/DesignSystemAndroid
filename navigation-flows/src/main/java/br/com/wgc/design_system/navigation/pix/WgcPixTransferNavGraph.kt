@file:Suppress("LongMethod", "UnusedPrivateMember")

package br.com.wgc.design_system.navigation.pix

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.pix.FakePixTransferViewModel
import br.com.wgc.design_system.templates.screens.pix.WgcPixTransferContent
import br.com.wgc.design_system.templates.screens.pix.WgcPixTransferUiState
import kotlinx.serialization.Serializable

@Serializable
object WgcPixGraphRoute

@Serializable
object WgcPixHomeRoute

@Serializable
data class WgcPixReceiptRoute(
    val transactionId: String,
    val amount: String,
    val recipient: String,
    val date: String = "Hoje"
)

/**
 * Grafo desacoplado de navegação do fluxo Pix (Chave -> Valor -> Comprovante).
 *
 * @param navController Controlador de navegação Compose
 * @param onNavigateBack Callback acionado ao voltar ou cancelar o fluxo
 * @param onShareReceipt Callback acionado ao compartilhar comprovante
 */
@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.wgcPixTransferNavGraph(
    navController: NavController,
    onNavigateBack: () -> Unit = {},
    onShareReceipt: (String) -> Unit = {}
) {
    navigation<WgcPixGraphRoute>(startDestination = WgcPixHomeRoute) {
        composable<WgcPixHomeRoute> {
            val fakeVm = FakePixTransferViewModel()
            WgcPixTransferContent(
                state = fakeVm.uiState.value,
                onKeyChange = fakeVm::onKeyChange,
                onKeyTypeSelect = fakeVm::onKeyTypeSelect,
                onAmountChange = fakeVm::onAmountChange,
                onDescriptionChange = fakeVm::onDescriptionChange,
                onBackClick = onNavigateBack,
                onConfirmTransfer = {
                    val txId = "PIX-${System.currentTimeMillis()}"
                    navController.navigate(
                        WgcPixReceiptRoute(
                            transactionId = txId,
                            amount = fakeVm.uiState.value.amount.ifBlank { "150,00" },
                            recipient = fakeVm.uiState.value.recipientName ?: "Destinatário WGC"
                        )
                    )
                }
            )
        }

        composable<WgcPixReceiptRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<WgcPixReceiptRoute>()
            WgcPixReceiptScreen(
                route = route,
                onBackClick = { navController.popBackStack() },
                onShareClick = { onShareReceipt(route.transactionId) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WgcPixReceiptScreen(
    route: WgcPixReceiptRoute,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Comprovante Pix", style = MaterialTheme.typography.titleMedium) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(WgcCoreDsSpacing.xxxl48.dp)
            )

            Text(
                text = "Transferência Realizada com Sucesso!",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    ReceiptDetailLine(label = "Valor Transferido:", value = "R$ ${route.amount}")
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                    ReceiptDetailLine(label = "Destinatário:", value = route.recipient)
                    ReceiptDetailLine(label = "Identificador:", value = route.transactionId)
                    ReceiptDetailLine(label = "Data da Operação:", value = route.date)
                }
            }

            WgcClassicButton(
                textButton = "Compartilhar Comprovante",
                onClick = onShareClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun ReceiptDetailLine(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(text = value, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold)
    }
}
