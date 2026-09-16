package br.com.wgc.ds_templates.screens.marketplacescreen

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class MarketplaceHomeViewModelTest {

    @Test
    fun testDefaultUiState() {
        val viewModel = FakeMarketplaceHomeViewModel()
        val state = viewModel.uiState.value

        assertNotNull(state)
        assertEquals("Enviar para Gabriel - Rua Augusta 1000", state.address)
        assertEquals(5, state.categories.size)
        assertEquals(3, state.products.size)
    }
}
