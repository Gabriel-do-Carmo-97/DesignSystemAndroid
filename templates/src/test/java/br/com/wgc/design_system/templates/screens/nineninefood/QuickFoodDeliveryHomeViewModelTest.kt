package br.com.wgc.design_system.templates.screens.quickfooddelivery

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class QuickFoodDeliveryHomeViewModelTest {

    @Test
    fun testDefaultUiState() {
        val viewModel = FakeQuickFoodDeliveryHomeViewModel()
        val state = viewModel.uiState.value

        assertNotNull(state)
        assertEquals("Av. Paulista, 1000 - Bela Vista", state.address)
        assertEquals(5, state.categories.size)
        assertEquals(3, state.restaurants.size)
        assertEquals("R$ 62,50", state.cartTotal)
    }
}
