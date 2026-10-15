package br.com.wgc.design_system.factories.statement

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.screens.statement.FakeFinancialStatementViewModel
import br.com.wgc.design_system.templates.screens.statement.WgcFinancialStatementTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Extrato Financeiro (WgcStatementScreenFactory).
 */
@Composable
fun WgcStatementScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcStatementVariant = WgcStatementVariant.STANDARD,
    onBackClick: () -> Unit = {}
) {
    when (variant) {
        WgcStatementVariant.STANDARD,
        WgcStatementVariant.DETAILED,
        WgcStatementVariant.EXPENSES_ONLY -> WgcFinancialStatementTemplate(
            modifier = modifier,
            viewModel = FakeFinancialStatementViewModel(),
            onBackClick = onBackClick
        )
    }
}

@Preview(name = "WgcStatementScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcStatementScreenFactoryPreview() {
    WgcTheme {
        WgcStatementScreenFactory()
    }
}
