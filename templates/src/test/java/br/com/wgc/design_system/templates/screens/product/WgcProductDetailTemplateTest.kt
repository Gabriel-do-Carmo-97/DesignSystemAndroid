package br.com.wgc.design_system.templates.screens.product

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcProductDetailTemplateTest {

    @Test
    fun `initial state has correct default values`() {
        val state = WgcProductDetailUiState()
        assertEquals("prod_101", state.productId)
        assertEquals(4.8f, state.rating)
        assertEquals(1, state.quantity)
        assertFalse(state.isFavorite)
        assertEquals("Titanium Black", state.selectedColor)
        assertEquals("256GB", state.selectedSize)
        assertEquals(4, state.images.size)
    }

    @Test
    fun `selecting image updates selected index`() {
        val viewModel = FakeProductDetailViewModel()
        viewModel.onSelectImage(2)
        assertEquals(2, viewModel.uiState.value.selectedImageIndex)
    }

    @Test
    fun `selecting color updates state`() {
        val viewModel = FakeProductDetailViewModel()
        viewModel.onSelectColor("Azul Noturno")
        assertEquals("Azul Noturno", viewModel.uiState.value.selectedColor)
    }

    @Test
    fun `selecting size updates state`() {
        val viewModel = FakeProductDetailViewModel()
        viewModel.onSelectSize("512GB")
        assertEquals("512GB", viewModel.uiState.value.selectedSize)
    }

    @Test
    fun `quantity change adheres to minimum limit`() {
        val viewModel = FakeProductDetailViewModel()
        viewModel.onQuantityChange(3)
        assertEquals(3, viewModel.uiState.value.quantity)

        viewModel.onQuantityChange(0) // should not decrease below 1
        assertEquals(3, viewModel.uiState.value.quantity)
    }

    @Test
    fun `favorite toggle flips favorite state`() {
        val viewModel = FakeProductDetailViewModel()
        assertFalse(viewModel.uiState.value.isFavorite)

        viewModel.onFavoriteClick()
        assertTrue(viewModel.uiState.value.isFavorite)

        viewModel.onFavoriteClick()
        assertFalse(viewModel.uiState.value.isFavorite)
    }
}
