package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.verticals.personalfinance.WgcPersonalFinanceFactory
import br.com.wgc.design_system.factories.verticals.personalfinance.WgcPersonalFinanceScreen
import br.com.wgc.design_system.factories.verticals.personalfinance.templates.cards.WgcOrganizzeCardsTemplate
import br.com.wgc.design_system.factories.verticals.personalfinance.templates.dashboard.WgcOrganizzeDashboardTemplate
import br.com.wgc.design_system.factories.verticals.personalfinance.templates.entry.WgcOrganizzeNewTransactionTemplate
import br.com.wgc.design_system.factories.verticals.personalfinance.templates.onboarding.WgcOrganizzeOnboardingTemplate
import br.com.wgc.design_system.factories.verticals.personalfinance.templates.reports.WgcOrganizzeReportsTemplate
import br.com.wgc.design_system.factories.verticals.personalfinance.templates.transactions.WgcOrganizzeTransactionsTemplate

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
