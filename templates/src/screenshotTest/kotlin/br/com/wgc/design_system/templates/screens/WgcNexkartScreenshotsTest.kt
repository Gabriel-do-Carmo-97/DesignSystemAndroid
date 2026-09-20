package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcGadgetShopFactory
import br.com.wgc.design_system.templates.factories.WgcGadgetShopScreen
import com.android.tools.screenshot.PreviewTest

class WgcNexkartScreenshotsTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Onboarding Screen")
    @Composable
    private fun NexkartOnboardingScreenPreview() {
        WgcGadgetShopFactory(screen = WgcGadgetShopScreen.Onboarding)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Home Screen")
    @Composable
    private fun NexkartHomeScreenPreview() {
        WgcGadgetShopFactory(screen = WgcGadgetShopScreen.Home)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Product Detail Screen")
    @Composable
    private fun NexkartProductDetailScreenPreview() {
        WgcGadgetShopFactory(screen = WgcGadgetShopScreen.ProductDetail)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Product List Screen")
    @Composable
    private fun NexkartProductListScreenPreview() {
        WgcGadgetShopFactory(screen = WgcGadgetShopScreen.ProductList)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Cart Screen")
    @Composable
    private fun NexkartCartScreenPreview() {
        WgcGadgetShopFactory(screen = WgcGadgetShopScreen.Cart)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Checkout Screen")
    @Composable
    private fun NexkartCheckoutScreenPreview() {
        WgcGadgetShopFactory(screen = WgcGadgetShopScreen.Checkout)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Order Success Screen")
    @Composable
    private fun NexkartOrderSuccessScreenPreview() {
        WgcGadgetShopFactory(screen = WgcGadgetShopScreen.OrderSuccess)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Profile Screen")
    @Composable
    private fun NexkartProfileScreenPreview() {
        WgcGadgetShopFactory(screen = WgcGadgetShopScreen.Profile)
    }
}
