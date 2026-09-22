package br.com.wgc.design_system.templates.screens.card

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcCardManagementTemplateTest {

    @Test
    fun `toggle lock switches card locked state`() {
        val viewModel = FakeCardManagementViewModel()
        assertFalse(viewModel.uiState.value.isLocked)

        viewModel.onToggleLock()
        assertTrue(viewModel.uiState.value.isLocked)

        viewModel.onToggleLock()
        assertFalse(viewModel.uiState.value.isLocked)
    }

    @Test
    fun `limit change updates current limit`() {
        val viewModel = FakeCardManagementViewModel()
        viewModel.onLimitChange(7500f)
        assertEquals(7500f, viewModel.uiState.value.currentLimit, 0.001f)
    }

    @Test
    fun `create virtual card generates virtual flag and new number`() {
        val viewModel = FakeCardManagementViewModel()
        assertFalse(viewModel.uiState.value.isVirtual)

        viewModel.onCreateVirtualCard()
        assertTrue(viewModel.uiState.value.isVirtual)
        assertEquals("•••• •••• •••• 4129", viewModel.uiState.value.cardNumberMasked)
    }
}
