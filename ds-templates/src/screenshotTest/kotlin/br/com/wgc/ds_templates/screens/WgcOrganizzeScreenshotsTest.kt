package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcOrganizzeFactory
import br.com.wgc.ds_templates.factories.WgcOrganizzeScreen
import br.com.wgc.ds_templates.screens.organizze.cards.WgcOrganizzeCardsTemplate
import br.com.wgc.ds_templates.screens.organizze.dashboard.WgcOrganizzeDashboardTemplate
import br.com.wgc.ds_templates.screens.organizze.entry.WgcOrganizzeNewTransactionTemplate
import br.com.wgc.ds_templates.screens.organizze.onboarding.WgcOrganizzeOnboardingTemplate
import br.com.wgc.ds_templates.screens.organizze.reports.WgcOrganizzeReportsTemplate
import br.com.wgc.ds_templates.screens.organizze.transactions.WgcOrganizzeTransactionsTemplate

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
        WgcOrganizzeFactory(screen = WgcOrganizzeScreen.Dashboard)
    }
}
