package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcPersonalFinanceFactory
import br.com.wgc.ds_templates.factories.WgcPersonalFinanceScreen
import br.com.wgc.ds_templates.screens.personalfinance.cards.WgcOrganizzeCardsTemplate
import br.com.wgc.ds_templates.screens.personalfinance.dashboard.WgcOrganizzeDashboardTemplate
import br.com.wgc.ds_templates.screens.personalfinance.entry.WgcOrganizzeNewTransactionTemplate
import br.com.wgc.ds_templates.screens.personalfinance.onboarding.WgcOrganizzeOnboardingTemplate
import br.com.wgc.ds_templates.screens.personalfinance.reports.WgcOrganizzeReportsTemplate
import br.com.wgc.ds_templates.screens.personalfinance.transactions.WgcOrganizzeTransactionsTemplate

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
