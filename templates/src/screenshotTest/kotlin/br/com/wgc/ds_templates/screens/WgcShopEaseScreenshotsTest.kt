package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcQuickShopFactory
import br.com.wgc.ds_templates.factories.WgcQuickShopScreen
import br.com.wgc.ds_templates.screens.quickshop.checkout.WgcShopEaseCheckoutTemplate
import br.com.wgc.ds_templates.screens.quickshop.detail.WgcShopEaseProductDetailTemplate
import br.com.wgc.ds_templates.screens.quickshop.favorites.WgcShopEaseFavoritesTemplate
import br.com.wgc.ds_templates.screens.quickshop.home.WgcShopEaseHomeTemplate
import br.com.wgc.ds_templates.screens.quickshop.onboarding.WgcShopEaseOnboardingTemplate
import br.com.wgc.ds_templates.screens.quickshop.profile.WgcShopEaseProfileTemplate

class WgcShopEaseScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun previewShopEaseOnboarding() {
        WgcShopEaseOnboardingTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewShopEaseHome() {
        WgcShopEaseHomeTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewShopEaseDetail() {
        WgcShopEaseProductDetailTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewShopEaseCheckout() {
        WgcShopEaseCheckoutTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewShopEaseFavorites() {
        WgcShopEaseFavoritesTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewShopEaseProfile() {
        WgcShopEaseProfileTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewShopEaseFactory() {
        WgcQuickShopFactory(screen = WgcQuickShopScreen.Home)
    }
}
