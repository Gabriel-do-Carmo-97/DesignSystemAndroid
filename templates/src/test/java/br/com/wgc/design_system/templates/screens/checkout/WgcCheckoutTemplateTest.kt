package br.com.wgc.design_system.templates.screens.checkout

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcCheckoutTemplateTest {

    @Test
    fun `initial state has correct default values`() {
        val state = WgcCheckoutUiState()
        assertEquals("Av. Paulista, 1000 - Bela Vista, São Paulo - SP, 01310-100", state.shippingAddress)
        assertEquals("credit_card", state.paymentMethodType)
        assertEquals(2, state.items.size)
        assertEquals("R$ 4.348,00", state.totalPrice)
        assertTrue(state.isCouponApplied)
        assertFalse(state.isProcessingPayment)
    }

    @Test
    fun `remove coupon clears discount and updates total`() {
        val viewModel = FakeCheckoutViewModel()
        assertTrue(viewModel.uiState.value.isCouponApplied)

        viewModel.onRemoveCoupon()
        assertFalse(viewModel.uiState.value.isCouponApplied)
        assertNull(viewModel.uiState.value.discount)
        assertEquals("R$ 4.448,00", viewModel.uiState.value.totalPrice)
    }

    @Test
    fun `apply coupon sets discount and updates total`() {
        val viewModel = FakeCheckoutViewModel()
        viewModel.onRemoveCoupon()
        viewModel.onApplyCoupon("PROMO20")

        assertTrue(viewModel.uiState.value.isCouponApplied)
        assertEquals("PROMO20", viewModel.uiState.value.couponCode)
        assertEquals("- R$ 100,00", viewModel.uiState.value.discount)
        assertEquals("R$ 4.348,00", viewModel.uiState.value.totalPrice)
    }

    @Test
    fun `confirm order sets processing payment flag`() {
        val viewModel = FakeCheckoutViewModel()
        assertFalse(viewModel.uiState.value.isProcessingPayment)

        viewModel.onConfirmOrderClick()
        assertTrue(viewModel.uiState.value.isProcessingPayment)
    }
}
