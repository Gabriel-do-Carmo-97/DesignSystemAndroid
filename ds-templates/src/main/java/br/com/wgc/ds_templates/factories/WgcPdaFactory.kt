package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.pda.adega.WgcPdaAdegaTemplate
import br.com.wgc.ds_templates.screens.pda.cart.WgcPdaGourmetCartTemplate
import br.com.wgc.ds_templates.screens.pda.discounts.WgcPdaDiscountsTemplate
import br.com.wgc.ds_templates.screens.pda.home.WgcPdaHomeTemplate
import br.com.wgc.ds_templates.screens.pda.model.PdaCartItem
import br.com.wgc.ds_templates.screens.pda.model.PdaDiscountItem
import br.com.wgc.ds_templates.screens.pda.model.PdaMockData
import br.com.wgc.ds_templates.screens.pda.model.PdaProductItem
import br.com.wgc.ds_templates.screens.pda.model.PdaUserProfile
import br.com.wgc.ds_templates.screens.pda.model.PdaWineItem
import br.com.wgc.ds_templates.screens.pda.profile.WgcPdaClienteMaisProfileTemplate

/**
 * Telas disponíveis na suíte Pão de Açúcar Mais.
 */
enum class WgcPdaScreen {
    HOME,
    ADEGA,
    DISCOUNTS,
    CART,
    PROFILE
}

/**
 * Fábrica unificada para telas do Pão de Açúcar Mais (WgcPdaFactory).
 *
 * Fornece defaults corporativos prontos para produção, com suporte total
 * a State Hoisting e substituição granular via slots.
 */
@Composable
fun WgcPdaFactory(
    modifier: Modifier = Modifier,
    screen: WgcPdaScreen = WgcPdaScreen.HOME,
    userProfile: PdaUserProfile = PdaMockData.defaultUser,
    featuredProducts: List<PdaProductItem> = PdaMockData.gourmetProducts,
    sommelierWines: List<PdaWineItem> = PdaMockData.sommelierWines,
    discounts: List<PdaDiscountItem> = PdaMockData.discounts,
    cartItems: List<PdaCartItem> = PdaMockData.cartItems,
    selectedNavIndex: Int = when (screen) {
        WgcPdaScreen.HOME -> 0
        WgcPdaScreen.ADEGA -> 1
        WgcPdaScreen.DISCOUNTS -> 2
        WgcPdaScreen.CART -> 3
        WgcPdaScreen.PROFILE -> 4
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
        WgcPdaScreen.HOME -> {
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
        WgcPdaScreen.ADEGA -> {
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
        WgcPdaScreen.DISCOUNTS -> {
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
        WgcPdaScreen.CART -> {
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
        WgcPdaScreen.PROFILE -> {
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
