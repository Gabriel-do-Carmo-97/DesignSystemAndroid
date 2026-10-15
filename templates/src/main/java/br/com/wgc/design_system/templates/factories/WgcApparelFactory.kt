package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.verticals.apparel.templates.auth.WgcClotheeForgotPasswordTemplate
import br.com.wgc.design_system.factories.verticals.apparel.templates.auth.WgcClotheeResetPasswordSentTemplate
import br.com.wgc.design_system.factories.verticals.apparel.templates.auth.WgcClotheeSignInTemplate
import br.com.wgc.design_system.factories.verticals.apparel.templates.cart.WgcClotheeCartTemplate
import br.com.wgc.design_system.factories.verticals.apparel.templates.categories.WgcClotheeCategoryListTemplate
import br.com.wgc.design_system.factories.verticals.apparel.templates.checkout.WgcClotheeOrderPlacedTemplate
import br.com.wgc.design_system.factories.verticals.apparel.templates.home.WgcClotheeHomeTemplate
import br.com.wgc.design_system.factories.verticals.apparel.templates.model.ApparelMockData
import br.com.wgc.design_system.factories.verticals.apparel.templates.model.ClotheeProduct
import br.com.wgc.design_system.factories.verticals.apparel.templates.product.WgcClotheeProductDetailTemplate
import br.com.wgc.design_system.factories.verticals.apparel.templates.profile.WgcClotheeSettingsTemplate
import br.com.wgc.design_system.factories.verticals.apparel.templates.tracking.WgcClotheeTrackOrderTemplate

/**
 * Telas suportadas pela fábrica unificada Clothee.
 */
