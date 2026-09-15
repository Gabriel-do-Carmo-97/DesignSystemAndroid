package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.shopease.checkout.WgcShopEaseCheckoutTemplate
import br.com.wgc.ds_templates.screens.shopease.detail.WgcShopEaseProductDetailTemplate
import br.com.wgc.ds_templates.screens.shopease.favorites.WgcShopEaseFavoritesTemplate
import br.com.wgc.ds_templates.screens.shopease.home.WgcShopEaseHomeTemplate
import br.com.wgc.ds_templates.screens.shopease.model.ShopEaseMockData
import br.com.wgc.ds_templates.screens.shopease.model.ShopEaseProduct
import br.com.wgc.ds_templates.screens.shopease.onboarding.WgcShopEaseOnboardingTemplate
import br.com.wgc.ds_templates.screens.shopease.profile.WgcShopEaseProfileTemplate

/**
 * Telas disponíveis para renderização na [WgcShopEaseFactory].
 */
enum class WgcShopEaseScreen {
    Onboarding,
    Home,
    ProductDetail,
    Checkout,
    Favorites,
    Profile
}

/**
 * Fábrica Universal de Telas do ShopEase (Sunset Orange eCommerce UI Kit).
 * Expõe ponto de entrada único com defaults sensatos e slots de customização granulares.
 */
@Composable
fun WgcShopEaseFactory(
    screen: WgcShopEaseScreen = WgcShopEaseScreen.Home,
    selectedProduct: ShopEaseProduct = ShopEaseMockData.products[0],
    onNavigateToHome: () -> Unit = {},
    onNavigateToDetail: (ShopEaseProduct) -> Unit = {},
    onNavigateToCheckout: () -> Unit = {},
    onNavigateToFavorites: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {},
    onBackClick: () -> Unit = {},
    customContentSlot: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    if (customContentSlot != null) {
        customContentSlot()
        return
    }

    when (screen) {
        WgcShopEaseScreen.Onboarding -> {
            WgcShopEaseOnboardingTemplate(
                onNextClick = onNavigateToHome,
                modifier = modifier
            )
        }
        WgcShopEaseScreen.Home -> {
            WgcShopEaseHomeTemplate(
                onProductClick = onNavigateToDetail,
                onCartClick = onNavigateToCheckout,
                modifier = modifier
            )
        }
        WgcShopEaseScreen.ProductDetail -> {
            WgcShopEaseProductDetailTemplate(
                product = selectedProduct,
                onBackClick = onBackClick,
                onAddToCartClick = onNavigateToCheckout,
                onBuyNowClick = onNavigateToCheckout,
                modifier = modifier
            )
        }
        WgcShopEaseScreen.Checkout -> {
            WgcShopEaseCheckoutTemplate(
                onBackClick = onBackClick,
                onConfirmOrderClick = { /* confirm */ },
                modifier = modifier
            )
        }
        WgcShopEaseScreen.Favorites -> {
            WgcShopEaseFavoritesTemplate(
                onProductClick = onNavigateToDetail,
                onBackClick = onBackClick,
                modifier = modifier
            )
        }
        WgcShopEaseScreen.Profile -> {
            WgcShopEaseProfileTemplate(
                modifier = modifier
            )
        }
    }
}
