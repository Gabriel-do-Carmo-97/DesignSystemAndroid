package br.com.wgc.design_system.factories.verticals.freshgrocery

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.cart.WgcFreshGroceryCartTemplate
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.detail.WgcFreshGroceryProductDetailTemplate
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.home.WgcFreshGroceryHomeTemplate
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.model.FreshGroceryMockData
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.model.FreshGroceryProductItem
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.profile.WgcFreshGroceryProfileTemplate
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.splash.WgcFreshGrocerySplashTemplate

/**
 * Telas disponÃ­veis para renderizaÃ§Ã£o na [WgcFreshGroceryFactory].
 */
enum class WgcFreshGroceryScreen {
    Splash,
    Home,
    ProductDetail,
    Cart,
    Profile
}

/**
 * FÃ¡brica Universal de Telas do Fresh Grocery (Modern Emerald Green Ecommerce).
 * ExpÃµe ponto de entrada Ãºnico com defaults sensatos e slots de customizaÃ§Ã£o granulares.
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
