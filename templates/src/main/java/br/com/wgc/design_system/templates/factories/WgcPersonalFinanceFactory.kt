package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcOrganizzeNavItem
import br.com.wgc.design_system.templates.screens.personalfinance.cards.WgcOrganizzeCardsTemplate
import br.com.wgc.design_system.templates.screens.personalfinance.dashboard.WgcOrganizzeDashboardTemplate
import br.com.wgc.design_system.templates.screens.personalfinance.entry.WgcOrganizzeNewTransactionTemplate
import br.com.wgc.design_system.templates.screens.personalfinance.onboarding.WgcOrganizzeOnboardingTemplate
import br.com.wgc.design_system.templates.screens.personalfinance.reports.WgcOrganizzeReportsTemplate
import br.com.wgc.design_system.templates.screens.personalfinance.transactions.WgcOrganizzeTransactionsTemplate

enum class WgcPersonalFinanceScreen {
    Dashboard,
    Transactions,
    NewTransaction,
    Reports,
    Cards,
    Onboarding
}

/**
 * Factory Unificada da Suíte Organizze.
 * Provê alternância imediata entre todas as telas do ecossistema de controle financeiro.
 */
@Composable
fun WgcPersonalFinanceFactory(
    modifier: Modifier = Modifier,
    screen: WgcPersonalFinanceScreen = WgcPersonalFinanceScreen.Dashboard,
    onNavigateToScreen: (WgcPersonalFinanceScreen) -> Unit = {}
) {
    when (screen) {
        WgcPersonalFinanceScreen.Dashboard -> {
            WgcOrganizzeDashboardTemplate(
                modifier = modifier,
                onViewAllTransactionsClick = { onNavigateToScreen(WgcPersonalFinanceScreen.Transactions) },
                onViewAllCardsClick = { onNavigateToScreen(WgcPersonalFinanceScreen.Cards) },
                onNewExpenseClick = { onNavigateToScreen(WgcPersonalFinanceScreen.NewTransaction) },
                onNewIncomeClick = { onNavigateToScreen(WgcPersonalFinanceScreen.NewTransaction) },
                onNewTransferClick = { onNavigateToScreen(WgcPersonalFinanceScreen.NewTransaction) },
                onBottomNavItemSelected = { navItem ->
                    when (navItem) {
                        WgcOrganizzeNavItem.Dashboard -> onNavigateToScreen(WgcPersonalFinanceScreen.Dashboard)
                        WgcOrganizzeNavItem.Transactions -> onNavigateToScreen(WgcPersonalFinanceScreen.Transactions)
                        WgcOrganizzeNavItem.Reports -> onNavigateToScreen(WgcPersonalFinanceScreen.Reports)
                        WgcOrganizzeNavItem.Cards -> onNavigateToScreen(WgcPersonalFinanceScreen.Cards)
                    }
                }
            )
        }
        WgcPersonalFinanceScreen.Transactions -> {
            WgcOrganizzeTransactionsTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcPersonalFinanceScreen.Dashboard) },
                onNewTransactionClick = { onNavigateToScreen(WgcPersonalFinanceScreen.NewTransaction) }
            )
        }
        WgcPersonalFinanceScreen.NewTransaction -> {
            WgcOrganizzeNewTransactionTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcPersonalFinanceScreen.Dashboard) },
                onSaveClick = { _, _, _, _ -> onNavigateToScreen(WgcPersonalFinanceScreen.Dashboard) }
            )
        }
        WgcPersonalFinanceScreen.Reports -> {
            WgcOrganizzeReportsTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcPersonalFinanceScreen.Dashboard) }
            )
        }
        WgcPersonalFinanceScreen.Cards -> {
            WgcOrganizzeCardsTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcPersonalFinanceScreen.Dashboard) }
            )
        }
        WgcPersonalFinanceScreen.Onboarding -> {
            WgcOrganizzeOnboardingTemplate(
                modifier = modifier,
                onGetStartedClick = { onNavigateToScreen(WgcPersonalFinanceScreen.Dashboard) },
                onLoginClick = { onNavigateToScreen(WgcPersonalFinanceScreen.Dashboard) }
            )
        }
    }
}
