@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.statement.BaseFinancialStatementViewModel
import br.com.wgc.design_system.templates.screens.statement.FakeFinancialStatementViewModel
import br.com.wgc.design_system.templates.screens.statement.WgcFinancialStatementTemplate
import br.com.wgc.design_system.templates.screens.statement.WgcStatementTransactionItem

/**
 * Variantes de Extrato Financeiro suportadas pela [WgcStatementFactory].
 */
enum class WgcStatementType {
    STANDARD
}

/**
 * Fábrica Universal de Telas de Extrato Financeiro (WgcStatementFactory).
 *
 * Fornece ponto de entrada unificado para consulta de lançamentos, saldos e extratos da conta.
 */
@Composable
fun WgcStatementFactory(
    modifier: Modifier = Modifier,
    type: WgcStatementType = WgcStatementType.STANDARD,
    viewModel: BaseFinancialStatementViewModel = FakeFinancialStatementViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    balanceCardSlot: (@Composable () -> Unit)? = null,
    filterSlot: (@Composable () -> Unit)? = null,
    transactionItemSlot: (@Composable (WgcStatementTransactionItem) -> Unit)? = null,
    emptyStateSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {}
) {
    when (type) {
        WgcStatementType.STANDARD -> {
            WgcFinancialStatementTemplate(
                modifier = modifier,
                viewModel = viewModel,
                headerSlot = headerSlot,
                balanceCardSlot = balanceCardSlot,
                filterSlot = filterSlot,
                transactionItemSlot = transactionItemSlot,
                emptyStateSlot = emptyStateSlot,
                onBackClick = onBackClick
            )
        }
    }
}
