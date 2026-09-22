package br.com.wgc.design_system.navigation

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class DsNavigationFlowsInitializationTest {

    @Test
    fun moduleInfo_returnsCorrectModuleName() {
        assertEquals("ds-navigation-flows", WgcNavigationFlowsInfo.MODULE_NAME)
    }

    @Test
    fun moduleInfo_returnsNonNullVersion() {
        assertNotNull(WgcNavigationFlowsInfo.VERSION)
    }

    @Test
    fun authRoutes_areInstantiable() {
        assertNotNull(br.com.wgc.design_system.navigation.auth.WgcAuthLoginRoute)
        assertNotNull(br.com.wgc.design_system.navigation.auth.WgcAuthRegisterRoute)
        assertNotNull(br.com.wgc.design_system.navigation.auth.WgcAuthOtpRoute(emailOrPhone = "user@test.com"))
    }

    @Test
    fun checkoutRoutes_areInstantiable() {
        assertNotNull(br.com.wgc.design_system.navigation.checkout.WgcCheckoutCartRoute)
        assertNotNull(br.com.wgc.design_system.navigation.checkout.WgcCheckoutAddressRoute)
        assertNotNull(br.com.wgc.design_system.navigation.checkout.WgcCheckoutSuccessRoute(orderId = "123", amount = "R$ 100"))
    }

    @Test
    fun onboardingRoutes_areInstantiable() {
        assertNotNull(br.com.wgc.design_system.navigation.onboarding.WgcOnboardingWelcomeRoute)
        assertNotNull(br.com.wgc.design_system.navigation.onboarding.WgcOnboardingPermissionsRoute)
    }
}
