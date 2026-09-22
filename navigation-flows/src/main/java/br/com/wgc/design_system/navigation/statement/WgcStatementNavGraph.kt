package br.com.wgc.design_system.navigation.statement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import br.com.wgc.design_system.templates.screens.statement.FakeFinancialStatementViewModel
import br.com.wgc.design_system.templates.screens.statement.WgcFinancialStatementContent
import kotlinx.serialization.Serializable

@Serializable
object WgcStatementGraphRoute

@Serializable
object WgcStatementHomeRoute

@Serializable
data class WgcStatementDetailRoute(
    val transactionId: String,
    val title: String = "",
    val amount: String = "",
    val isCredit: Boolean = false,
    val date: String = ""
)

/**
 * Grafo de navegação completo para o Extrato e Histórico Financeiro da Conta.
 *
 * @param navController Controlador de navegação.
 * @param onNavigateBack Callback acionado ao sair do extrato.
 * @param onExportStatement Callback acionado ao exportar relatório financeiro.
 */
fun NavGraphBuilder.wgcStatementNavGraph(
    navController: NavController,
    onNavigateBack: () -> Unit = {},
    onExportStatement: () -> Unit = {}
) {
    navigation<WgcStatementGraphRoute>(startDestination = WgcStatementHomeRoute) {
        composable<WgcStatementHomeRoute> {
            val fakeVm = FakeFinancialStatementViewModel()
            WgcFinancialStatementContent(
                state = fakeVm.uiState.value,
                onBackClick = onNavigateBack,
                onExportClick = onExportStatement,
                onToggleBalance = fakeVm::onToggleBalanceVisibility,
                onPeriodSelected = fakeVm::onPeriodSelected,
                onCategorySelected = fakeVm::onCategorySelected,
                onTransactionClick = { tx ->
                    navController.navigate(
                        WgcStatementDetailRoute(
                            transactionId = tx.id,
                            title = tx.title,
                            amount = tx.amount,
                            isCredit = tx.isCredit,
                            date = tx.date
                        )
                    )
                }
            )
        }

        composable<WgcStatementDetailRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<WgcStatementDetailRoute>()
            WgcTransactionReceiptScreen(
                route = route,
                onBackClick = { navController.popBackStack() },
                onShareClick = onExportStatement
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun WgcTransactionReceiptScreen(
    route: WgcStatementDetailRoute,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Comprovante da Transação", style = MaterialTheme.typography.titleMedium) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
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
                .padding(WgcCoreDsSpacing.md16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            ReceiptDetailsCard(route = route)

            WgcClassicButton(
                textButton = "Compartilhar Comprovante",
                onClick = onShareClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun ReceiptDetailsCard(route: WgcStatementDetailRoute) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Text(
                text = "Valor",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = if (route.amount.isNotBlank()) route.amount else "R$ 0,00",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = if (route.isCredit) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
            )
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            ReceiptRow(label = "Descrição", value = if (route.title.isNotBlank()) route.title else "Transação")
            ReceiptRow(label = "Identificador", value = route.transactionId)
            ReceiptRow(label = "Data e Hora", value = if (route.date.isNotBlank()) route.date else "Hoje")
            ReceiptRow(label = "Status", value = "Concluída com Sucesso")
        }
    }
}

@Composable
private fun ReceiptRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(text = value, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold)
    }
}
