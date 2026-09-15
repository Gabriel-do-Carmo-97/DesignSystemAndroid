package br.com.wgc.ds_templates.screens.nineninefood

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class NineNineFoodHomeViewModelTest {

    @Test
    fun testDefaultUiState() {
        val viewModel = FakeNineNineFoodHomeViewModel()
        val state = viewModel.uiState.value

        assertNotNull(state)
        assertEquals("Av. Paulista, 1000 - Bela Vista", state.address)
        assertEquals(5, state.categories.size)
        assertEquals(3, state.restaurants.size)
        assertEquals("R$ 62,50", state.cartTotal)
    }
}
