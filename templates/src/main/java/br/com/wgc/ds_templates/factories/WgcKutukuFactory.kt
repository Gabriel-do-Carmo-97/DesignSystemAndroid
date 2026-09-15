package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.kutuku.auth.WgcKutukuLoginScreen
import br.com.wgc.ds_templates.screens.kutuku.auth.WgcKutukuOnboardingScreen
import br.com.wgc.ds_templates.screens.kutuku.chat.WgcKutukuMessageScreen
import br.com.wgc.ds_templates.screens.kutuku.checkout.WgcKutukuCartScreen
import br.com.wgc.ds_templates.screens.kutuku.checkout.WgcKutukuPaymentScreen
import br.com.wgc.ds_templates.screens.kutuku.home.WgcKutukuCategoryScreen
import br.com.wgc.ds_templates.screens.kutuku.home.WgcKutukuHomeScreen
import br.com.wgc.ds_templates.screens.kutuku.model.KutukuMockData
import br.com.wgc.ds_templates.screens.kutuku.model.KutukuProduct
import br.com.wgc.ds_templates.screens.kutuku.product.WgcKutukuProductDetailScreen
import br.com.wgc.ds_templates.screens.kutuku.profile.WgcKutukuSettingsScreen
import br.com.wgc.ds_templates.screens.kutuku.tracking.WgcKutukuOrderTrackingScreen

/**
 * Telas suportadas pela fábrica unificada Kutuku.
 */
enum class WgcKutukuScreen {
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
 * Fábrica Universal do Ecossistema Kutuku (WgcKutukuFactory).
 * Provê renderização instantânea de qualquer tela da suíte com sensible defaults e slots de customização.
 */
@Composable
fun WgcKutukuFactory(
    screen: WgcKutukuScreen = WgcKutukuScreen.Home,
    modifier: Modifier = Modifier,
    selectedProduct: KutukuProduct = KutukuMockData.sampleProducts[2],
    onNavigateToScreen: (WgcKutukuScreen) -> Unit = {},
    customSlot: (@Composable () -> Unit)? = null
) {
    if (customSlot != null) {
        customSlot()
        return
    }

    when (screen) {
        WgcKutukuScreen.Onboarding -> {
            WgcKutukuOnboardingScreen(
                modifier = modifier,
                onGetStartedClick = { onNavigateToScreen(WgcKutukuScreen.Home) },
                onSignInClick = { onNavigateToScreen(WgcKutukuScreen.Login) }
            )
        }
        WgcKutukuScreen.Login -> {
            WgcKutukuLoginScreen(
                modifier = modifier,
                onSignInClick = { onNavigateToScreen(WgcKutukuScreen.Home) },
                onSignUpClick = { onNavigateToScreen(WgcKutukuScreen.Home) },
                onForgotPasswordClick = {}
            )
        }
        WgcKutukuScreen.Home -> {
            WgcKutukuHomeScreen(
                modifier = modifier,
                onCategoryTabSelected = { onNavigateToScreen(WgcKutukuScreen.Category) },
                onProductClick = { onNavigateToScreen(WgcKutukuScreen.ProductDetail) },
                onSeeAllClick = { onNavigateToScreen(WgcKutukuScreen.Category) }
            )
        }
        WgcKutukuScreen.Category -> {
            WgcKutukuCategoryScreen(
                modifier = modifier,
                onHomeTabSelected = { onNavigateToScreen(WgcKutukuScreen.Home) },
                onCategoryClick = { onNavigateToScreen(WgcKutukuScreen.Home) }
            )
        }
        WgcKutukuScreen.ProductDetail -> {
            WgcKutukuProductDetailScreen(
                modifier = modifier,
                product = selectedProduct,
                onBackClick = { onNavigateToScreen(WgcKutukuScreen.Home) },
                onCartClick = { onNavigateToScreen(WgcKutukuScreen.Cart) },
                onAddToCartClick = { _, _, _ -> onNavigateToScreen(WgcKutukuScreen.Cart) }
            )
        }
        WgcKutukuScreen.Cart -> {
            WgcKutukuCartScreen(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcKutukuScreen.Home) },
                onCheckoutClick = { onNavigateToScreen(WgcKutukuScreen.Payment) }
            )
        }
        WgcKutukuScreen.Payment -> {
            WgcKutukuPaymentScreen(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcKutukuScreen.Cart) },
                onCheckoutNowClick = { onNavigateToScreen(WgcKutukuScreen.OrderTracking) }
            )
        }
        WgcKutukuScreen.OrderTracking -> {
            WgcKutukuOrderTrackingScreen(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcKutukuScreen.Home) },
                onChatClick = { onNavigateToScreen(WgcKutukuScreen.Messages) },
                onMarkAsDoneClick = { onNavigateToScreen(WgcKutukuScreen.Settings) }
            )
        }
        WgcKutukuScreen.Messages -> {
            WgcKutukuMessageScreen(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcKutukuScreen.Home) },
                onMessageClick = {}
            )
        }
        WgcKutukuScreen.Settings -> {
            WgcKutukuSettingsScreen(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcKutukuScreen.Home) },
                onLogoutClick = { onNavigateToScreen(WgcKutukuScreen.Login) }
            )
        }
    }
}
