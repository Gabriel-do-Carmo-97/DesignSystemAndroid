package br.com.wgc.ds_templates.screens.ifood

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class IFoodHomeViewModelTest {

    @Test
    fun testDefaultUiState() {
        val viewModel = FakeIFoodHomeViewModel()
        val state = viewModel.uiState.value

        assertNotNull(state)
        assertEquals("Rua Augusta, 1000 - Consolação", state.address)
        assertEquals(5, state.categories.size)
        assertEquals(3, state.restaurants.size)
        assertEquals("R$ 54,90", state.cartTotal)
    }
}
