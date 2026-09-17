package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.screens.trendfashion.auth.WgcStylishForgotPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.auth.WgcStylishLoginScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.auth.WgcStylishRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.catalog.WgcStylishProductDetailsScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.catalog.WgcStylishTrendingScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.checkout.WgcStylishCheckoutScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.checkout.WgcStylishPlaceOrderScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.checkout.WgcStylishShippingScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.checkout.WgcStylishSuccessScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.home.WgcStylishHomeScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.onboarding.WgcStylishGetStartedScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.onboarding.WgcStylishOnboardingScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.onboarding.WgcStylishSplashScreenTemplate
import br.com.wgc.ds_templates.screens.trendfashion.profile.WgcStylishProfileScreenTemplate

/**
 * As 16 Telas Oficiais do Stylish eCommerce UI Kit.
 */
enum class WgcTrendFashionScreen {
    Splash,
    OnboardingStep1,
    OnboardingStep2,
    OnboardingStep3,
    GetStarted,
    SignIn,
    SignUp,
    ForgotPassword,
    Home,
    Trending,
    ProductDetails,
    Checkout,
    PlaceOrder,
    Shipping,
    Success,
    Profile
}

/**
 * Fábrica Universal do Stylish eCommerce (WgcTrendFashionFactory).
 * Provê alternância instantânea entre as 16 telas com defaults sensatos de produção
 * e slots customizáveis para injeção cirúrgica de componentes.
 */
@Composable
fun WgcTrendFashionFactory(
    modifier: Modifier = Modifier,
    screen: WgcTrendFashionScreen = WgcTrendFashionScreen.Home,
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null,
    onNavigate: ((WgcTrendFashionScreen) -> Unit)? = null
) {
    when (screen) {
        WgcTrendFashionScreen.Splash -> {
            WgcStylishSplashScreenTemplate(
                modifier = modifier,
                onTimeout = { onNavigate?.invoke(WgcTrendFashionScreen.OnboardingStep1) }
            )
        }
        WgcTrendFashionScreen.OnboardingStep1 -> {
            WgcStylishOnboardingScreenTemplate(
                modifier = modifier,
                step = 1,
                onNextClick = { onNavigate?.invoke(WgcTrendFashionScreen.OnboardingStep2) },
                onSkipClick = { onNavigate?.invoke(WgcTrendFashionScreen.GetStarted) }
            )
        }
        WgcTrendFashionScreen.OnboardingStep2 -> {
            WgcStylishOnboardingScreenTemplate(
                modifier = modifier,
                step = 2,
                onNextClick = { onNavigate?.invoke(WgcTrendFashionScreen.OnboardingStep3) },
                onSkipClick = { onNavigate?.invoke(WgcTrendFashionScreen.GetStarted) }
            )
        }
        WgcTrendFashionScreen.OnboardingStep3 -> {
            WgcStylishOnboardingScreenTemplate(
                modifier = modifier,
                step = 3,
                onNextClick = { onNavigate?.invoke(WgcTrendFashionScreen.GetStarted) },
                onSkipClick = { onNavigate?.invoke(WgcTrendFashionScreen.GetStarted) }
            )
        }
        WgcTrendFashionScreen.GetStarted -> {
            WgcStylishGetStartedScreenTemplate(
                modifier = modifier,
                onGetStartedClick = { onNavigate?.invoke(WgcTrendFashionScreen.SignIn) }
            )
        }
        WgcTrendFashionScreen.SignIn -> {
            WgcStylishLoginScreenTemplate(
                modifier = modifier,
                onLoginClick = { onNavigate?.invoke(WgcTrendFashionScreen.Home) },
                onSignUpClick = { onNavigate?.invoke(WgcTrendFashionScreen.SignUp) },
                onForgotPasswordClick = { onNavigate?.invoke(WgcTrendFashionScreen.ForgotPassword) }
            )
        }
        WgcTrendFashionScreen.SignUp -> {
            WgcStylishRegisterScreenTemplate(
                modifier = modifier,
                onCreateAccountClick = { onNavigate?.invoke(WgcTrendFashionScreen.Home) },
                onSignInClick = { onNavigate?.invoke(WgcTrendFashionScreen.SignIn) }
            )
        }
        WgcTrendFashionScreen.ForgotPassword -> {
            WgcStylishForgotPasswordScreenTemplate(
                modifier = modifier,
                onSubmitClick = { onNavigate?.invoke(WgcTrendFashionScreen.SignIn) },
                onBackToLoginClick = { onNavigate?.invoke(WgcTrendFashionScreen.SignIn) }
            )
        }
        WgcTrendFashionScreen.Home -> {
            WgcStylishHomeScreenTemplate(
                modifier = modifier,
                topBarSlot = topBarSlot,
                bottomBarSlot = bottomBarSlot,
                onProductClick = { onNavigate?.invoke(WgcTrendFashionScreen.ProductDetails) },
                onViewAllDealsClick = { onNavigate?.invoke(WgcTrendFashionScreen.Trending) }
            )
        }
        WgcTrendFashionScreen.Trending -> {
            WgcStylishTrendingScreenTemplate(
                modifier = modifier,
                onProductClick = { onNavigate?.invoke(WgcTrendFashionScreen.ProductDetails) }
            )
        }
        WgcTrendFashionScreen.ProductDetails -> {
            WgcStylishProductDetailsScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcTrendFashionScreen.Home) },
                onGoToCartClick = { onNavigate?.invoke(WgcTrendFashionScreen.Checkout) },
                onBuyNowClick = { onNavigate?.invoke(WgcTrendFashionScreen.Checkout) }
            )
        }
        WgcTrendFashionScreen.Checkout -> {
            WgcStylishCheckoutScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcTrendFashionScreen.ProductDetails) },
                onChangeAddressClick = { onNavigate?.invoke(WgcTrendFashionScreen.Profile) },
                onProceedToPaymentClick = { onNavigate?.invoke(WgcTrendFashionScreen.PlaceOrder) }
            )
        }
        WgcTrendFashionScreen.PlaceOrder -> {
            WgcStylishPlaceOrderScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcTrendFashionScreen.Checkout) },
                onContinueClick = { onNavigate?.invoke(WgcTrendFashionScreen.Shipping) }
            )
        }
        WgcTrendFashionScreen.Shipping -> {
            WgcStylishShippingScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcTrendFashionScreen.PlaceOrder) },
                onConfirmPaymentClick = { onNavigate?.invoke(WgcTrendFashionScreen.Success) }
            )
        }
        WgcTrendFashionScreen.Success -> {
            WgcStylishSuccessScreenTemplate(
                modifier = modifier,
                onContinueShoppingClick = { onNavigate?.invoke(WgcTrendFashionScreen.Home) }
            )
        }
        WgcTrendFashionScreen.Profile -> {
            WgcStylishProfileScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcTrendFashionScreen.Home) },
                onSaveClick = { onNavigate?.invoke(WgcTrendFashionScreen.Home) }
            )
        }
    }
}

@Preview(name = "Stylish Factory - Home", showBackground = true)
@Composable
private fun WgcTrendFashionFactoryHomePreview() {
    WgcTrendFashionFactory(screen = WgcTrendFashionScreen.Home)
}

@Preview(name = "Stylish Factory - Checkout", showBackground = true)
@Composable
private fun WgcTrendFashionFactoryCheckoutPreview() {
    WgcTrendFashionFactory(screen = WgcTrendFashionScreen.Checkout)
}
