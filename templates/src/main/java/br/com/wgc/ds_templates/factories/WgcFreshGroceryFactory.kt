package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.freshgrocery.cart.WgcShopperCartTemplate
import br.com.wgc.ds_templates.screens.freshgrocery.detail.WgcShopperProductDetailTemplate
import br.com.wgc.ds_templates.screens.freshgrocery.home.WgcShopperHomeTemplate
import br.com.wgc.ds_templates.screens.freshgrocery.model.FreshGroceryMockData
import br.com.wgc.ds_templates.screens.freshgrocery.model.ShopperProduct
import br.com.wgc.ds_templates.screens.freshgrocery.profile.WgcShopperProfileTemplate
import br.com.wgc.ds_templates.screens.freshgrocery.splash.WgcShopperSplashTemplate

/**
 * Telas disponíveis para renderização na [WgcFreshGroceryFactory].
 */
enum class WgcFreshGroceryScreen {
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
fun WgcFreshGroceryFactory(
    screen: WgcFreshGroceryScreen = WgcFreshGroceryScreen.Home,
    selectedProduct: ShopperProduct = FreshGroceryMockData.products[0],
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
        WgcFreshGroceryScreen.Splash -> {
            WgcShopperSplashTemplate(
                onGetStartedClick = onNavigateToHome,
                modifier = modifier
            )
        }
        WgcFreshGroceryScreen.Home -> {
            WgcShopperHomeTemplate(
                onProductClick = onNavigateToDetail,
                onCartClick = onNavigateToCart,
                modifier = modifier
            )
        }
        WgcFreshGroceryScreen.ProductDetail -> {
            WgcShopperProductDetailTemplate(
                product = selectedProduct,
                onBackClick = onBackClick,
                onAddToCartClick = onNavigateToCart,
                modifier = modifier
            )
        }
        WgcFreshGroceryScreen.Cart -> {
            WgcShopperCartTemplate(
                onBackClick = onBackClick,
                onCheckoutClick = { /* checkout */ },
                modifier = modifier
            )
        }
        WgcFreshGroceryScreen.Profile -> {
            WgcShopperProfileTemplate(
                modifier = modifier
            )
        }
    }
}
