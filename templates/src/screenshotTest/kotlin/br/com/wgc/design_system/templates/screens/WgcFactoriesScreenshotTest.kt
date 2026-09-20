package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcCartFactory
import br.com.wgc.design_system.templates.factories.WgcCartType
import br.com.wgc.design_system.templates.factories.WgcCheckoutFactory
import br.com.wgc.design_system.templates.factories.WgcCheckoutType
import br.com.wgc.design_system.templates.factories.WgcOnboardingFactory
import br.com.wgc.design_system.templates.factories.WgcOnboardingType
import com.android.tools.screenshot.PreviewTest

class WgcFactoriesScreenshotTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Checkout Factory Standard")
    @Composable
    private fun CheckoutFactoryStandardPreview() {
        WgcCheckoutFactory(type = WgcCheckoutType.STANDARD)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Checkout Factory Gadget Shop")
    @Composable
    private fun CheckoutFactoryGadgetShopPreview() {
        WgcCheckoutFactory(type = WgcCheckoutType.GADGET_SHOP)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Onboarding Factory Standard")
    @Composable
    private fun OnboardingFactoryStandardPreview() {
        WgcOnboardingFactory(type = WgcOnboardingType.STANDARD)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Onboarding Factory Boutique")
    @Composable
    private fun OnboardingFactoryBoutiquePreview() {
        WgcOnboardingFactory(type = WgcOnboardingType.BOUTIQUE)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Cart Factory Standard")
    @Composable
    private fun CartFactoryStandardPreview() {
        WgcCartFactory(type = WgcCartType.STANDARD)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Cart Factory Fresh Grocery")
    @Composable
    private fun CartFactoryFreshGroceryPreview() {
        WgcCartFactory(type = WgcCartType.FRESH_GROCERY)
    }
}
