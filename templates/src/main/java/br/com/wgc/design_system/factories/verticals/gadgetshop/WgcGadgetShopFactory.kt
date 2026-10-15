package br.com.wgc.design_system.factories.verticals.gadgetshop

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.cart.WgcNexkartCartTemplate
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.checkout.WgcNexkartCheckoutTemplate
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.checkout.WgcNexkartOrderSuccessTemplate
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.home.WgcNexkartHomeTemplate
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.model.GadgetShopMockData
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.model.NexkartProduct
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.onboarding.WgcNexkartOnboardingTemplate
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.product.WgcNexkartProductDetailTemplate
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.product.WgcNexkartProductListTemplate
import br.com.wgc.design_system.factories.verticals.gadgetshop.templates.profile.WgcNexkartProfileTemplate

/**
 * Telas suportadas pela fÃ¡brica unificada Nexkart.
 */
enum class WgcGadgetShopScreen {
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
 * FÃ¡brica Universal do Ecossistema Nexkart (WgcGadgetShopFactory).
 * ProvÃª renderizaÃ§Ã£o instantÃ¢nea de qualquer tela da suÃ­te com sensible defaults e slots de customizaÃ§Ã£o.
 */
@Composable
fun WgcGadgetShopFactory(
    screen: WgcGadgetShopScreen = WgcGadgetShopScreen.Home,
    modifier: Modifier = Modifier,
    selectedProduct: NexkartProduct = GadgetShopMockData.products[0],
    onNavigateToScreen: (WgcGadgetShopScreen) -> Unit = {},
    customSlot: (@Composable () -> Unit)? = null
) {
    if (customSlot != null) {
        customSlot()
        return
    }

    when (screen) {
        WgcGadgetShopScreen.Onboarding -> {
            WgcNexkartOnboardingTemplate(
                modifier = modifier,
                onNextClick = { onNavigateToScreen(WgcGadgetShopScreen.Home) }
            )
        }
        WgcGadgetShopScreen.Home -> {
            WgcNexkartHomeTemplate(
                modifier = modifier,
                onProductClick = { onNavigateToScreen(WgcGadgetShopScreen.ProductDetail) },
                onViewAllDiscountsClick = { onNavigateToScreen(WgcGadgetShopScreen.ProductList) },
                onCategoryClick = { onNavigateToScreen(WgcGadgetShopScreen.ProductList) },
                onNavItemSelected = { index ->
                    when (index) {
                        0 -> onNavigateToScreen(WgcGadgetShopScreen.Home)
                        1 -> onNavigateToScreen(WgcGadgetShopScreen.ProductList)
                        2 -> onNavigateToScreen(WgcGadgetShopScreen.Cart)
                        3 -> onNavigateToScreen(WgcGadgetShopScreen.Profile)
                    }
                }
            )
        }
        WgcGadgetShopScreen.ProductDetail -> {
            WgcNexkartProductDetailTemplate(
                modifier = modifier,
                product = selectedProduct,
                onAddToCart = { onNavigateToScreen(WgcGadgetShopScreen.Cart) },
                onBackClick = { onNavigateToScreen(WgcGadgetShopScreen.Home) }
            )
        }
        WgcGadgetShopScreen.ProductList -> {
            WgcNexkartProductListTemplate(
                modifier = modifier,
                onProductClick = { onNavigateToScreen(WgcGadgetShopScreen.ProductDetail) },
                onBackClick = { onNavigateToScreen(WgcGadgetShopScreen.Home) }
            )
        }
        WgcGadgetShopScreen.Cart -> {
            WgcNexkartCartTemplate(
                modifier = modifier,
                onCheckoutClick = { onNavigateToScreen(WgcGadgetShopScreen.Checkout) },
                onBackClick = { onNavigateToScreen(WgcGadgetShopScreen.Home) }
            )
        }
        WgcGadgetShopScreen.Checkout -> {
            WgcNexkartCheckoutTemplate(
                modifier = modifier,
                onConfirmOrderClick = { onNavigateToScreen(WgcGadgetShopScreen.OrderSuccess) },
                onBackClick = { onNavigateToScreen(WgcGadgetShopScreen.Cart) }
            )
        }
        WgcGadgetShopScreen.OrderSuccess -> {
            WgcNexkartOrderSuccessTemplate(
                modifier = modifier,
                onTrackOrderClick = { onNavigateToScreen(WgcGadgetShopScreen.Profile) },
                onContinueShoppingClick = { onNavigateToScreen(WgcGadgetShopScreen.Home) }
            )
        }
        WgcGadgetShopScreen.Profile -> {
            WgcNexkartProfileTemplate(
                modifier = modifier,
                onOrdersClick = { onNavigateToScreen(WgcGadgetShopScreen.Home) },
                onWishlistClick = { onNavigateToScreen(WgcGadgetShopScreen.ProductList) },
                onSignOutClick = { onNavigateToScreen(WgcGadgetShopScreen.Onboarding) },
                onNavItemSelected = { index ->
                    when (index) {
                        0 -> onNavigateToScreen(WgcGadgetShopScreen.Home)
                        1 -> onNavigateToScreen(WgcGadgetShopScreen.ProductList)
                        2 -> onNavigateToScreen(WgcGadgetShopScreen.Cart)
                        3 -> onNavigateToScreen(WgcGadgetShopScreen.Profile)
                    }
                }
            )
        }
    }
}
