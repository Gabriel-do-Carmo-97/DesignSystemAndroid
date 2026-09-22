package br.com.wgc.design_system.templates.screens.loan

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcLoanSimulatorTemplateTest {

    @Test
    fun `loan calculations update estimated payment and total`() {
        val state = WgcLoanSimulatorUiState(
            requestedAmount = 10000f,
            selectedInstallments = 10
        )
        // With INTEREST_RATE_PERCENT = 0.0199f, totalWithInterest = 10000 * (1 + 0.0199 * 10) = 11990
        // monthly = 11990 / 10 = 1199
        assertEquals(1199f, state.estimatedMonthlyPayment, 0.1f)
        assertEquals(11990f, state.totalPayableAmount, 0.1f)
    }

    @Test
    fun `view model handles installment and amount changes`() {
        val viewModel = FakeLoanSimulatorViewModel()
        viewModel.onAmountChange(20000f)
        viewModel.onInstallmentsSelect(36)
        viewModel.onGracePeriodSelect(60)

        val state = viewModel.uiState.value
        assertEquals(20000f, state.requestedAmount, 0.001f)
        assertEquals(36, state.selectedInstallments)
        assertEquals(60, state.selectedGracePeriodDays)
    }

    @Test
    fun `hire loan toggles contract hired flag`() {
        val viewModel = FakeLoanSimulatorViewModel()
        assertFalse(viewModel.uiState.value.isContractHired)

        viewModel.onTermsToggle(true)
        viewModel.onHireLoan()
        assertTrue(viewModel.uiState.value.isContractHired)
    }
}
