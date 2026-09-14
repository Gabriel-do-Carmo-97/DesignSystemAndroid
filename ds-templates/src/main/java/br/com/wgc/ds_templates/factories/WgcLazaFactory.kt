package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.laza.auth.WgcLazaEmailSignInTemplate
import br.com.wgc.ds_templates.screens.laza.auth.WgcLazaIntroScreenTemplate
import br.com.wgc.ds_templates.screens.laza.auth.WgcLazaSignInTemplate
import br.com.wgc.ds_templates.screens.laza.cart.WgcLazaCartTemplate
import br.com.wgc.ds_templates.screens.laza.checkout.WgcLazaOrderConfirmedTemplate
import br.com.wgc.ds_templates.screens.laza.home.WgcLazaHomeTemplate
import br.com.wgc.ds_templates.screens.laza.model.LazaMockData
import br.com.wgc.ds_templates.screens.laza.model.LazaProduct
import br.com.wgc.ds_templates.screens.laza.product.WgcLazaProductDetailTemplate
import br.com.wgc.ds_templates.screens.laza.reviews.WgcLazaReviewsTemplate
import br.com.wgc.ds_templates.screens.laza.wishlist.WgcLazaWishlistTemplate

/**
 * Telas suportadas pela fábrica unificada Laza.
 */
enum class WgcLazaScreen {
    Intro,
    SignIn,
    EmailSignIn,
    Home,
    ProductDetail,
    Cart,
    OrderConfirmed,
    Wishlist,
    Reviews
}

/**
 * Fábrica Universal do Ecossistema Laza (WgcLazaFactory).
 * Provê renderização instantânea de qualquer tela da suíte Laza com sensible defaults e slots de customização.
 */
@Composable
fun WgcLazaFactory(
    screen: WgcLazaScreen = WgcLazaScreen.Home,
    modifier: Modifier = Modifier,
    selectedProduct: LazaProduct = LazaMockData.products[0],
    onNavigateToScreen: (WgcLazaScreen) -> Unit = {},
    customSlot: (@Composable () -> Unit)? = null
) {
    if (customSlot != null) {
        customSlot()
        return
    }

    when (screen) {
        WgcLazaScreen.Intro -> {
            WgcLazaIntroScreenTemplate(
                modifier = modifier,
                onGetStartedClick = { onNavigateToScreen(WgcLazaScreen.SignIn) },
                onSkipClick = { onNavigateToScreen(WgcLazaScreen.Home) }
            )
        }
        WgcLazaScreen.SignIn -> {
            WgcLazaSignInTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcLazaScreen.Intro) },
                onEmailSignInClick = { onNavigateToScreen(WgcLazaScreen.EmailSignIn) },
                onFacebookClick = { onNavigateToScreen(WgcLazaScreen.Home) },
                onTwitterClick = { onNavigateToScreen(WgcLazaScreen.Home) },
                onGoogleClick = { onNavigateToScreen(WgcLazaScreen.Home) },
                onCreateAccountClick = { onNavigateToScreen(WgcLazaScreen.EmailSignIn) }
            )
        }
        WgcLazaScreen.EmailSignIn -> {
            WgcLazaEmailSignInTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcLazaScreen.SignIn) },
                onSignInClick = { onNavigateToScreen(WgcLazaScreen.Home) },
                onForgotPasswordClick = { /* noop */ }
            )
        }
        WgcLazaScreen.Home -> {
            WgcLazaHomeTemplate(
                modifier = modifier,
                onCartClick = { onNavigateToScreen(WgcLazaScreen.Cart) },
                onProductClick = { onNavigateToScreen(WgcLazaScreen.ProductDetail) },
                onNavItemSelected = { index ->
                    when (index) {
                        0 -> onNavigateToScreen(WgcLazaScreen.Home)
                        1 -> onNavigateToScreen(WgcLazaScreen.Wishlist)
                        2 -> onNavigateToScreen(WgcLazaScreen.Cart)
                        3 -> onNavigateToScreen(WgcLazaScreen.Reviews)
                    }
                }
            )
        }
        WgcLazaScreen.ProductDetail -> {
            WgcLazaProductDetailTemplate(
                modifier = modifier,
                product = selectedProduct,
                onBackClick = { onNavigateToScreen(WgcLazaScreen.Home) },
                onCartClick = { onNavigateToScreen(WgcLazaScreen.Cart) },
                onAddToCartClick = { onNavigateToScreen(WgcLazaScreen.Cart) },
                onViewAllReviews = { onNavigateToScreen(WgcLazaScreen.Reviews) }
            )
        }
        WgcLazaScreen.Cart -> {
            WgcLazaCartTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcLazaScreen.Home) },
                onCheckoutClick = { onNavigateToScreen(WgcLazaScreen.OrderConfirmed) }
            )
        }
        WgcLazaScreen.OrderConfirmed -> {
            WgcLazaOrderConfirmedTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcLazaScreen.Cart) },
                onGoToOrdersClick = { onNavigateToScreen(WgcLazaScreen.Home) },
                onContinueShoppingClick = { onNavigateToScreen(WgcLazaScreen.Home) }
            )
        }
        WgcLazaScreen.Wishlist -> {
            WgcLazaWishlistTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcLazaScreen.Home) },
                onCartClick = { onNavigateToScreen(WgcLazaScreen.Cart) },
                onProductClick = { onNavigateToScreen(WgcLazaScreen.ProductDetail) },
                onNavItemSelected = { index ->
                    when (index) {
                        0 -> onNavigateToScreen(WgcLazaScreen.Home)
                        1 -> onNavigateToScreen(WgcLazaScreen.Wishlist)
                        2 -> onNavigateToScreen(WgcLazaScreen.Cart)
                        3 -> onNavigateToScreen(WgcLazaScreen.Reviews)
                    }
                }
            )
        }
        WgcLazaScreen.Reviews -> {
            WgcLazaReviewsTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcLazaScreen.ProductDetail) }
            )
        }
    }
}
