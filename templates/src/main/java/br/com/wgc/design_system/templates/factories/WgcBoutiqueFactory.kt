package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.boutique.auth.WgcLazaEmailSignInTemplate
import br.com.wgc.design_system.templates.screens.boutique.auth.WgcLazaIntroScreenTemplate
import br.com.wgc.design_system.templates.screens.boutique.auth.WgcLazaSignInScreenTemplate
import br.com.wgc.design_system.templates.screens.boutique.cart.WgcLazaCartTemplate
import br.com.wgc.design_system.templates.screens.boutique.checkout.WgcLazaOrderConfirmedTemplate
import br.com.wgc.design_system.templates.screens.boutique.home.WgcLazaHomeTemplate
import br.com.wgc.design_system.templates.screens.boutique.model.BoutiqueMockData
import br.com.wgc.design_system.templates.screens.boutique.model.LazaProduct
import br.com.wgc.design_system.templates.screens.boutique.product.WgcLazaProductDetailTemplate
import br.com.wgc.design_system.templates.screens.boutique.reviews.WgcLazaReviewsTemplate
import br.com.wgc.design_system.templates.screens.boutique.wishlist.WgcLazaWishlistTemplate

/**
 * Telas suportadas pela fábrica unificada Laza.
 */
enum class WgcBoutiqueScreen {
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
 * Fábrica Universal do Ecossistema Laza (WgcBoutiqueFactory).
 * Provê renderização instantânea de qualquer tela da suíte Laza com sensible defaults e slots de customização.
 */
@Composable
fun WgcBoutiqueFactory(
    screen: WgcBoutiqueScreen = WgcBoutiqueScreen.Home,
    modifier: Modifier = Modifier,
    selectedProduct: LazaProduct = BoutiqueMockData.products[0],
    onNavigateToScreen: (WgcBoutiqueScreen) -> Unit = {},
    customSlot: (@Composable () -> Unit)? = null
) {
    if (customSlot != null) {
        customSlot()
        return
    }

    when (screen) {
        WgcBoutiqueScreen.Intro -> {
            WgcLazaIntroScreenTemplate(
                modifier = modifier,
                onGetStartedClick = { onNavigateToScreen(WgcBoutiqueScreen.SignIn) },
                onSkipClick = { onNavigateToScreen(WgcBoutiqueScreen.Home) }
            )
        }
        WgcBoutiqueScreen.SignIn -> {
            WgcLazaSignInScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcBoutiqueScreen.Intro) },
                onEmailSignInClick = { onNavigateToScreen(WgcBoutiqueScreen.EmailSignIn) },
                onFacebookClick = { onNavigateToScreen(WgcBoutiqueScreen.Home) },
                onTwitterClick = { onNavigateToScreen(WgcBoutiqueScreen.Home) },
                onGoogleClick = { onNavigateToScreen(WgcBoutiqueScreen.Home) },
                onCreateAccountClick = { onNavigateToScreen(WgcBoutiqueScreen.EmailSignIn) }
            )
        }
        WgcBoutiqueScreen.EmailSignIn -> {
            WgcLazaEmailSignInTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcBoutiqueScreen.SignIn) },
                onSignInClick = { onNavigateToScreen(WgcBoutiqueScreen.Home) },
                onForgotPasswordClick = { /* noop */ }
            )
        }
        WgcBoutiqueScreen.Home -> {
            WgcLazaHomeTemplate(
                modifier = modifier,
                onCartClick = { onNavigateToScreen(WgcBoutiqueScreen.Cart) },
                onProductClick = { onNavigateToScreen(WgcBoutiqueScreen.ProductDetail) },
                onNavItemSelected = { index ->
                    when (index) {
                        0 -> onNavigateToScreen(WgcBoutiqueScreen.Home)
                        1 -> onNavigateToScreen(WgcBoutiqueScreen.Wishlist)
                        2 -> onNavigateToScreen(WgcBoutiqueScreen.Cart)
                        3 -> onNavigateToScreen(WgcBoutiqueScreen.Reviews)
                    }
                }
            )
        }
        WgcBoutiqueScreen.ProductDetail -> {
            WgcLazaProductDetailTemplate(
                modifier = modifier,
                product = selectedProduct,
                onBackClick = { onNavigateToScreen(WgcBoutiqueScreen.Home) },
                onCartClick = { onNavigateToScreen(WgcBoutiqueScreen.Cart) },
                onAddToCartClick = { onNavigateToScreen(WgcBoutiqueScreen.Cart) },
                onViewAllReviews = { onNavigateToScreen(WgcBoutiqueScreen.Reviews) }
            )
        }
        WgcBoutiqueScreen.Cart -> {
            WgcLazaCartTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcBoutiqueScreen.Home) },
                onCheckoutClick = { onNavigateToScreen(WgcBoutiqueScreen.OrderConfirmed) }
            )
        }
        WgcBoutiqueScreen.OrderConfirmed -> {
            WgcLazaOrderConfirmedTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcBoutiqueScreen.Cart) },
                onGoToOrdersClick = { onNavigateToScreen(WgcBoutiqueScreen.Home) },
                onContinueShoppingClick = { onNavigateToScreen(WgcBoutiqueScreen.Home) }
            )
        }
        WgcBoutiqueScreen.Wishlist -> {
            WgcLazaWishlistTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcBoutiqueScreen.Home) },
                onCartClick = { onNavigateToScreen(WgcBoutiqueScreen.Cart) },
                onProductClick = { onNavigateToScreen(WgcBoutiqueScreen.ProductDetail) },
                onNavItemSelected = { index ->
                    when (index) {
                        0 -> onNavigateToScreen(WgcBoutiqueScreen.Home)
                        1 -> onNavigateToScreen(WgcBoutiqueScreen.Wishlist)
                        2 -> onNavigateToScreen(WgcBoutiqueScreen.Cart)
                        3 -> onNavigateToScreen(WgcBoutiqueScreen.Reviews)
                    }
                }
            )
        }
        WgcBoutiqueScreen.Reviews -> {
            WgcLazaReviewsTemplate(
                modifier = modifier,
                onBackClick = { onNavigateToScreen(WgcBoutiqueScreen.ProductDetail) }
            )
        }
    }
}
