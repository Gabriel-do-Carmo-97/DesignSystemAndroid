package br.com.wgc.design_system.factories

import br.com.wgc.design_system.coordinators.address.WgcAddressFlowStep
import br.com.wgc.design_system.coordinators.auth.WgcAuthStep
import br.com.wgc.design_system.coordinators.auth.WgcAuthVariant
import br.com.wgc.design_system.coordinators.cart.WgcCartFlowStep
import br.com.wgc.design_system.coordinators.checkout.WgcCheckoutFlowStep
import br.com.wgc.design_system.coordinators.dynamic.WgcFlowStep
import br.com.wgc.design_system.coordinators.dynamic.WgcDynamicFlowDefaults
import br.com.wgc.design_system.coordinators.composite.WgcSubFlow
import br.com.wgc.design_system.coordinators.composite.WgcCompositeFlowDefaults
import br.com.wgc.design_system.coordinators.home.WgcHomeTab
import br.com.wgc.design_system.coordinators.payment.WgcPaymentFlowStep
import br.com.wgc.design_system.factories.address.WgcSavedAddressItem
import br.com.wgc.design_system.factories.auth.WgcLoginVariant
import br.com.wgc.design_system.factories.biometrics.WgcBiometricsVariant
import br.com.wgc.design_system.factories.cart.WgcCartVariant
import br.com.wgc.design_system.factories.checkout.WgcCheckoutVariant
import br.com.wgc.design_system.factories.error.WgcErrorVariant
import br.com.wgc.design_system.factories.home.WgcHomeVariant
import br.com.wgc.design_system.factories.notification.WgcNotificationVariant
import br.com.wgc.design_system.factories.onboarding.WgcOnboardingVariant
import br.com.wgc.design_system.factories.payment.WgcPaymentMethodVariant
import br.com.wgc.design_system.factories.payment.WgcPixScreenVariant
import br.com.wgc.design_system.factories.product.WgcProductDetailVariant
import br.com.wgc.design_system.factories.profile.WgcProfileVariant
import br.com.wgc.design_system.factories.review.WgcReviewVariant
import br.com.wgc.design_system.factories.search.WgcSearchVariant
import br.com.wgc.design_system.factories.security.WgcSecurityVariant
import br.com.wgc.design_system.factories.settings.WgcSettingsVariant
import br.com.wgc.design_system.factories.statement.WgcStatementVariant
import br.com.wgc.design_system.factories.support.WgcHelpCenterVariant
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Testes unitários para as Novas Fábricas Especializadas por Assunto e Coordenadores de Fluxo.
 */
class WgcSubjectFactoriesAndCoordinatorsTest {

    @Test
    fun `WgcLoginVariant should provide all expected branding and functional variants`() {
        val variants = WgcLoginVariant.entries
        assertTrue(variants.contains(WgcLoginVariant.FOOD_DELIVERY))
        assertTrue(variants.contains(WgcLoginVariant.RIDE_HAILING))
        assertTrue(variants.contains(WgcLoginVariant.MARKETPLACE))
        assertTrue(variants.contains(WgcLoginVariant.BIOMETRIC))
        assertTrue(variants.contains(WgcLoginVariant.TREND_FASHION))
        assertTrue(variants.contains(WgcLoginVariant.WAVE))
        assertTrue(variants.contains(WgcLoginVariant.SPLIT_CARD))
        assertTrue(variants.contains(WgcLoginVariant.CLOCK))

        val foodVariant = WgcLoginVariant.FOOD_DELIVERY
        assertEquals("Food Delivery", foodVariant.displayName)
        assertNotNull(foodVariant.primaryColor)
    }

    @Test
    fun `WgcAuthVariant should map to login variant`() {
        WgcAuthVariant.entries.forEach { authVariant ->
            assertNotNull(authVariant.toLoginVariant())
        }
    }

    @Test
    fun `WgcAuthStep should have all core authentication states`() {
        val steps = WgcAuthStep.entries
        assertEquals(4, steps.size)
        assertTrue(steps.contains(WgcAuthStep.Login))
        assertTrue(steps.contains(WgcAuthStep.Register))
        assertTrue(steps.contains(WgcAuthStep.ResetPassword))
        assertTrue(steps.contains(WgcAuthStep.Otp))
    }

