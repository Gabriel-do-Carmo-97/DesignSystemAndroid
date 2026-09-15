package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcExtraNavItem
import br.com.wgc.ds_templates.screens.extra.cart.WgcExtraCartTemplate
import br.com.wgc.ds_templates.screens.extra.discounts.WgcExtraDiscountsTemplate
import br.com.wgc.ds_templates.screens.extra.flyer.WgcExtraFlyerTemplate
import br.com.wgc.ds_templates.screens.extra.home.WgcExtraHomeTemplate
import br.com.wgc.ds_templates.screens.extra.loyalty.WgcExtraLoyaltyTemplate
import br.com.wgc.ds_templates.screens.extra.model.ExtraCartItem
import br.com.wgc.ds_templates.screens.extra.model.ExtraCouponItem
import br.com.wgc.ds_templates.screens.extra.model.ExtraMockData
import br.com.wgc.ds_templates.screens.extra.model.ExtraProductItem
import br.com.wgc.ds_templates.screens.extra.model.ExtraUserProfile

/**
 * Telas suportadas pela Fábrica Clube Extra (WgcExtraFactory).
 */
enum class WgcExtraScreen {
    HOME,
    DISCOUNTS,
    FLYER,
    CART,
    LOYALTY
}

/**
 * Fábrica Universal de Telas do Clube Extra (WgcExtraFactory).
 *
 * Provê alternância instantânea entre as telas de vitrine de supermercado,
 * cupons personalizados por CPF, folheto digital, carrinho e programa Juntou & Ganhou.
 *
 * 100% tokenizado com WgcCoreDs, State Hoisting e slots customizáveis.
 */
@Composable
fun WgcExtraFactory(
    modifier: Modifier = Modifier,
    screen: WgcExtraScreen = WgcExtraScreen.HOME,
    user: ExtraUserProfile = ExtraMockData.mockUser,
    products: List<ExtraProductItem> = ExtraMockData.mockProducts,
    coupons: List<ExtraCouponItem> = ExtraMockData.mockCoupons,
    cartItems: List<ExtraCartItem> = listOf(
        ExtraCartItem(ExtraMockData.mockProducts[0], 1),
        ExtraCartItem(ExtraMockData.mockProducts[1], 2),
        ExtraCartItem(ExtraMockData.mockProducts[2], 6)
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
        WgcExtraScreen.HOME -> {
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
        WgcExtraScreen.DISCOUNTS -> {
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
        WgcExtraScreen.FLYER -> {
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
        WgcExtraScreen.CART -> {
            WgcExtraCartTemplate(
                cartItems = cartItems,
                modifier = modifier,
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
                slotHeader = slotHeader,
                slotBottomNav = slotBottomNav
            )
        }
        WgcExtraScreen.LOYALTY -> {
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
