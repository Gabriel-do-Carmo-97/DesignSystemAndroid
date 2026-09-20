package br.com.wgc.design_system.templates.factories

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Testes unitários para as Novas Fábricas Universais de Templates (:templates).
 * Valida a integridade dos enums, variantes e arquitetura de factories.
 */
class WgcFactoriesTest {

    @Test
    fun `WgcCheckoutType should contain all expected variants`() {
        val types = WgcCheckoutType.entries
        assertEquals(6, types.size)
        assertTrue(types.contains(WgcCheckoutType.STANDARD))
        assertTrue(types.contains(WgcCheckoutType.GADGET_SHOP))
        assertTrue(types.contains(WgcCheckoutType.MEGA_STORE))
        assertTrue(types.contains(WgcCheckoutType.QUICK_SHOP))
        assertTrue(types.contains(WgcCheckoutType.RETAIL))
        assertTrue(types.contains(WgcCheckoutType.TREND_FASHION))
    }

    @Test
    fun `WgcOnboardingType should contain all expected variants`() {
        val types = WgcOnboardingType.entries
        assertEquals(5, types.size)
        assertTrue(types.contains(WgcOnboardingType.STANDARD))
        assertTrue(types.contains(WgcOnboardingType.GADGET_SHOP))
        assertTrue(types.contains(WgcOnboardingType.PERSONAL_FINANCE))
        assertTrue(types.contains(WgcOnboardingType.QUICK_SHOP))
        assertTrue(types.contains(WgcOnboardingType.TREND_FASHION))
    }

    @Test
    fun `WgcCartType should contain all expected variants`() {
        val types = WgcCartType.entries
        assertEquals(14, types.size)
        assertTrue(types.contains(WgcCartType.STANDARD))
        assertTrue(types.contains(WgcCartType.MEGA_STORE))
        assertTrue(types.contains(WgcCartType.RETAIL))
        assertTrue(types.contains(WgcCartType.GADGET_SHOP))
        assertTrue(types.contains(WgcCartType.BOUTIQUE))
        assertTrue(types.contains(WgcCartType.FRESH_GROCERY))
        assertTrue(types.contains(WgcCartType.CURATED_MARKET))
        assertTrue(types.contains(WgcCartType.APPAREL))
        assertTrue(types.contains(WgcCartType.HYPERMARKET))
        assertTrue(types.contains(WgcCartType.PREMIUM_GROCERY))
        assertTrue(types.contains(WgcCartType.GROCERY))
        assertTrue(types.contains(WgcCartType.PHARMACY_CHAIN))
        assertTrue(types.contains(WgcCartType.CARE_PHARMACY))
        assertTrue(types.contains(WgcCartType.POPULAR_PHARMACY))
    }
}
