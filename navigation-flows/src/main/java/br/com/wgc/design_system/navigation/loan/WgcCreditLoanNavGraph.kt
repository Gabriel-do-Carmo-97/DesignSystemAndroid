@file:Suppress("LongMethod", "UnusedPrivateMember")

package br.com.wgc.design_system.navigation.loan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
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
import br.com.wgc.design_system.templates.screens.loan.FakeLoanSimulatorViewModel
import br.com.wgc.design_system.templates.screens.loan.WgcLoanSimulatorContent
import kotlinx.serialization.Serializable
import kotlin.math.roundToInt

@Serializable
object WgcLoanGraphRoute

@Serializable
object WgcLoanHomeRoute

@Serializable
data class WgcLoanSuccessRoute(
    val contractNumber: String,
    val amount: Float
)

/**
 * Grafo desacoplado de navegação do fluxo de Empréstimo e Crédito.
 *
 * @param navController Controlador de navegação
 * @param onNavigateBack Callback acionado ao sair da esteira de contratação
 * @param onFinishFlow Callback acionado ao concluir com sucesso
 */
@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.wgcCreditLoanNavGraph(
    navController: NavController,
    onNavigateBack: () -> Unit = {},
    onFinishFlow: () -> Unit = {}
) {
    navigation<WgcLoanGraphRoute>(startDestination = WgcLoanHomeRoute) {
        composable<WgcLoanHomeRoute> {
            val fakeVm = FakeLoanSimulatorViewModel()
            WgcLoanSimulatorContent(
                state = fakeVm.uiState.value,
                onBackClick = onNavigateBack,
                onAmountChange = fakeVm::onAmountChange,
                onInstallmentsSelect = fakeVm::onInstallmentsSelect,
                onGracePeriodSelect = fakeVm::onGracePeriodSelect,
                onTermsToggle = fakeVm::onTermsToggle,
                onHireLoan = {
                    val contractId = "CTR-${System.currentTimeMillis()}"
                    navController.navigate(
                        WgcLoanSuccessRoute(
                            contractNumber = contractId,
                            amount = fakeVm.uiState.value.requestedAmount
                        )
                    )
                }
            )
        }

        composable<WgcLoanSuccessRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<WgcLoanSuccessRoute>()
            LoanContractSuccessScreen(
                contractNumber = route.contractNumber,
                amount = route.amount,
                onClose = onFinishFlow
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoanContractSuccessScreen(
    contractNumber: String,
    amount: Float,
    onClose: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contratação Concluída", style = MaterialTheme.typography.titleMedium) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(WgcCoreDsSpacing.xxxl48.dp)
            )

            Text(
                text = "Crédito Contratado com Sucesso!",
                style = MaterialTheme.typography.titleLarge,
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
                    SuccessRow(label = "Número do Contrato:", value = contractNumber)
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                    SuccessRow(label = "Valor Liberado:", value = "R$ ${amount.roundToInt()},00")
                    SuccessRow(label = "Disponibilização:", value = "Imediata na Conta WGC")
                }
            }

            WgcClassicButton(
                textButton = "Voltar para o Início",
                onClick = onClose,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun SuccessRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(text = value, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold)
    }
}
