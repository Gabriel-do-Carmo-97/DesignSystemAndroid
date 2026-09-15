package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.tassel.cart.WgcTasselCartTemplate
import br.com.wgc.ds_templates.screens.tassel.featured.WgcTasselFeaturedTemplate
import br.com.wgc.ds_templates.screens.tassel.market.WgcTasselMarketTemplate
import br.com.wgc.ds_templates.screens.tassel.model.TasselMockData
import br.com.wgc.ds_templates.screens.tassel.model.TasselProduct
import br.com.wgc.ds_templates.screens.tassel.product.WgcTasselProductDetailTemplate
import br.com.wgc.ds_templates.screens.tassel.profile.WgcTasselProfileTemplate
import br.com.wgc.ds_templates.screens.tassel.tracking.WgcTasselOrderTrackingTemplate

/**
 * Telas suportadas pela fábrica unificada Tassel.
 */
enum class WgcTasselScreen {
    Market,
    Featured,
    ProductDetail,
    OrderTracking,
    Profile,
    Cart
}

/**
 * Fábrica Universal do Ecossistema Tassel (WgcTasselFactory).
 * Provê renderização instantânea de qualquer tela da suíte Tassel com sensible defaults e slots de customização.
 */
@Composable
fun WgcTasselFactory(
    screen: WgcTasselScreen = WgcTasselScreen.Market,
    modifier: Modifier = Modifier,
    selectedProduct: TasselProduct = TasselMockData.products[0],
    onNavigateToScreen: (WgcTasselScreen) -> Unit = {},
    customSlot: (@Composable () -> Unit)? = null
) {
    if (customSlot != null) {
        customSlot()
        return
    }

    when (screen) {
        WgcTasselScreen.Market -> {
            WgcTasselMarketTemplate(
                modifier = modifier,
                onCollectionClick = { onNavigateToScreen(WgcTasselScreen.Featured) },
                onTabSelect = { tabIndex ->
                    if (tabIndex == 0) onNavigateToScreen(WgcTasselScreen.Featured)
                },
                onNavItemSelected = { navIndex ->
                    when (navIndex) {
                        0 -> onNavigateToScreen(WgcTasselScreen.Featured)
                        1 -> onNavigateToScreen(WgcTasselScreen.Market)
                        2 -> onNavigateToScreen(WgcTasselScreen.Cart)
                        3 -> onNavigateToScreen(WgcTasselScreen.Profile)
                    }
                }
            )
        }
        WgcTasselScreen.Featured -> {
            WgcTasselFeaturedTemplate(
                modifier = modifier,
                onProductClick = { onNavigateToScreen(WgcTasselScreen.ProductDetail) },
                onTabSelect = { tabIndex ->
                    if (tabIndex == 1) onNavigateToScreen(WgcTasselScreen.Market)
                },
                onNavItemSelected = { navIndex ->
                    when (navIndex) {
                        0 -> onNavigateToScreen(WgcTasselScreen.Featured)
                        1 -> onNavigateToScreen(WgcTasselScreen.Market)
                        2 -> onNavigateToScreen(WgcTasselScreen.Cart)
                        3 -> onNavigateToScreen(WgcTasselScreen.Profile)
                    }
                }
            )
        }
        WgcTasselScreen.ProductDetail -> {
            WgcTasselProductDetailTemplate(
                modifier = modifier,
                product = selectedProduct,
                onBackClick = { onNavigateToScreen(WgcTasselScreen.Market) },
                onAddToBagClick = { onNavigateToScreen(WgcTasselScreen.Cart) }
            )
        }
        WgcTasselScreen.OrderTracking -> {
            WgcTasselOrderTrackingTemplate(
                modifier = modifier,
                onCloseClick = { onNavigateToScreen(WgcTasselScreen.Profile) }
            )
        }
        WgcTasselScreen.Profile -> {
            WgcTasselProfileTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcTasselScreen.Market) },
                onOrdersClick = { onNavigateToScreen(WgcTasselScreen.OrderTracking) },
                onNavItemSelected = { navIndex ->
                    when (navIndex) {
                        0 -> onNavigateToScreen(WgcTasselScreen.Featured)
                        1 -> onNavigateToScreen(WgcTasselScreen.Market)
                        2 -> onNavigateToScreen(WgcTasselScreen.Cart)
                        3 -> onNavigateToScreen(WgcTasselScreen.Profile)
                    }
                }
            )
        }
        WgcTasselScreen.Cart -> {
            WgcTasselCartTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcTasselScreen.Market) },
                onCheckoutClick = { onNavigateToScreen(WgcTasselScreen.OrderTracking) },
                onNavItemSelected = { navIndex ->
                    when (navIndex) {
                        0 -> onNavigateToScreen(WgcTasselScreen.Featured)
                        1 -> onNavigateToScreen(WgcTasselScreen.Market)
                        2 -> onNavigateToScreen(WgcTasselScreen.Cart)
                        3 -> onNavigateToScreen(WgcTasselScreen.Profile)
                    }
                }
            )
        }
    }
}
