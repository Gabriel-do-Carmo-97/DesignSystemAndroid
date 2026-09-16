package br.com.wgc.ds_navigation_flows

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
        assertNotNull(br.com.wgc.ds_navigation_flows.auth.WgcAuthLoginRoute)
        assertNotNull(br.com.wgc.ds_navigation_flows.auth.WgcAuthRegisterRoute)
        assertNotNull(br.com.wgc.ds_navigation_flows.auth.WgcAuthOtpRoute(emailOrPhone = "user@test.com"))
    }

    @Test
    fun checkoutRoutes_areInstantiable() {
        assertNotNull(br.com.wgc.ds_navigation_flows.checkout.WgcCheckoutCartRoute)
        assertNotNull(br.com.wgc.ds_navigation_flows.checkout.WgcCheckoutAddressRoute)
        assertNotNull(br.com.wgc.ds_navigation_flows.checkout.WgcCheckoutSuccessRoute(orderId = "123", amount = "R$ 100"))
    }

    @Test
    fun onboardingRoutes_areInstantiable() {
        assertNotNull(br.com.wgc.ds_navigation_flows.onboarding.WgcOnboardingWelcomeRoute)
        assertNotNull(br.com.wgc.ds_navigation_flows.onboarding.WgcOnboardingPermissionsRoute)
    }
}
