package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.GroceryNavTab
import br.com.wgc.ds_templates.screens.grocery.cart.WgcSupermercadoCartTemplate
import br.com.wgc.ds_templates.screens.grocery.coupons.WgcSupermercadoCouponsTemplate
import br.com.wgc.ds_templates.screens.grocery.flyer.WgcSupermercadoFlyerTemplate
import br.com.wgc.ds_templates.screens.grocery.home.WgcSupermercadoHomeTemplate
import br.com.wgc.ds_templates.screens.grocery.model.SupermercadoCartItem
import br.com.wgc.ds_templates.screens.grocery.model.SupermercadoCouponItem
import br.com.wgc.ds_templates.screens.grocery.model.SupermercadoFlyerOffer
import br.com.wgc.ds_templates.screens.grocery.model.GroceryMockData
import br.com.wgc.ds_templates.screens.grocery.model.SupermercadoProductItem
import br.com.wgc.ds_templates.screens.grocery.model.SupermercadoUserProfile
import br.com.wgc.ds_templates.screens.grocery.profile.WgcSupermercadoProfileTemplate

enum class WgcGroceryScreen {
    HOME,
    COUPONS,
    FLYER,
    CART,
    PROFILE
}

@Composable
fun WgcGroceryFactory(
    modifier: Modifier = Modifier,
    screen: WgcGroceryScreen = WgcGroceryScreen.HOME,
    userProfile: SupermercadoUserProfile = GroceryMockData.sampleUserProfile,
    featuredProducts: List<SupermercadoProductItem> = GroceryMockData.sampleProducts,
    coupons: List<SupermercadoCouponItem> = GroceryMockData.sampleCoupons,
    flyerOffers: List<SupermercadoFlyerOffer> = GroceryMockData.sampleFlyerOffers,
    cartItems: List<SupermercadoCartItem> = GroceryMockData.sampleCartItems,
    coinsBalance: Int = 180,
    storeName: String = "Hipermercado Pinheiros",
    activeTab: GroceryNavTab = when (screen) {
        WgcGroceryScreen.HOME -> GroceryNavTab.HOME
        WgcGroceryScreen.COUPONS -> GroceryNavTab.COUPONS
        WgcGroceryScreen.FLYER -> GroceryNavTab.FLYER
        WgcGroceryScreen.CART -> GroceryNavTab.CART
        WgcGroceryScreen.PROFILE -> GroceryNavTab.LOYALTY
    },
    onTabSelected: (GroceryNavTab) -> Unit = {},
    onProductQuantityChange: (String, Int) -> Unit = { _, _ -> },
    onProductFavoriteToggle: (String) -> Unit = {},
    onActivateCoupon: (String) -> Unit = {},
    onAddToCartFlyer: (SupermercadoFlyerOffer) -> Unit = {},
    onRemoveCartItem: (String) -> Unit = {},
    onCheckout: () -> Unit = {},
    onViewCashierCode: () -> Unit = {},
    onStoreChangeClick: () -> Unit = {},
    onBarcodeScanClick: () -> Unit = {},
    onMenuItemClick: (String) -> Unit = {}
) {
    when (screen) {
        WgcGroceryScreen.HOME -> {
            WgcSupermercadoHomeTemplate(
                modifier = modifier,
                userProfile = userProfile,
                featuredProducts = featuredProducts,
                coinsBalance = coinsBalance,
                currentStore = storeName,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onProductQuantityChange = onProductQuantityChange,
                onProductFavoriteToggle = onProductFavoriteToggle,
                onStoreChangeClick = onStoreChangeClick,
                onBarcodeScanClick = onBarcodeScanClick,
                onViewNutriScoreDetails = {}
            )
        }
        WgcGroceryScreen.COUPONS -> {
            WgcSupermercadoCouponsTemplate(
                modifier = modifier,
                coupons = coupons,
                coinsBalance = coinsBalance,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onActivateCoupon = onActivateCoupon,
                onViewCashierCode = onViewCashierCode
            )
        }
        WgcGroceryScreen.FLYER -> {
            WgcSupermercadoFlyerTemplate(
                modifier = modifier,
                offers = flyerOffers,
                storeName = storeName,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onAddToCart = onAddToCartFlyer
            )
        }
        WgcGroceryScreen.CART -> {
            WgcSupermercadoCartTemplate(
                modifier = modifier,
                cartItems = cartItems,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onQuantityChange = onProductQuantityChange,
                onRemoveItem = onRemoveCartItem,
                onCheckout = onCheckout
            )
        }
        WgcGroceryScreen.PROFILE -> {
            WgcSupermercadoProfileTemplate(
                modifier = modifier,
                userProfile = userProfile,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onMenuItemClick = onMenuItemClick
            )
        }
    }
}
