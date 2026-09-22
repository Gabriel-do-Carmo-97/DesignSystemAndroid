package br.com.wgc.design_system.templates.screens.pix

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcPixTransferTemplateTest {

    @Test
    fun `fake view model updates key and amount correctly`() {
        val viewModel = FakePixTransferViewModel()

        viewModel.onKeyChange("test@wgc.com.br")
        viewModel.onAmountChange("350,00")

        val state = viewModel.uiState.value
        assertEquals("test@wgc.com.br", state.pixKey)
        assertEquals("350,00", state.amount)
    }

    @Test
    fun `confirm transfer toggles isConfirmed state`() {
        val viewModel = FakePixTransferViewModel()
        assertFalse(viewModel.uiState.value.isConfirmed)

        viewModel.onConfirmTransfer()
        assertTrue(viewModel.uiState.value.isConfirmed)
    }

    @Test
    fun `key type selection updates state`() {
        val viewModel = FakePixTransferViewModel()
        viewModel.onKeyTypeSelect("Celular")
        assertEquals("Celular", viewModel.uiState.value.selectedKeyType)
    }
}
