package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.cart.WgcCartScreenFactory
import br.com.wgc.design_system.factories.cart.WgcCartVariant
import br.com.wgc.design_system.factories.checkout.WgcCheckoutScreenFactory
import br.com.wgc.design_system.factories.checkout.WgcCheckoutVariant
import br.com.wgc.design_system.factories.onboarding.WgcOnboardingScreenFactory
import br.com.wgc.design_system.factories.onboarding.WgcOnboardingVariant
import com.android.tools.screenshot.PreviewTest

class WgcFactoriesScreenshotTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Checkout Factory Standard")
    @Composable
    private fun CheckoutFactoryStandardPreview() {
        WgcCheckoutScreenFactory(variant = WgcCheckoutVariant.STANDARD)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Checkout Factory Gadget Shop")
    @Composable
    private fun CheckoutFactoryGadgetShopPreview() {
        WgcCheckoutScreenFactory(variant = WgcCheckoutVariant.GADGET_SHOP)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Onboarding Factory Standard")
    @Composable
    private fun OnboardingFactoryStandardPreview() {
        WgcOnboardingScreenFactory(variant = WgcOnboardingVariant.STANDARD)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Onboarding Factory Boutique")
    @Composable
    private fun OnboardingFactoryBoutiquePreview() {
        WgcOnboardingScreenFactory(variant = WgcOnboardingVariant.TREND_FASHION)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Cart Factory Standard")
    @Composable
    private fun CartFactoryStandardPreview() {
        WgcCartScreenFactory(variant = WgcCartVariant.STANDARD)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Cart Factory Fresh Grocery")
    @Composable
    private fun CartFactoryFreshGroceryPreview() {
        WgcCartScreenFactory(variant = WgcCartVariant.FRESH_GROCERY)
    }
}
