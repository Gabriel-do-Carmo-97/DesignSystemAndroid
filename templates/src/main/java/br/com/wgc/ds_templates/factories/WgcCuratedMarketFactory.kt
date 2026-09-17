package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.curatedmarket.cart.WgcTasselCartTemplate
import br.com.wgc.ds_templates.screens.curatedmarket.featured.WgcTasselFeaturedTemplate
import br.com.wgc.ds_templates.screens.curatedmarket.market.WgcTasselMarketTemplate
import br.com.wgc.ds_templates.screens.curatedmarket.model.CuratedMarketMockData
import br.com.wgc.ds_templates.screens.curatedmarket.model.TasselProduct
import br.com.wgc.ds_templates.screens.curatedmarket.product.WgcTasselProductDetailTemplate
import br.com.wgc.ds_templates.screens.curatedmarket.profile.WgcTasselProfileTemplate
import br.com.wgc.ds_templates.screens.curatedmarket.tracking.WgcTasselOrderTrackingTemplate

/**
 * Telas suportadas pela fábrica unificada Tassel.
 */
enum class WgcCuratedMarketScreen {
    Market,
    Featured,
    ProductDetail,
    OrderTracking,
    Profile,
    Cart
}

/**
 * Fábrica Universal do Ecossistema Tassel (WgcCuratedMarketFactory).
 * Provê renderização instantânea de qualquer tela da suíte Tassel com sensible defaults e slots de customização.
 */
@Composable
fun WgcCuratedMarketFactory(
    screen: WgcCuratedMarketScreen = WgcCuratedMarketScreen.Market,
    modifier: Modifier = Modifier,
    selectedProduct: TasselProduct = CuratedMarketMockData.products[0],
    onNavigateToScreen: (WgcCuratedMarketScreen) -> Unit = {},
    customSlot: (@Composable () -> Unit)? = null
) {
    if (customSlot != null) {
        customSlot()
        return
    }

    when (screen) {
        WgcCuratedMarketScreen.Market -> {
            WgcTasselMarketTemplate(
                modifier = modifier,
                onCollectionClick = { onNavigateToScreen(WgcCuratedMarketScreen.Featured) },
                onTabSelect = { tabIndex ->
                    if (tabIndex == 0) onNavigateToScreen(WgcCuratedMarketScreen.Featured)
                },
                onNavItemSelected = { navIndex ->
                    when (navIndex) {
                        0 -> onNavigateToScreen(WgcCuratedMarketScreen.Featured)
                        1 -> onNavigateToScreen(WgcCuratedMarketScreen.Market)
                        2 -> onNavigateToScreen(WgcCuratedMarketScreen.Cart)
                        3 -> onNavigateToScreen(WgcCuratedMarketScreen.Profile)
                    }
                }
            )
        }
        WgcCuratedMarketScreen.Featured -> {
            WgcTasselFeaturedTemplate(
                modifier = modifier,
                onProductClick = { onNavigateToScreen(WgcCuratedMarketScreen.ProductDetail) },
                onTabSelect = { tabIndex ->
                    if (tabIndex == 1) onNavigateToScreen(WgcCuratedMarketScreen.Market)
                },
                onNavItemSelected = { navIndex ->
                    when (navIndex) {
                        0 -> onNavigateToScreen(WgcCuratedMarketScreen.Featured)
                        1 -> onNavigateToScreen(WgcCuratedMarketScreen.Market)
                        2 -> onNavigateToScreen(WgcCuratedMarketScreen.Cart)
                        3 -> onNavigateToScreen(WgcCuratedMarketScreen.Profile)
                    }
                }
            )
        }
        WgcCuratedMarketScreen.ProductDetail -> {
            WgcTasselProductDetailTemplate(
                modifier = modifier,
                product = selectedProduct,
                onBackClick = { onNavigateToScreen(WgcCuratedMarketScreen.Market) },
                onAddToBagClick = { onNavigateToScreen(WgcCuratedMarketScreen.Cart) }
            )
        }
        WgcCuratedMarketScreen.OrderTracking -> {
            WgcTasselOrderTrackingTemplate(
                modifier = modifier,
                onCloseClick = { onNavigateToScreen(WgcCuratedMarketScreen.Profile) }
            )
        }
        WgcCuratedMarketScreen.Profile -> {
            WgcTasselProfileTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcCuratedMarketScreen.Market) },
                onOrdersClick = { onNavigateToScreen(WgcCuratedMarketScreen.OrderTracking) },
                onNavItemSelected = { navIndex ->
                    when (navIndex) {
                        0 -> onNavigateToScreen(WgcCuratedMarketScreen.Featured)
                        1 -> onNavigateToScreen(WgcCuratedMarketScreen.Market)
                        2 -> onNavigateToScreen(WgcCuratedMarketScreen.Cart)
                        3 -> onNavigateToScreen(WgcCuratedMarketScreen.Profile)
                    }
                }
            )
        }
        WgcCuratedMarketScreen.Cart -> {
            WgcTasselCartTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcCuratedMarketScreen.Market) },
                onCheckoutClick = { onNavigateToScreen(WgcCuratedMarketScreen.OrderTracking) },
                onNavItemSelected = { navIndex ->
                    when (navIndex) {
                        0 -> onNavigateToScreen(WgcCuratedMarketScreen.Featured)
                        1 -> onNavigateToScreen(WgcCuratedMarketScreen.Market)
                        2 -> onNavigateToScreen(WgcCuratedMarketScreen.Cart)
                        3 -> onNavigateToScreen(WgcCuratedMarketScreen.Profile)
                    }
                }
            )
        }
    }
}