enum class WgcApparelScreen {
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
 * Fábrica Universal do Ecossistema Clothee (WgcApparelFactory).
 * Provê renderização instantânea de qualquer tela da suíte com sensible defaults e slots de customização.
 */
@Composable
fun WgcApparelFactory(
    screen: WgcApparelScreen = WgcApparelScreen.Home,
    modifier: Modifier = Modifier,
    selectedProduct: ClotheeProduct = ApparelMockData.products[0],
    onNavigateToScreen: (WgcApparelScreen) -> Unit = {},
    customSlot: (@Composable () -> Unit)? = null
) {
    if (customSlot != null) {
        customSlot()
        return
    }

    when (screen) {
        WgcApparelScreen.SignIn -> {
            WgcClotheeSignInTemplate(
                modifier = modifier,
                onContinueClick = { onNavigateToScreen(WgcApparelScreen.Home) },
                onForgotPasswordClick = { onNavigateToScreen(WgcApparelScreen.ForgotPassword) }
            )
        }
        WgcApparelScreen.ForgotPassword -> {
            WgcClotheeForgotPasswordTemplate(
                modifier = modifier,
                onContinueClick = { onNavigateToScreen(WgcApparelScreen.ResetPasswordSent) },
                onBackClick = { onNavigateToScreen(WgcApparelScreen.SignIn) }
            )
        }
        WgcApparelScreen.ResetPasswordSent -> {
            WgcClotheeResetPasswordSentTemplate(
                modifier = modifier,
                onReturnToLoginClick = { onNavigateToScreen(WgcApparelScreen.SignIn) }
            )
        }
        WgcApparelScreen.Home -> {
            WgcClotheeHomeTemplate(
                modifier = modifier,
                onCartClick = { onNavigateToScreen(WgcApparelScreen.Cart) },
                onSeeAllCategories = { onNavigateToScreen(WgcApparelScreen.CategoryList) },
                onCategoryClick = { onNavigateToScreen(WgcApparelScreen.CategoryList) },
                onProductClick = { onNavigateToScreen(WgcApparelScreen.ProductDetail) },
                onNavItemSelected = { index ->
                    when (index) {
                        0 -> onNavigateToScreen(WgcApparelScreen.Home)
                        1 -> onNavigateToScreen(WgcApparelScreen.CategoryList)
                        2 -> onNavigateToScreen(WgcApparelScreen.TrackOrder)
                        3 -> onNavigateToScreen(WgcApparelScreen.Settings)
                    }
                }
            )
        }
        WgcApparelScreen.CategoryList -> {
            WgcClotheeCategoryListTemplate(
                modifier = modifier,
                onCategoryClick = { onNavigateToScreen(WgcApparelScreen.Home) },
                onBackClick = { onNavigateToScreen(WgcApparelScreen.Home) }
            )
        }
        WgcApparelScreen.ProductDetail -> {
            WgcClotheeProductDetailTemplate(
                modifier = modifier,
                product = selectedProduct,
                onAddToCart = { onNavigateToScreen(WgcApparelScreen.Cart) },
                onBackClick = { onNavigateToScreen(WgcApparelScreen.Home) }
            )
        }
        WgcApparelScreen.Cart -> {
            WgcClotheeCartTemplate(
                modifier = modifier,
                onCheckoutClick = { onNavigateToScreen(WgcApparelScreen.OrderPlaced) },
                onBackClick = { onNavigateToScreen(WgcApparelScreen.Home) }
            )
        }
        WgcApparelScreen.OrderPlaced -> {
            WgcClotheeOrderPlacedTemplate(
                modifier = modifier,
                onSeeOrderDetailsClick = { onNavigateToScreen(WgcApparelScreen.TrackOrder) }
            )
        }
        WgcApparelScreen.TrackOrder -> {
            WgcClotheeTrackOrderTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcApparelScreen.Home) },
                onViewItemsClick = { onNavigateToScreen(WgcApparelScreen.Cart) }
            )
        }
        WgcApparelScreen.Settings -> {
            WgcClotheeSettingsTemplate(
                modifier = modifier,
                onAddressClick = {},
                onSignOutClick = { onNavigateToScreen(WgcApparelScreen.SignIn) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcApparelFactoryPreview() = WgcApparelFactory()

@Preview(name = "WgcApparelFactory - SignIn", showBackground = true)
@Composable
private fun WgcApparelFactorySignInPreview() = WgcApparelFactory(screen = WgcApparelScreen.SignIn)

@Preview(name = "WgcApparelFactory - ForgotPassword", showBackground = true)
@Composable
private fun WgcApparelFactoryForgotPasswordPreview() = WgcApparelFactory(screen = WgcApparelScreen.ForgotPassword)

@Preview(name = "WgcApparelFactory - ResetPasswordSent", showBackground = true)
@Composable
private fun WgcApparelFactoryResetPasswordSentPreview() = WgcApparelFactory(screen = WgcApparelScreen.ResetPasswordSent)

@Preview(name = "WgcApparelFactory - Home", showBackground = true)
@Composable
private fun WgcApparelFactoryHomePreview() = WgcApparelFactory(screen = WgcApparelScreen.Home)

@Preview(name = "WgcApparelFactory - CategoryList", showBackground = true)
@Composable
private fun WgcApparelFactoryCategoryListPreview() = WgcApparelFactory(screen = WgcApparelScreen.CategoryList)

@Preview(name = "WgcApparelFactory - ProductDetail", showBackground = true)
@Composable
private fun WgcApparelFactoryProductDetailPreview() = WgcApparelFactory(screen = WgcApparelScreen.ProductDetail)

@Preview(name = "WgcApparelFactory - Cart", showBackground = true)
@Composable
private fun WgcApparelFactoryCartPreview() = WgcApparelFactory(screen = WgcApparelScreen.Cart)

@Preview(name = "WgcApparelFactory - OrderPlaced", showBackground = true)
@Composable
private fun WgcApparelFactoryOrderPlacedPreview() = WgcApparelFactory(screen = WgcApparelScreen.OrderPlaced)

@Preview(name = "WgcApparelFactory - TrackOrder", showBackground = true)
@Composable
private fun WgcApparelFactoryTrackOrderPreview() = WgcApparelFactory(screen = WgcApparelScreen.TrackOrder)

@Preview(name = "WgcApparelFactory - Settings", showBackground = true)
@Composable
private fun WgcApparelFactorySettingsPreview() = WgcApparelFactory(screen = WgcApparelScreen.Settings)
