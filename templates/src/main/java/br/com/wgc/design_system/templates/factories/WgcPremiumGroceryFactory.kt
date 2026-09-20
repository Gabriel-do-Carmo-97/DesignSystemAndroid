package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcSupermarketNavItem
import br.com.wgc.design_system.templates.screens.premiumgrocery.adega.WgcPdaAdegaTemplate
import br.com.wgc.design_system.templates.screens.premiumgrocery.cart.WgcPdaGourmetCartTemplate
import br.com.wgc.design_system.templates.screens.premiumgrocery.discounts.WgcPdaDiscountsTemplate
import br.com.wgc.design_system.templates.screens.premiumgrocery.home.WgcPdaHomeTemplate
import br.com.wgc.design_system.templates.screens.premiumgrocery.model.PdaCartItem
import br.com.wgc.design_system.templates.screens.premiumgrocery.model.PdaDiscountItem
import br.com.wgc.design_system.templates.screens.premiumgrocery.model.PremiumGroceryMockData
import br.com.wgc.design_system.templates.screens.premiumgrocery.model.PdaProductItem
import br.com.wgc.design_system.templates.screens.premiumgrocery.model.PdaUserProfile
import br.com.wgc.design_system.templates.screens.premiumgrocery.model.PdaWineItem
import br.com.wgc.design_system.templates.screens.premiumgrocery.profile.WgcPdaClienteMaisProfileTemplate

enum class WgcPremiumGroceryScreen {
    HOME,
    ADEGA,
    DISCOUNTS,
    CART,
    PROFILE
}

@Composable
fun WgcPremiumGroceryFactory(
    modifier: Modifier = Modifier,
    screen: WgcPremiumGroceryScreen = WgcPremiumGroceryScreen.HOME,
    userProfile: PdaUserProfile = PremiumGroceryMockData.defaultUser,
    featuredProducts: List<PdaProductItem> = PremiumGroceryMockData.gourmetProducts,
    sommelierWines: List<PdaWineItem> = PremiumGroceryMockData.sommelierWines,
    discounts: List<PdaDiscountItem> = PremiumGroceryMockData.discounts,
    cartItems: List<PdaCartItem> = PremiumGroceryMockData.cartItems,
    selectedNavItem: WgcSupermarketNavItem = when (screen) {
        WgcPremiumGroceryScreen.HOME -> WgcSupermarketNavItem.HOME
        WgcPremiumGroceryScreen.ADEGA -> WgcSupermarketNavItem.ADEGA
        WgcPremiumGroceryScreen.DISCOUNTS -> WgcSupermarketNavItem.DISCOUNTS
        WgcPremiumGroceryScreen.CART -> WgcSupermarketNavItem.CART
        WgcPremiumGroceryScreen.PROFILE -> WgcSupermarketNavItem.PROFILE
    },
    onNavItemClick: (WgcSupermarketNavItem) -> Unit = {},
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
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
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
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
                onWineQuantityChange = onWineQuantityChange,
                headerSlot = headerSlot,
                footerSlot = footerSlot
            )
        }
        WgcPremiumGroceryScreen.DISCOUNTS -> {
            WgcPdaDiscountsTemplate(
                modifier = modifier,
                discounts = discounts,
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
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
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
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
                selectedNavItem = selectedNavItem,
                onNavItemClick = onNavItemClick,
                headerSlot = headerSlot,
                footerSlot = footerSlot
            )
        }
    }
}
