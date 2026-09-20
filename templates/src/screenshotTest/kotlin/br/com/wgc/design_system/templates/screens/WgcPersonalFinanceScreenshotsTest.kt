package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcPersonalFinanceFactory
import br.com.wgc.design_system.templates.factories.WgcPersonalFinanceScreen
import br.com.wgc.design_system.templates.screens.personalfinance.cards.WgcOrganizzeCardsTemplate
import br.com.wgc.design_system.templates.screens.personalfinance.dashboard.WgcOrganizzeDashboardTemplate
import br.com.wgc.design_system.templates.screens.personalfinance.entry.WgcOrganizzeNewTransactionTemplate
import br.com.wgc.design_system.templates.screens.personalfinance.onboarding.WgcOrganizzeOnboardingTemplate
import br.com.wgc.design_system.templates.screens.personalfinance.reports.WgcOrganizzeReportsTemplate
import br.com.wgc.design_system.templates.screens.personalfinance.transactions.WgcOrganizzeTransactionsTemplate

class WgcOrganizzeScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewOrganizzeDashboard() {
        WgcOrganizzeDashboardTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewOrganizzeTransactions() {
        WgcOrganizzeTransactionsTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewOrganizzeNewTransaction() {
        WgcOrganizzeNewTransactionTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewOrganizzeReports() {
        WgcOrganizzeReportsTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewOrganizzeCards() {
        WgcOrganizzeCardsTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewOrganizzeOnboarding() {
        WgcOrganizzeOnboardingTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewOrganizzeFactory() {
        WgcPersonalFinanceFactory(screen = WgcPersonalFinanceScreen.Dashboard)
    }
}
