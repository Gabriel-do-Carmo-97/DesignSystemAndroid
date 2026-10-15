package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcQuickShopFactory
import br.com.wgc.design_system.templates.factories.WgcQuickShopScreen
import br.com.wgc.design_system.factories.verticals.quickshop.templates.checkout.WgcShopEaseCheckoutTemplate
import br.com.wgc.design_system.factories.verticals.quickshop.templates.detail.WgcShopEaseProductDetailTemplate
import br.com.wgc.design_system.factories.verticals.quickshop.templates.favorites.WgcShopEaseFavoritesTemplate
import br.com.wgc.design_system.factories.verticals.quickshop.templates.home.WgcShopEaseHomeTemplate
import br.com.wgc.design_system.factories.verticals.quickshop.templates.onboarding.WgcShopEaseOnboardingTemplate
import br.com.wgc.design_system.factories.verticals.quickshop.templates.profile.WgcShopEaseProfileTemplate

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
