package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.clothee.auth.WgcClotheeForgotPasswordTemplate
import br.com.wgc.ds_templates.screens.clothee.auth.WgcClotheeResetPasswordSentTemplate
import br.com.wgc.ds_templates.screens.clothee.auth.WgcClotheeSignInTemplate
import br.com.wgc.ds_templates.screens.clothee.cart.WgcClotheeCartTemplate
import br.com.wgc.ds_templates.screens.clothee.categories.WgcClotheeCategoryListTemplate
import br.com.wgc.ds_templates.screens.clothee.checkout.WgcClotheeOrderPlacedTemplate
import br.com.wgc.ds_templates.screens.clothee.home.WgcClotheeHomeTemplate
import br.com.wgc.ds_templates.screens.clothee.model.ClotheeMockData
import br.com.wgc.ds_templates.screens.clothee.model.ClotheeProduct
import br.com.wgc.ds_templates.screens.clothee.product.WgcClotheeProductDetailTemplate
import br.com.wgc.ds_templates.screens.clothee.profile.WgcClotheeSettingsTemplate
import br.com.wgc.ds_templates.screens.clothee.tracking.WgcClotheeTrackOrderTemplate

/**
 * Telas suportadas pela fábrica unificada Clothee.
 */
enum class WgcClotheeScreen {
    SignIn,
    ForgotPassword,
    ResetPasswordSent,
    Home,
    CategoryList,
    ProductDetail,
    Cart,
    OrderPlaced,
    TrackOrder,
    Settings
}

/**
 * Fábrica Universal do Ecossistema Clothee (WgcClotheeFactory).
 * Provê renderização instantânea de qualquer tela da suíte com sensible defaults e slots de customização.
 */
@Composable
fun WgcClotheeFactory(
    screen: WgcClotheeScreen = WgcClotheeScreen.Home,
    modifier: Modifier = Modifier,
    selectedProduct: ClotheeProduct = ClotheeMockData.products[0],
    onNavigateToScreen: (WgcClotheeScreen) -> Unit = {},
    customSlot: (@Composable () -> Unit)? = null
) {
    if (customSlot != null) {
        customSlot()
        return
    }

    when (screen) {
        WgcClotheeScreen.SignIn -> {
            WgcClotheeSignInTemplate(
                modifier = modifier,
                onContinueClick = { onNavigateToScreen(WgcClotheeScreen.Home) },
                onForgotPasswordClick = { onNavigateToScreen(WgcClotheeScreen.ForgotPassword) }
            )
        }
        WgcClotheeScreen.ForgotPassword -> {
            WgcClotheeForgotPasswordTemplate(
                modifier = modifier,
                onContinueClick = { onNavigateToScreen(WgcClotheeScreen.ResetPasswordSent) },
                onBackClick = { onNavigateToScreen(WgcClotheeScreen.SignIn) }
            )
        }
        WgcClotheeScreen.ResetPasswordSent -> {
            WgcClotheeResetPasswordSentTemplate(
                modifier = modifier,
                onReturnToLoginClick = { onNavigateToScreen(WgcClotheeScreen.SignIn) }
            )
        }
        WgcClotheeScreen.Home -> {
            WgcClotheeHomeTemplate(
                modifier = modifier,
                onCartClick = { onNavigateToScreen(WgcClotheeScreen.Cart) },
                onSeeAllCategories = { onNavigateToScreen(WgcClotheeScreen.CategoryList) },
                onCategoryClick = { onNavigateToScreen(WgcClotheeScreen.CategoryList) },
                onProductClick = { onNavigateToScreen(WgcClotheeScreen.ProductDetail) },
                onNavItemSelected = { index ->
                    when (index) {
                        0 -> onNavigateToScreen(WgcClotheeScreen.Home)
                        1 -> onNavigateToScreen(WgcClotheeScreen.CategoryList)
                        2 -> onNavigateToScreen(WgcClotheeScreen.TrackOrder)
                        3 -> onNavigateToScreen(WgcClotheeScreen.Settings)
                    }
                }
            )
        }
        WgcClotheeScreen.CategoryList -> {
            WgcClotheeCategoryListTemplate(
                modifier = modifier,
                onCategoryClick = { onNavigateToScreen(WgcClotheeScreen.Home) },
                onBackClick = { onNavigateToScreen(WgcClotheeScreen.Home) }
            )
        }
        WgcClotheeScreen.ProductDetail -> {
            WgcClotheeProductDetailTemplate(
                modifier = modifier,
                product = selectedProduct,
                onAddToCart = { onNavigateToScreen(WgcClotheeScreen.Cart) },
                onBackClick = { onNavigateToScreen(WgcClotheeScreen.Home) }
            )
        }
        WgcClotheeScreen.Cart -> {
            WgcClotheeCartTemplate(
                modifier = modifier,
                onCheckoutClick = { onNavigateToScreen(WgcClotheeScreen.OrderPlaced) },
                onBackClick = { onNavigateToScreen(WgcClotheeScreen.Home) }
            )
        }
        WgcClotheeScreen.OrderPlaced -> {
            WgcClotheeOrderPlacedTemplate(
                modifier = modifier,
                onSeeOrderDetailsClick = { onNavigateToScreen(WgcClotheeScreen.TrackOrder) }
            )
        }
        WgcClotheeScreen.TrackOrder -> {
            WgcClotheeTrackOrderTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcClotheeScreen.Home) },
                onViewItemsClick = { onNavigateToScreen(WgcClotheeScreen.Cart) }
            )
        }
        WgcClotheeScreen.Settings -> {
            WgcClotheeSettingsTemplate(
                modifier = modifier,
                onAddressClick = {},
                onSignOutClick = { onNavigateToScreen(WgcClotheeScreen.SignIn) }
            )
        }
    }
}
