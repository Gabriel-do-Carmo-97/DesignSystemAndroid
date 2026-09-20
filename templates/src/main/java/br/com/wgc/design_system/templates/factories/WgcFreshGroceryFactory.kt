package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.freshgrocery.cart.WgcFreshGroceryCartTemplate
import br.com.wgc.design_system.templates.screens.freshgrocery.detail.WgcFreshGroceryProductDetailTemplate
import br.com.wgc.design_system.templates.screens.freshgrocery.home.WgcFreshGroceryHomeTemplate
import br.com.wgc.design_system.templates.screens.freshgrocery.model.FreshGroceryMockData
import br.com.wgc.design_system.templates.screens.freshgrocery.model.FreshGroceryProductItem
import br.com.wgc.design_system.templates.screens.freshgrocery.profile.WgcFreshGroceryProfileTemplate
import br.com.wgc.design_system.templates.screens.freshgrocery.splash.WgcFreshGrocerySplashTemplate

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
 * Fábrica Universal de Telas do Fresh Grocery (Modern Emerald Green Ecommerce).
 * Expõe ponto de entrada único com defaults sensatos e slots de customização granulares.
 */
@Composable
fun WgcFreshGroceryFactory(
    screen: WgcFreshGroceryScreen = WgcFreshGroceryScreen.Home,
    selectedProduct: FreshGroceryProductItem = FreshGroceryMockData.products[0],
    onNavigateToHome: () -> Unit = {},
    onNavigateToDetail: (FreshGroceryProductItem) -> Unit = {},
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
            WgcFreshGrocerySplashTemplate(
                onGetStartedClick = onNavigateToHome,
                modifier = modifier
            )
        }
        WgcFreshGroceryScreen.Home -> {
            WgcFreshGroceryHomeTemplate(
                onProductClick = onNavigateToDetail,
                onCartClick = onNavigateToCart,
                modifier = modifier
            )
        }
        WgcFreshGroceryScreen.ProductDetail -> {
            WgcFreshGroceryProductDetailTemplate(
                product = selectedProduct,
                onBackClick = onBackClick,
                onAddToCartClick = onNavigateToCart,
                modifier = modifier
            )
        }
        WgcFreshGroceryScreen.Cart -> {
            WgcFreshGroceryCartTemplate(
                onBackClick = onBackClick,
                onCheckoutClick = { /* checkout */ },
                modifier = modifier
            )
        }
        WgcFreshGroceryScreen.Profile -> {
            WgcFreshGroceryProfileTemplate(
                modifier = modifier
            )
        }
    }
}
