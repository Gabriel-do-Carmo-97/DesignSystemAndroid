package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.quickshop.checkout.WgcShopEaseCheckoutTemplate
import br.com.wgc.design_system.templates.screens.quickshop.detail.WgcShopEaseProductDetailTemplate
import br.com.wgc.design_system.templates.screens.quickshop.favorites.WgcShopEaseFavoritesTemplate
import br.com.wgc.design_system.templates.screens.quickshop.home.WgcShopEaseHomeTemplate
import br.com.wgc.design_system.templates.screens.quickshop.model.ShopEaseMockData
import br.com.wgc.design_system.templates.screens.quickshop.model.ShopEaseProduct
import br.com.wgc.design_system.templates.screens.quickshop.onboarding.WgcShopEaseOnboardingTemplate
import br.com.wgc.design_system.templates.screens.quickshop.profile.WgcShopEaseProfileTemplate

/**
 * Telas disponíveis para renderização na [WgcQuickShopFactory].
 */
enum class WgcQuickShopScreen {
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
fun WgcQuickShopFactory(
    screen: WgcQuickShopScreen = WgcQuickShopScreen.Home,
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
        WgcQuickShopScreen.Onboarding -> {
            WgcShopEaseOnboardingTemplate(
                onNextClick = onNavigateToHome,
                modifier = modifier
            )
        }
        WgcQuickShopScreen.Home -> {
            WgcShopEaseHomeTemplate(
                onProductClick = onNavigateToDetail,
                onCartClick = onNavigateToCheckout,
                modifier = modifier
            )
        }
        WgcQuickShopScreen.ProductDetail -> {
            WgcShopEaseProductDetailTemplate(
                product = selectedProduct,
                onBackClick = onBackClick,
                onAddToCartClick = onNavigateToCheckout,
                onBuyNowClick = onNavigateToCheckout,
                modifier = modifier
            )
        }
        WgcQuickShopScreen.Checkout -> {
            WgcShopEaseCheckoutTemplate(
                onBackClick = onBackClick,
                onConfirmOrderClick = { /* confirm */ },
                modifier = modifier
            )
        }
        WgcQuickShopScreen.Favorites -> {
            WgcShopEaseFavoritesTemplate(
                onProductClick = onNavigateToDetail,
                onBackClick = onBackClick,
                modifier = modifier
            )
        }
        WgcQuickShopScreen.Profile -> {
            WgcShopEaseProfileTemplate(
                modifier = modifier
            )
        }
    }
}
