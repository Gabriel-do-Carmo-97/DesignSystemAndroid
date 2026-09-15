package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcNexkartFactory
import br.com.wgc.ds_templates.factories.WgcNexkartScreen
import com.android.tools.screenshot.PreviewTest

class WgcNexkartScreenshotsTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Onboarding Screen")
    @Composable
    private fun NexkartOnboardingScreenPreview() {
        WgcNexkartFactory(screen = WgcNexkartScreen.Onboarding)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Home Screen")
    @Composable
    private fun NexkartHomeScreenPreview() {
        WgcNexkartFactory(screen = WgcNexkartScreen.Home)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Product Detail Screen")
    @Composable
    private fun NexkartProductDetailScreenPreview() {
        WgcNexkartFactory(screen = WgcNexkartScreen.ProductDetail)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Product List Screen")
    @Composable
    private fun NexkartProductListScreenPreview() {
        WgcNexkartFactory(screen = WgcNexkartScreen.ProductList)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Cart Screen")
    @Composable
    private fun NexkartCartScreenPreview() {
        WgcNexkartFactory(screen = WgcNexkartScreen.Cart)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Checkout Screen")
    @Composable
    private fun NexkartCheckoutScreenPreview() {
        WgcNexkartFactory(screen = WgcNexkartScreen.Checkout)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Order Success Screen")
    @Composable
    private fun NexkartOrderSuccessScreenPreview() {
        WgcNexkartFactory(screen = WgcNexkartScreen.OrderSuccess)
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Nexkart Profile Screen")
    @Composable
    private fun NexkartProfileScreenPreview() {
        WgcNexkartFactory(screen = WgcNexkartScreen.Profile)
    }
}
