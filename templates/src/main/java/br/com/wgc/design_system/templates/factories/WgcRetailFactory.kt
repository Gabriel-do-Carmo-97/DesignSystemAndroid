package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.retail.auth.WgcKutukuLoginScreen
import br.com.wgc.design_system.templates.screens.retail.auth.WgcKutukuOnboardingScreen
import br.com.wgc.design_system.templates.screens.retail.chat.WgcKutukuMessageScreen
import br.com.wgc.design_system.templates.screens.retail.checkout.WgcKutukuCartScreen
import br.com.wgc.design_system.templates.screens.retail.checkout.WgcKutukuPaymentScreen
import br.com.wgc.design_system.templates.screens.retail.home.WgcKutukuCategoryScreen
import br.com.wgc.design_system.templates.screens.retail.home.WgcKutukuHomeScreen
import br.com.wgc.design_system.templates.screens.retail.model.RetailMockData
import br.com.wgc.design_system.templates.screens.retail.model.KutukuProduct
import br.com.wgc.design_system.templates.screens.retail.product.WgcKutukuProductDetailScreen
import br.com.wgc.design_system.templates.screens.retail.profile.WgcKutukuSettingsScreen
import br.com.wgc.design_system.templates.screens.retail.tracking.WgcKutukuOrderTrackingScreen

/**
 * Telas suportadas pela fábrica unificada Kutuku.
 */
enum class WgcRetailScreen {
    Onboarding,
    Login,
    Home,
    Category,
    ProductDetail,
    Cart,
    Payment,
    OrderTracking,
    Messages,
    Settings
}

/**
 * Fábrica Universal do Ecossistema Kutuku (WgcRetailFactory).
 * Provê renderização instantânea de qualquer tela da suíte com sensible defaults e slots de customização.
 */
@Composable
fun WgcRetailFactory(
    screen: WgcRetailScreen = WgcRetailScreen.Home,
    modifier: Modifier = Modifier,
    selectedProduct: KutukuProduct = RetailMockData.sampleProducts[2],
    onNavigateToScreen: (WgcRetailScreen) -> Unit = {},
    customSlot: (@Composable () -> Unit)? = null
) {
    if (customSlot != null) {
        customSlot()
        return
    }

    when (screen) {
        WgcRetailScreen.Onboarding -> {
            WgcKutukuOnboardingScreen(
                modifier = modifier,
                onGetStartedClick = { onNavigateToScreen(WgcRetailScreen.Home) },
                onSignInClick = { onNavigateToScreen(WgcRetailScreen.Login) }
            )
        }
        WgcRetailScreen.Login -> {
            WgcKutukuLoginScreen(
                modifier = modifier,
                onSignInClick = { onNavigateToScreen(WgcRetailScreen.Home) },
                onSignUpClick = { onNavigateToScreen(WgcRetailScreen.Home) },
                onForgotPasswordClick = {}
            )
        }
        WgcRetailScreen.Home -> {
            WgcKutukuHomeScreen(
                modifier = modifier,
                onCategoryTabSelected = { onNavigateToScreen(WgcRetailScreen.Category) },
                onProductClick = { onNavigateToScreen(WgcRetailScreen.ProductDetail) },
                onSeeAllClick = { onNavigateToScreen(WgcRetailScreen.Category) }
            )
        }
        WgcRetailScreen.Category -> {
            WgcKutukuCategoryScreen(
                modifier = modifier,
                onHomeTabSelected = { onNavigateToScreen(WgcRetailScreen.Home) },
                onCategoryClick = { onNavigateToScreen(WgcRetailScreen.Home) }
            )
        }
        WgcRetailScreen.ProductDetail -> {
            WgcKutukuProductDetailScreen(
                modifier = modifier,
                product = selectedProduct,
                onBackClick = { onNavigateToScreen(WgcRetailScreen.Home) },
                onCartClick = { onNavigateToScreen(WgcRetailScreen.Cart) },
                onAddToCartClick = { _, _, _ -> onNavigateToScreen(WgcRetailScreen.Cart) }
            )
        }
        WgcRetailScreen.Cart -> {
            WgcKutukuCartScreen(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcRetailScreen.Home) },
                onCheckoutClick = { onNavigateToScreen(WgcRetailScreen.Payment) }
            )
        }
        WgcRetailScreen.Payment -> {
            WgcKutukuPaymentScreen(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcRetailScreen.Cart) },
                onCheckoutNowClick = { onNavigateToScreen(WgcRetailScreen.OrderTracking) }
            )
        }
        WgcRetailScreen.OrderTracking -> {
            WgcKutukuOrderTrackingScreen(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcRetailScreen.Home) },
                onChatClick = { onNavigateToScreen(WgcRetailScreen.Messages) },
                onMarkAsDoneClick = { onNavigateToScreen(WgcRetailScreen.Settings) }
            )
        }
        WgcRetailScreen.Messages -> {
            WgcKutukuMessageScreen(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcRetailScreen.Home) },
                onMessageClick = {}
            )
        }
        WgcRetailScreen.Settings -> {
            WgcKutukuSettingsScreen(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcRetailScreen.Home) },
                onLogoutClick = { onNavigateToScreen(WgcRetailScreen.Login) }
            )
        }
    }
}
