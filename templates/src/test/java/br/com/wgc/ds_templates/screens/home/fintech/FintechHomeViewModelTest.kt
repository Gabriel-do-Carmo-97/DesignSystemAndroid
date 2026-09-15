package br.com.wgc.ds_templates.screens.home.fintech

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class FintechHomeViewModelTest {

    @Test
    fun testDefaultUiState() {
        val viewModel = FakeFintechHomeViewModel()
        val state = viewModel.uiState.value

        assertNotNull(state)
        assertEquals("Gabriel", state.userName)
        assertEquals("R$ 12.450,00", state.balance)
        assertEquals(3, state.transactions.size)
    }
}
