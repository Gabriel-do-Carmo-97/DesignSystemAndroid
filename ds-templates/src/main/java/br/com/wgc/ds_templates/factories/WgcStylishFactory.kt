package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.screens.stylish.auth.WgcStylishForgotPasswordScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.auth.WgcStylishLoginScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.auth.WgcStylishRegisterScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.catalog.WgcStylishProductDetailsScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.catalog.WgcStylishTrendingScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.checkout.WgcStylishCheckoutScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.checkout.WgcStylishPlaceOrderScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.checkout.WgcStylishShippingScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.checkout.WgcStylishSuccessScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.home.WgcStylishHomeScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.onboarding.WgcStylishGetStartedScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.onboarding.WgcStylishOnboardingScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.onboarding.WgcStylishSplashScreenTemplate
import br.com.wgc.ds_templates.screens.stylish.profile.WgcStylishProfileScreenTemplate

/**
 * As 16 Telas Oficiais do Stylish eCommerce UI Kit.
 */
enum class WgcStylishScreen {
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
 * Fábrica Universal do Stylish eCommerce (WgcStylishFactory).
 * Provê alternância instantânea entre as 16 telas com defaults sensatos de produção
 * e slots customizáveis para injeção cirúrgica de componentes.
 */
@Composable
fun WgcStylishFactory(
    modifier: Modifier = Modifier,
    screen: WgcStylishScreen = WgcStylishScreen.Home,
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null,
    onNavigate: ((WgcStylishScreen) -> Unit)? = null
) {
    when (screen) {
        WgcStylishScreen.Splash -> {
            WgcStylishSplashScreenTemplate(
                modifier = modifier,
                onTimeout = { onNavigate?.invoke(WgcStylishScreen.OnboardingStep1) }
            )
        }
        WgcStylishScreen.OnboardingStep1 -> {
            WgcStylishOnboardingScreenTemplate(
                modifier = modifier,
                step = 1,
                onNextClick = { onNavigate?.invoke(WgcStylishScreen.OnboardingStep2) },
                onSkipClick = { onNavigate?.invoke(WgcStylishScreen.GetStarted) }
            )
        }
        WgcStylishScreen.OnboardingStep2 -> {
            WgcStylishOnboardingScreenTemplate(
                modifier = modifier,
                step = 2,
                onNextClick = { onNavigate?.invoke(WgcStylishScreen.OnboardingStep3) },
                onSkipClick = { onNavigate?.invoke(WgcStylishScreen.GetStarted) }
            )
        }
        WgcStylishScreen.OnboardingStep3 -> {
            WgcStylishOnboardingScreenTemplate(
                modifier = modifier,
                step = 3,
                onNextClick = { onNavigate?.invoke(WgcStylishScreen.GetStarted) },
                onSkipClick = { onNavigate?.invoke(WgcStylishScreen.GetStarted) }
            )
        }
        WgcStylishScreen.GetStarted -> {
            WgcStylishGetStartedScreenTemplate(
                modifier = modifier,
                onGetStartedClick = { onNavigate?.invoke(WgcStylishScreen.SignIn) }
            )
        }
        WgcStylishScreen.SignIn -> {
            WgcStylishLoginScreenTemplate(
                modifier = modifier,
                onLoginClick = { onNavigate?.invoke(WgcStylishScreen.Home) },
                onSignUpClick = { onNavigate?.invoke(WgcStylishScreen.SignUp) },
                onForgotPasswordClick = { onNavigate?.invoke(WgcStylishScreen.ForgotPassword) }
            )
        }
        WgcStylishScreen.SignUp -> {
            WgcStylishRegisterScreenTemplate(
                modifier = modifier,
                onCreateAccountClick = { onNavigate?.invoke(WgcStylishScreen.Home) },
                onSignInClick = { onNavigate?.invoke(WgcStylishScreen.SignIn) }
            )
        }
        WgcStylishScreen.ForgotPassword -> {
            WgcStylishForgotPasswordScreenTemplate(
                modifier = modifier,
                onSubmitClick = { onNavigate?.invoke(WgcStylishScreen.SignIn) },
                onBackToLoginClick = { onNavigate?.invoke(WgcStylishScreen.SignIn) }
            )
        }
        WgcStylishScreen.Home -> {
            WgcStylishHomeScreenTemplate(
                modifier = modifier,
                topBarSlot = topBarSlot,
                bottomBarSlot = bottomBarSlot,
                onProductClick = { onNavigate?.invoke(WgcStylishScreen.ProductDetails) },
                onViewAllDealsClick = { onNavigate?.invoke(WgcStylishScreen.Trending) }
            )
        }
        WgcStylishScreen.Trending -> {
            WgcStylishTrendingScreenTemplate(
                modifier = modifier,
                onProductClick = { onNavigate?.invoke(WgcStylishScreen.ProductDetails) }
            )
        }
        WgcStylishScreen.ProductDetails -> {
            WgcStylishProductDetailsScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcStylishScreen.Home) },
                onGoToCartClick = { onNavigate?.invoke(WgcStylishScreen.Checkout) },
                onBuyNowClick = { onNavigate?.invoke(WgcStylishScreen.Checkout) }
            )
        }
        WgcStylishScreen.Checkout -> {
            WgcStylishCheckoutScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcStylishScreen.ProductDetails) },
                onChangeAddressClick = { onNavigate?.invoke(WgcStylishScreen.Profile) },
                onProceedToPaymentClick = { onNavigate?.invoke(WgcStylishScreen.PlaceOrder) }
            )
        }
        WgcStylishScreen.PlaceOrder -> {
            WgcStylishPlaceOrderScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcStylishScreen.Checkout) },
                onContinueClick = { onNavigate?.invoke(WgcStylishScreen.Shipping) }
            )
        }
        WgcStylishScreen.Shipping -> {
            WgcStylishShippingScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcStylishScreen.PlaceOrder) },
                onConfirmPaymentClick = { onNavigate?.invoke(WgcStylishScreen.Success) }
            )
        }
        WgcStylishScreen.Success -> {
            WgcStylishSuccessScreenTemplate(
                modifier = modifier,
                onContinueShoppingClick = { onNavigate?.invoke(WgcStylishScreen.Home) }
            )
        }
        WgcStylishScreen.Profile -> {
            WgcStylishProfileScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcStylishScreen.Home) },
                onSaveClick = { onNavigate?.invoke(WgcStylishScreen.Home) }
            )
        }
    }
}

@Preview(name = "Stylish Factory - Home", showBackground = true)
@Composable
private fun WgcStylishFactoryHomePreview() {
    WgcStylishFactory(screen = WgcStylishScreen.Home)
}

@Preview(name = "Stylish Factory - Checkout", showBackground = true)
@Composable
private fun WgcStylishFactoryCheckoutPreview() {
    WgcStylishFactory(screen = WgcStylishScreen.Checkout)
}
