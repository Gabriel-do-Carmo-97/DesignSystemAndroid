package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcExtraNavItem
import br.com.wgc.design_system.templates.screens.hypermarket.cart.WgcExtraCartTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.discounts.WgcExtraDiscountsTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.flyer.WgcExtraFlyerTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.home.WgcExtraHomeTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.loyalty.WgcExtraLoyaltyTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.model.ExtraCartItem
import br.com.wgc.design_system.templates.screens.hypermarket.model.ExtraCouponItem
import br.com.wgc.design_system.templates.screens.hypermarket.model.HypermarketMockData
import br.com.wgc.design_system.templates.screens.hypermarket.model.ExtraProductItem
import br.com.wgc.design_system.templates.screens.hypermarket.model.ExtraUserProfile

/**
 * Telas suportadas pela Fábrica Clube Extra (WgcHypermarketFactory).
 */
enum class WgcHypermarketScreen {
    HOME,
    DISCOUNTS,
    FLYER,
    CART,
    LOYALTY
}

/**
 * Fábrica Universal de Telas do Clube Extra (WgcHypermarketFactory).
 *
 * Provê alternância instantânea entre as telas de vitrine de supermercado,
 * cupons personalizados por CPF, folheto digital, carrinho e programa Juntou & Ganhou.
 *
 * 100% tokenizado com WgcCoreDs, State Hoisting e slots customizáveis.
 */
@Composable
fun WgcHypermarketFactory(
    modifier: Modifier = Modifier,
    screen: WgcHypermarketScreen = WgcHypermarketScreen.HOME,
    user: ExtraUserProfile = HypermarketMockData.mockUser,
    products: List<ExtraProductItem> = HypermarketMockData.mockProducts,
    coupons: List<ExtraCouponItem> = HypermarketMockData.mockCoupons,
    cartItems: List<ExtraCartItem> = listOf(
        ExtraCartItem(HypermarketMockData.mockProducts[0], 1),
        ExtraCartItem(HypermarketMockData.mockProducts[1], 2),
        ExtraCartItem(HypermarketMockData.mockProducts[2], 6)
    ),
    selectedNavItem: WgcExtraNavItem = WgcExtraNavItem.HOME,
    onNavItemClick: (WgcExtraNavItem) -> Unit = {},
    onSelectProduct: (ExtraProductItem) -> Unit = {},
    onAddToCart: (ExtraProductItem) -> Unit = {},
    onNavigateToDiscounts: () -> Unit = {},
    onNavigateToFlyer: () -> Unit = {},
    onNavigateToCart: () -> Unit = {},
    onNavigateToLoyalty: () -> Unit = {},
    slotHeader: (@Composable () -> Unit)? = null,
    slotBottomNav: (@Composable () -> Unit)? = null,
    customScreenSlot: (@Composable () -> Unit)? = null
) {
    if (customScreenSlot != null) {
        customScreenSlot()
        return
    }

    when (screen) {
        WgcHypermarketScreen.HOME -> {
            WgcExtraHomeTemplate(
                user = user,
                products = products,
                modifier = modifier,
                onOpenDiscounts = onNavigateToDiscounts,
                onOpenFlyer = onNavigateToFlyer,
                onOpenCart = onNavigateToCart,
                onOpenLoyalty = onNavigateToLoyalty,
                onSelectProduct = onSelectProduct,
                onAddToCart = onAddToCart,
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
                slotHeader = slotHeader,
                slotBottomNav = slotBottomNav
            )
        }
        WgcHypermarketScreen.DISCOUNTS -> {
            WgcExtraDiscountsTemplate(
                coupons = coupons,
                userCpfMasked = user.cpfMasked,
                modifier = modifier,
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
                slotHeader = slotHeader,
                slotBottomNav = slotBottomNav
            )
        }
        WgcHypermarketScreen.FLYER -> {
            WgcExtraFlyerTemplate(
                products = products,
                modifier = modifier,
                onAddToCart = onAddToCart,
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
                slotHeader = slotHeader,
                slotBottomNav = slotBottomNav
            )
        }
        WgcHypermarketScreen.CART -> {
            WgcExtraCartTemplate(
                cartItems = cartItems,
                modifier = modifier,
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
                slotHeader = slotHeader,
                slotBottomNav = slotBottomNav
            )
        }
        WgcHypermarketScreen.LOYALTY -> {
            WgcExtraLoyaltyTemplate(
                stamps = user.loyaltyStamps,
                modifier = modifier,
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
                slotHeader = slotHeader,
                slotBottomNav = slotBottomNav
            )
        }
    }
}
