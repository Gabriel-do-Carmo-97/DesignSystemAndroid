package br.com.wgc.design_system.templates.screens.fooddelivery

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class FoodDeliveryHomeViewModelTest {

    @Test
    fun testDefaultUiState() {
        val viewModel = FakeFoodDeliveryHomeViewModel()
        val state = viewModel.uiState.value

        assertNotNull(state)
        assertEquals("Rua Augusta, 1000 - Consolação", state.address)
        assertEquals(5, state.categories.size)
        assertEquals(3, state.restaurants.size)
        assertEquals("R$ 54,90", state.cartTotal)
    }
}