    @Test
    fun `WgcSavedAddressItem should hold valid address properties`() {
        val item = WgcSavedAddressItem(
            id = "addr-1",
            title = "Casa",
            street = "Avenida Paulista",
            number = "1000",
            city = "São Paulo",
            state = "SP",
            zipCode = "01310-100",
            isDefault = true
        )
        assertEquals("addr-1", item.id)
        assertEquals("Casa", item.title)
        assertTrue(item.isDefault)
    }

    @Test
    fun `Subject variants should match expected entries`() {
        assertTrue(WgcBiometricsVariant.entries.contains(WgcBiometricsVariant.FINGERPRINT))
        assertTrue(WgcCartVariant.entries.contains(WgcCartVariant.STANDARD))
        assertTrue(WgcCheckoutVariant.entries.contains(WgcCheckoutVariant.STANDARD))
        assertTrue(WgcPaymentMethodVariant.entries.contains(WgcPaymentMethodVariant.CREDIT_CARD))
        assertTrue(WgcPixScreenVariant.entries.contains(WgcPixScreenVariant.STANDARD))
        assertTrue(WgcHomeVariant.entries.contains(WgcHomeVariant.FINTECH))
        assertTrue(WgcOnboardingVariant.entries.contains(WgcOnboardingVariant.STANDARD))
        assertTrue(WgcProfileVariant.entries.contains(WgcProfileVariant.STANDARD))
        assertTrue(WgcSearchVariant.entries.contains(WgcSearchVariant.STANDARD))
        assertTrue(WgcProductDetailVariant.entries.contains(WgcProductDetailVariant.STANDARD))
        assertTrue(WgcNotificationVariant.entries.contains(WgcNotificationVariant.STANDARD))
        assertTrue(WgcSettingsVariant.entries.contains(WgcSettingsVariant.STANDARD))
        assertTrue(WgcSecurityVariant.entries.contains(WgcSecurityVariant.STANDARD))
        assertTrue(WgcStatementVariant.entries.contains(WgcStatementVariant.STANDARD))
        assertTrue(WgcHelpCenterVariant.entries.contains(WgcHelpCenterVariant.STANDARD))
        assertTrue(WgcReviewVariant.entries.contains(WgcReviewVariant.STANDARD))
        assertTrue(WgcErrorVariant.entries.contains(WgcErrorVariant.GENERIC_ERROR))
    }

    @Test
    fun `Coordinators steps and tabs should be valid`() {
        assertTrue(WgcCartFlowStep.entries.contains(WgcCartFlowStep.Cart))
        assertTrue(WgcPaymentFlowStep.entries.contains(WgcPaymentFlowStep.MethodSelection))
        assertTrue(WgcAddressFlowStep.entries.contains(WgcAddressFlowStep.Selection))
        assertTrue(WgcCheckoutFlowStep.entries.contains(WgcCheckoutFlowStep.Review))
        assertTrue(WgcHomeTab.entries.contains(WgcHomeTab.Feed))
    }

    @Test
    fun `WgcDynamicFlowDefaults should provide valid sequential flow steps`() {
        val steps = WgcDynamicFlowDefaults.defaultSteps()
        assertTrue(steps.size >= 2)
        assertEquals("step_welcome", steps[0].id)
        assertEquals("step_confirm", steps[1].id)
        assertNotNull(steps[0].content)
        assertNotNull(steps[1].content)
    }

    @Test
    fun `WgcCompositeFlowDefaults should provide valid multi-domain sub-flows`() {
        val flows = WgcCompositeFlowDefaults.defaultFlows()
        assertTrue(flows.size >= 3)
        assertEquals("auth", flows[0].id)
        assertEquals("onboarding", flows[1].id)
        assertEquals("home", flows[2].id)
        assertNotNull(flows[0].content)
        assertNotNull(flows[1].content)
        assertNotNull(flows[2].content)
    }

    @Test
    fun `WgcFlowStep should hold custom properties correctly`() {
        val step = WgcFlowStep(
            id = "custom_step",
            title = "Etapa Personalizada",
            canSkip = true
        ) { _, _ -> }
        assertEquals("custom_step", step.id)
        assertEquals("Etapa Personalizada", step.title)
        assertTrue(step.canSkip)
    }

    @Test
    fun `WgcSubFlow should hold custom properties correctly`() {
        val subFlow = WgcSubFlow(
            id = "custom_flow",
            title = "Jornada Personalizada"
        ) { _, _ -> }
        assertEquals("custom_flow", subFlow.id)
        assertEquals("Jornada Personalizada", subFlow.title)
    }
}

