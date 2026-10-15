package br.com.wgc.design_system.factories.verticals.curatedmarket

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.curatedmarket.templates.cart.WgcTasselCartTemplate
import br.com.wgc.design_system.factories.verticals.curatedmarket.templates.featured.WgcTasselFeaturedTemplate
import br.com.wgc.design_system.factories.verticals.curatedmarket.templates.market.WgcTasselMarketTemplate
import br.com.wgc.design_system.factories.verticals.curatedmarket.templates.model.CuratedMarketMockData
import br.com.wgc.design_system.factories.verticals.curatedmarket.templates.model.TasselProduct
import br.com.wgc.design_system.factories.verticals.curatedmarket.templates.product.WgcTasselProductDetailTemplate
import br.com.wgc.design_system.factories.verticals.curatedmarket.templates.profile.WgcTasselProfileTemplate
import br.com.wgc.design_system.factories.verticals.curatedmarket.templates.tracking.WgcTasselOrderTrackingTemplate

/**
 * Telas suportadas pela fÃ¡brica unificada Tassel.
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
 * FÃ¡brica Universal do Ecossistema Tassel (WgcCuratedMarketFactory).
 * ProvÃª renderizaÃ§Ã£o instantÃ¢nea de qualquer tela da suÃ­te Tassel com sensible defaults e slots de customizaÃ§Ã£o.
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
