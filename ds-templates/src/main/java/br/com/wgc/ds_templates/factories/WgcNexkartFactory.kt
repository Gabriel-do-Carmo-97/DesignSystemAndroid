package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.nexkart.cart.WgcNexkartCartTemplate
import br.com.wgc.ds_templates.screens.nexkart.checkout.WgcNexkartCheckoutTemplate
import br.com.wgc.ds_templates.screens.nexkart.checkout.WgcNexkartOrderSuccessTemplate
import br.com.wgc.ds_templates.screens.nexkart.home.WgcNexkartHomeTemplate
import br.com.wgc.ds_templates.screens.nexkart.model.NexkartMockData
import br.com.wgc.ds_templates.screens.nexkart.model.NexkartProduct
import br.com.wgc.ds_templates.screens.nexkart.onboarding.WgcNexkartOnboardingTemplate
import br.com.wgc.ds_templates.screens.nexkart.product.WgcNexkartProductDetailTemplate
import br.com.wgc.ds_templates.screens.nexkart.product.WgcNexkartProductListTemplate
import br.com.wgc.ds_templates.screens.nexkart.profile.WgcNexkartProfileTemplate

/**
 * Telas suportadas pela fábrica unificada Nexkart.
 */
enum class WgcNexkartScreen {
    Onboarding,
    Home,
    ProductDetail,
    ProductList,
    Cart,
    Checkout,
    OrderSuccess,
    Profile
}

/**
 * Fábrica Universal do Ecossistema Nexkart (WgcNexkartFactory).
 * Provê renderização instantânea de qualquer tela da suíte com sensible defaults e slots de customização.
 */
@Composable
fun WgcNexkartFactory(
    screen: WgcNexkartScreen = WgcNexkartScreen.Home,
    modifier: Modifier = Modifier,
    selectedProduct: NexkartProduct = NexkartMockData.products[0],
    onNavigateToScreen: (WgcNexkartScreen) -> Unit = {},
    customSlot: (@Composable () -> Unit)? = null
) {
    if (customSlot != null) {
        customSlot()
        return
    }

    when (screen) {
        WgcNexkartScreen.Onboarding -> {
            WgcNexkartOnboardingTemplate(
                modifier = modifier,
                onNextClick = { onNavigateToScreen(WgcNexkartScreen.Home) }
            )
        }
        WgcNexkartScreen.Home -> {
            WgcNexkartHomeTemplate(
                modifier = modifier,
                onProductClick = { onNavigateToScreen(WgcNexkartScreen.ProductDetail) },
                onViewAllDiscountsClick = { onNavigateToScreen(WgcNexkartScreen.ProductList) },
                onCategoryClick = { onNavigateToScreen(WgcNexkartScreen.ProductList) },
                onNavItemSelected = { index ->
                    when (index) {
                        0 -> onNavigateToScreen(WgcNexkartScreen.Home)
                        1 -> onNavigateToScreen(WgcNexkartScreen.ProductList)
                        2 -> onNavigateToScreen(WgcNexkartScreen.Cart)
                        3 -> onNavigateToScreen(WgcNexkartScreen.Profile)
                    }
                }
            )
        }
        WgcNexkartScreen.ProductDetail -> {
            WgcNexkartProductDetailTemplate(
                modifier = modifier,
                product = selectedProduct,
                onAddToCart = { onNavigateToScreen(WgcNexkartScreen.Cart) },
                onBackClick = { onNavigateToScreen(WgcNexkartScreen.Home) }
            )
        }
        WgcNexkartScreen.ProductList -> {
            WgcNexkartProductListTemplate(
                modifier = modifier,
                onProductClick = { onNavigateToScreen(WgcNexkartScreen.ProductDetail) },
                onBackClick = { onNavigateToScreen(WgcNexkartScreen.Home) }
            )
        }
        WgcNexkartScreen.Cart -> {
            WgcNexkartCartTemplate(
                modifier = modifier,
                onCheckoutClick = { onNavigateToScreen(WgcNexkartScreen.Checkout) },
                onBackClick = { onNavigateToScreen(WgcNexkartScreen.Home) }
            )
        }
        WgcNexkartScreen.Checkout -> {
            WgcNexkartCheckoutTemplate(
                modifier = modifier,
                onConfirmOrderClick = { onNavigateToScreen(WgcNexkartScreen.OrderSuccess) },
                onBackClick = { onNavigateToScreen(WgcNexkartScreen.Cart) }
            )
        }
        WgcNexkartScreen.OrderSuccess -> {
            WgcNexkartOrderSuccessTemplate(
                modifier = modifier,
                onTrackOrderClick = { onNavigateToScreen(WgcNexkartScreen.Profile) },
                onContinueShoppingClick = { onNavigateToScreen(WgcNexkartScreen.Home) }
            )
        }
        WgcNexkartScreen.Profile -> {
            WgcNexkartProfileTemplate(
                modifier = modifier,
                onOrdersClick = { onNavigateToScreen(WgcNexkartScreen.Home) },
                onWishlistClick = { onNavigateToScreen(WgcNexkartScreen.ProductList) },
                onSignOutClick = { onNavigateToScreen(WgcNexkartScreen.Onboarding) },
                onNavItemSelected = { index ->
                    when (index) {
                        0 -> onNavigateToScreen(WgcNexkartScreen.Home)
                        1 -> onNavigateToScreen(WgcNexkartScreen.ProductList)
                        2 -> onNavigateToScreen(WgcNexkartScreen.Cart)
                        3 -> onNavigateToScreen(WgcNexkartScreen.Profile)
                    }
                }
            )
        }
    }
}
