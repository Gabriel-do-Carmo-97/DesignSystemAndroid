package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.CarrefourNavTab
import br.com.wgc.ds_templates.screens.carrefour.cart.WgcCarrefourCartTemplate
import br.com.wgc.ds_templates.screens.carrefour.coupons.WgcCarrefourCouponsTemplate
import br.com.wgc.ds_templates.screens.carrefour.flyer.WgcCarrefourFlyerTemplate
import br.com.wgc.ds_templates.screens.carrefour.home.WgcCarrefourHomeTemplate
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourCartItem
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourCouponItem
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourFlyerOffer
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourMockData
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourProductItem
import br.com.wgc.ds_templates.screens.carrefour.model.CarrefourUserProfile
import br.com.wgc.ds_templates.screens.carrefour.profile.WgcCarrefourProfileTemplate

enum class WgcCarrefourScreen {
    HOME,
    COUPONS,
    FLYER,
    CART,
    PROFILE
}

@Composable
fun WgcCarrefourFactory(
    modifier: Modifier = Modifier,
    screen: WgcCarrefourScreen = WgcCarrefourScreen.HOME,
    userProfile: CarrefourUserProfile = CarrefourMockData.sampleUserProfile,
    featuredProducts: List<CarrefourProductItem> = CarrefourMockData.sampleProducts,
    coupons: List<CarrefourCouponItem> = CarrefourMockData.sampleCoupons,
    flyerOffers: List<CarrefourFlyerOffer> = CarrefourMockData.sampleFlyerOffers,
    cartItems: List<CarrefourCartItem> = CarrefourMockData.sampleCartItems,
    coinsBalance: Int = 180,
    storeName: String = "Hipermercado Pinheiros",
    activeTab: CarrefourNavTab = when (screen) {
        WgcCarrefourScreen.HOME -> CarrefourNavTab.HOME
        WgcCarrefourScreen.COUPONS -> CarrefourNavTab.COUPONS
        WgcCarrefourScreen.FLYER -> CarrefourNavTab.FLYER
        WgcCarrefourScreen.CART -> CarrefourNavTab.CART
        WgcCarrefourScreen.PROFILE -> CarrefourNavTab.MEU_CARREFOUR
    },
    onTabSelected: (CarrefourNavTab) -> Unit = {},
    onProductQuantityChange: (String, Int) -> Unit = { _, _ -> },
    onProductFavoriteToggle: (String) -> Unit = {},
    onActivateCoupon: (String) -> Unit = {},
    onAddToCartFlyer: (CarrefourFlyerOffer) -> Unit = {},
    onRemoveCartItem: (String) -> Unit = {},
    onCheckout: () -> Unit = {},
    onViewCashierCode: () -> Unit = {},
    onStoreChangeClick: () -> Unit = {},
    onBarcodeScanClick: () -> Unit = {},
    onMenuItemClick: (String) -> Unit = {}
) {
    when (screen) {
        WgcCarrefourScreen.HOME -> {
            WgcCarrefourHomeTemplate(
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
        WgcCarrefourScreen.COUPONS -> {
            WgcCarrefourCouponsTemplate(
                modifier = modifier,
                coupons = coupons,
                coinsBalance = coinsBalance,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onActivateCoupon = onActivateCoupon,
                onViewCashierCode = onViewCashierCode
            )
        }
        WgcCarrefourScreen.FLYER -> {
            WgcCarrefourFlyerTemplate(
                modifier = modifier,
                offers = flyerOffers,
                storeName = storeName,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onAddToCart = onAddToCartFlyer
            )
        }
        WgcCarrefourScreen.CART -> {
            WgcCarrefourCartTemplate(
                modifier = modifier,
                cartItems = cartItems,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onQuantityChange = onProductQuantityChange,
                onRemoveItem = onRemoveCartItem,
                onCheckout = onCheckout
            )
        }
        WgcCarrefourScreen.PROFILE -> {
            WgcCarrefourProfileTemplate(
                modifier = modifier,
                userProfile = userProfile,
                activeTab = activeTab,
                onTabSelected = onTabSelected,
                onMenuItemClick = onMenuItemClick
            )
        }
    }
}
