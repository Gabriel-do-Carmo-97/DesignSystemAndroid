package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.shopper.cart.WgcShopperCartTemplate
import br.com.wgc.ds_templates.screens.shopper.detail.WgcShopperProductDetailTemplate
import br.com.wgc.ds_templates.screens.shopper.home.WgcShopperHomeTemplate
import br.com.wgc.ds_templates.screens.shopper.model.ShopperMockData
import br.com.wgc.ds_templates.screens.shopper.model.ShopperProduct
import br.com.wgc.ds_templates.screens.shopper.profile.WgcShopperProfileTemplate
import br.com.wgc.ds_templates.screens.shopper.splash.WgcShopperSplashTemplate

/**
 * Telas disponíveis para renderização na [WgcShopperFactory].
 */
enum class WgcShopperScreen {
    Splash,
    Home,
    ProductDetail,
    Cart,
    Profile
}

/**
 * Fábrica Universal de Telas do Shopper (Modern Emerald Green Ecommerce).
 * Expõe ponto de entrada único com defaults sensatos e slots de customização granulares.
 */
@Composable
fun WgcShopperFactory(
    screen: WgcShopperScreen = WgcShopperScreen.Home,
    selectedProduct: ShopperProduct = ShopperMockData.products[0],
    onNavigateToHome: () -> Unit = {},
    onNavigateToDetail: (ShopperProduct) -> Unit = {},
    onNavigateToCart: () -> Unit = {},
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
        WgcShopperScreen.Splash -> {
            WgcShopperSplashTemplate(
                onGetStartedClick = onNavigateToHome,
                modifier = modifier
            )
        }
        WgcShopperScreen.Home -> {
            WgcShopperHomeTemplate(
                onProductClick = onNavigateToDetail,
                onCartClick = onNavigateToCart,
                modifier = modifier
            )
        }
        WgcShopperScreen.ProductDetail -> {
            WgcShopperProductDetailTemplate(
                product = selectedProduct,
                onBackClick = onBackClick,
                onAddToCartClick = onNavigateToCart,
                modifier = modifier
            )
        }
        WgcShopperScreen.Cart -> {
            WgcShopperCartTemplate(
                onBackClick = onBackClick,
                onCheckoutClick = { /* checkout */ },
                modifier = modifier
            )
        }
        WgcShopperScreen.Profile -> {
            WgcShopperProfileTemplate(
                modifier = modifier
            )
        }
    }
}
