package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcOrganizzeNavItem
import br.com.wgc.ds_templates.screens.organizze.cards.WgcOrganizzeCardsTemplate
import br.com.wgc.ds_templates.screens.organizze.dashboard.WgcOrganizzeDashboardTemplate
import br.com.wgc.ds_templates.screens.organizze.entry.WgcOrganizzeNewTransactionTemplate
import br.com.wgc.ds_templates.screens.organizze.onboarding.WgcOrganizzeOnboardingTemplate
import br.com.wgc.ds_templates.screens.organizze.reports.WgcOrganizzeReportsTemplate
import br.com.wgc.ds_templates.screens.organizze.transactions.WgcOrganizzeTransactionsTemplate

enum class WgcOrganizzeScreen {
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
fun WgcOrganizzeFactory(
    modifier: Modifier = Modifier,
    screen: WgcOrganizzeScreen = WgcOrganizzeScreen.Dashboard,
    onNavigateToScreen: (WgcOrganizzeScreen) -> Unit = {}
) {
    when (screen) {
        WgcOrganizzeScreen.Dashboard -> {
            WgcOrganizzeDashboardTemplate(
                modifier = modifier,
                onViewAllTransactionsClick = { onNavigateToScreen(WgcOrganizzeScreen.Transactions) },
                onViewAllCardsClick = { onNavigateToScreen(WgcOrganizzeScreen.Cards) },
                onNewExpenseClick = { onNavigateToScreen(WgcOrganizzeScreen.NewTransaction) },
                onNewIncomeClick = { onNavigateToScreen(WgcOrganizzeScreen.NewTransaction) },
                onNewTransferClick = { onNavigateToScreen(WgcOrganizzeScreen.NewTransaction) },
                onBottomNavItemSelected = { navItem ->
                    when (navItem) {
                        WgcOrganizzeNavItem.Dashboard -> onNavigateToScreen(WgcOrganizzeScreen.Dashboard)
                        WgcOrganizzeNavItem.Transactions -> onNavigateToScreen(WgcOrganizzeScreen.Transactions)
                        WgcOrganizzeNavItem.Reports -> onNavigateToScreen(WgcOrganizzeScreen.Reports)
                        WgcOrganizzeNavItem.Cards -> onNavigateToScreen(WgcOrganizzeScreen.Cards)
                    }
                }
            )
        }
        WgcOrganizzeScreen.Transactions -> {
            WgcOrganizzeTransactionsTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcOrganizzeScreen.Dashboard) },
                onNewTransactionClick = { onNavigateToScreen(WgcOrganizzeScreen.NewTransaction) }
            )
        }
        WgcOrganizzeScreen.NewTransaction -> {
            WgcOrganizzeNewTransactionTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcOrganizzeScreen.Dashboard) },
                onSaveClick = { _, _, _, _ -> onNavigateToScreen(WgcOrganizzeScreen.Dashboard) }
            )
        }
        WgcOrganizzeScreen.Reports -> {
            WgcOrganizzeReportsTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcOrganizzeScreen.Dashboard) }
            )
        }
        WgcOrganizzeScreen.Cards -> {
            WgcOrganizzeCardsTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcOrganizzeScreen.Dashboard) }
            )
        }
        WgcOrganizzeScreen.Onboarding -> {
            WgcOrganizzeOnboardingTemplate(
                modifier = modifier,
                onGetStartedClick = { onNavigateToScreen(WgcOrganizzeScreen.Dashboard) },
                onLoginClick = { onNavigateToScreen(WgcOrganizzeScreen.Dashboard) }
            )
        }
    }
}
