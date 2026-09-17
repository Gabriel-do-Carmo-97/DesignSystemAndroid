package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.premiumgrocery.adega.WgcPdaAdegaTemplate
import br.com.wgc.ds_templates.screens.premiumgrocery.cart.WgcPdaGourmetCartTemplate
import br.com.wgc.ds_templates.screens.premiumgrocery.discounts.WgcPdaDiscountsTemplate
import br.com.wgc.ds_templates.screens.premiumgrocery.home.WgcPdaHomeTemplate
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaCartItem
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaDiscountItem
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PremiumGroceryMockData
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaProductItem
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaUserProfile
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaWineItem
import br.com.wgc.ds_templates.screens.premiumgrocery.profile.WgcPdaClienteMaisProfileTemplate

/**
 * Telas disponíveis na suíte Supermercado Gourmet Premium.
 */
enum class WgcPremiumGroceryScreen {
    HOME,
    ADEGA,
    DISCOUNTS,
    CART,
    PROFILE
}

/**
 * Fábrica unificada para telas do Supermercado Gourmet Premium (WgcPremiumGroceryFactory).
 *
 * Fornece defaults corporativos prontos para produção, com suporte total
 * a State Hoisting e substituição granular via slots.
 */
@Composable
fun WgcPremiumGroceryFactory(
    modifier: Modifier = Modifier,
    screen: WgcPremiumGroceryScreen = WgcPremiumGroceryScreen.HOME,
    userProfile: PdaUserProfile = PremiumGroceryMockData.defaultUser,
    featuredProducts: List<PdaProductItem> = PremiumGroceryMockData.gourmetProducts,
    sommelierWines: List<PdaWineItem> = PremiumGroceryMockData.sommelierWines,
    discounts: List<PdaDiscountItem> = PremiumGroceryMockData.discounts,
    cartItems: List<PdaCartItem> = PremiumGroceryMockData.cartItems,
    selectedNavIndex: Int = when (screen) {
        WgcPremiumGroceryScreen.HOME -> 0
        WgcPremiumGroceryScreen.ADEGA -> 1
        WgcPremiumGroceryScreen.DISCOUNTS -> 2
        WgcPremiumGroceryScreen.CART -> 3
        WgcPremiumGroceryScreen.PROFILE -> 4
    },
    onNavSelect: (Int) -> Unit = {},
    onProductQuantityChange: (String, Int) -> Unit = { _, _ -> },
    onWineQuantityChange: (String, Int) -> Unit = { _, _ -> },
    onProductFavoriteToggle: (String) -> Unit = {},
    onActivateAllDiscountsClick: () -> Unit = {},
    onToggleDiscount: (String) -> Unit = {},
    onCheckoutClick: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null
) {
    when (screen) {
        WgcPremiumGroceryScreen.HOME -> {
            WgcPdaHomeTemplate(
                modifier = modifier,
                userProfile = userProfile,
                featuredProducts = featuredProducts,
                sommelierPicks = sommelierWines,
                selectedNavIndex = selectedNavIndex,
                onNavSelect = onNavSelect,
                onProductQuantityChange = onProductQuantityChange,
                onWineQuantityChange = onWineQuantityChange,
                onProductFavoriteToggle = onProductFavoriteToggle,
                headerSlot = headerSlot,
                footerSlot = footerSlot
            )
        }
        WgcPremiumGroceryScreen.ADEGA -> {
            WgcPdaAdegaTemplate(
                modifier = modifier,
                wines = sommelierWines,
                selectedNavIndex = selectedNavIndex,
                onNavSelect = onNavSelect,
                onWineQuantityChange = onWineQuantityChange,
                headerSlot = headerSlot,
                footerSlot = footerSlot
            )
        }
        WgcPremiumGroceryScreen.DISCOUNTS -> {
            WgcPdaDiscountsTemplate(
                modifier = modifier,
                discounts = discounts,
                selectedNavIndex = selectedNavIndex,
                onNavSelect = onNavSelect,
                onActivateAllClick = onActivateAllDiscountsClick,
                onToggleDiscount = onToggleDiscount,
                headerSlot = headerSlot,
                footerSlot = footerSlot
            )
        }
        WgcPremiumGroceryScreen.CART -> {
            WgcPdaGourmetCartTemplate(
                modifier = modifier,
                cartItems = cartItems,
                selectedNavIndex = selectedNavIndex,
                onNavSelect = onNavSelect,
                onQuantityChange = onProductQuantityChange,
                onCheckoutClick = onCheckoutClick,
                headerSlot = headerSlot,
                footerSlot = footerSlot
            )
        }
        WgcPremiumGroceryScreen.PROFILE -> {
            WgcPdaClienteMaisProfileTemplate(
                modifier = modifier,
                userProfile = userProfile,
                selectedNavIndex = selectedNavIndex,
                onNavSelect = onNavSelect,
                headerSlot = headerSlot,
                footerSlot = footerSlot
            )
        }
    }
}
