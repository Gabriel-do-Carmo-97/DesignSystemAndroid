package br.com.wgc.design_system.templates.screens.statement

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcFinancialStatementTemplateTest {

    @Test
    fun `initial state has correct default values`() {
        val state = WgcFinancialStatementUiState()
        assertEquals("Gabriel", state.userName)
        assertTrue(state.isBalanceVisible)
        assertEquals("Todos", state.selectedCategory)
        assertEquals("Últimos 30 dias", state.selectedPeriod)
        assertEquals(5, state.transactions.size)
        assertFalse(state.isLoading)
    }

    @Test
    fun `toggle balance visibility updates state`() {
        val viewModel = FakeFinancialStatementViewModel()
        assertTrue(viewModel.uiState.value.isBalanceVisible)

        viewModel.onToggleBalanceVisibility()
        assertFalse(viewModel.uiState.value.isBalanceVisible)

        viewModel.onToggleBalanceVisibility()
        assertTrue(viewModel.uiState.value.isBalanceVisible)
    }

    @Test
    fun `select period updates state`() {
        val viewModel = FakeFinancialStatementViewModel()
        viewModel.onPeriodSelected("7 dias")
        assertEquals("7 dias", viewModel.uiState.value.selectedPeriod)
    }

    @Test
    fun `select category updates state`() {
        val viewModel = FakeFinancialStatementViewModel()
        viewModel.onCategorySelected("PIX")
        assertEquals("PIX", viewModel.uiState.value.selectedCategory)
    }
}
