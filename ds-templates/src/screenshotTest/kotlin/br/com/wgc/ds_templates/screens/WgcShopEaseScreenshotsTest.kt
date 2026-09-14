package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcShopEaseFactory
import br.com.wgc.ds_templates.factories.WgcShopEaseScreen
import br.com.wgc.ds_templates.screens.shopease.checkout.WgcShopEaseCheckoutTemplate
import br.com.wgc.ds_templates.screens.shopease.detail.WgcShopEaseProductDetailTemplate
import br.com.wgc.ds_templates.screens.shopease.favorites.WgcShopEaseFavoritesTemplate
import br.com.wgc.ds_templates.screens.shopease.home.WgcShopEaseHomeTemplate
import br.com.wgc.ds_templates.screens.shopease.onboarding.WgcShopEaseOnboardingTemplate
import br.com.wgc.ds_templates.screens.shopease.profile.WgcShopEaseProfileTemplate

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
        WgcShopEaseFactory(screen = WgcShopEaseScreen.Home)
    }
}
