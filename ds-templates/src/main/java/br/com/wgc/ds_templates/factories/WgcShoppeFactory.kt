package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.screens.shoppe.auth.WgcShoppeLoginScreenTemplate
import br.com.wgc.ds_templates.screens.shoppe.auth.WgcShoppeOtpRecoveryScreenTemplate
import br.com.wgc.ds_templates.screens.shoppe.auth.WgcShoppePasswordScreenTemplate
import br.com.wgc.ds_templates.screens.shoppe.auth.WgcShoppeStartScreenTemplate
import br.com.wgc.ds_templates.screens.shoppe.chat.WgcShoppeChatScreenTemplate
import br.com.wgc.ds_templates.screens.shoppe.checkout.WgcShoppeCartScreenTemplate
import br.com.wgc.ds_templates.screens.shoppe.checkout.WgcShoppePaymentScreenTemplate
import br.com.wgc.ds_templates.screens.shoppe.checkout.WgcShoppeToReceiveTrackingScreenTemplate
import br.com.wgc.ds_templates.screens.shoppe.home.WgcShoppeHomeScreenTemplate
import br.com.wgc.ds_templates.screens.shoppe.product.WgcShoppeProductDetailsScreenTemplate
import br.com.wgc.ds_templates.screens.shoppe.profile.WgcShoppeProfileScreenTemplate
import br.com.wgc.ds_templates.screens.shoppe.search.WgcShoppeVisualSearchScreenTemplate

/**
 * Os Principais Fluxos Oficiais do Shoppe Fashion eCommerce UI Kit.
 */
enum class WgcShoppeScreen {
    Start,
    Login,
    Password,
    OtpRecovery,
    HomeShop,
    VisualSearch,
    ProductDetails,
    Cart,
    Payment,
    OrderTracking,
    CustomerChat,
    Profile
}

/**
 * Fábrica Universal do Shoppe eCommerce (WgcShoppeFactory).
 * Provê alternância instantânea entre os fluxos oficiais com defaults sensatos de produção
 * e slots customizáveis para injeção cirúrgica de componentes.
 */
@Composable
fun WgcShoppeFactory(
    modifier: Modifier = Modifier,
    screen: WgcShoppeScreen = WgcShoppeScreen.HomeShop,
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null,
    onNavigate: ((WgcShoppeScreen) -> Unit)? = null
) {
    when (screen) {
        WgcShoppeScreen.Start -> {
            WgcShoppeStartScreenTemplate(
                modifier = modifier,
                onGetStartedClick = { onNavigate?.invoke(WgcShoppeScreen.HomeShop) },
                onLoginClick = { onNavigate?.invoke(WgcShoppeScreen.Login) }
            )
        }
        WgcShoppeScreen.Login -> {
            WgcShoppeLoginScreenTemplate(
                modifier = modifier,
                onContinueClick = { onNavigate?.invoke(WgcShoppeScreen.Password) },
                onCreateAccountClick = { onNavigate?.invoke(WgcShoppeScreen.Start) }
            )
        }
        WgcShoppeScreen.Password -> {
            WgcShoppePasswordScreenTemplate(
                modifier = modifier,
                onLoginClick = { onNavigate?.invoke(WgcShoppeScreen.HomeShop) },
                onForgotPasswordClick = { onNavigate?.invoke(WgcShoppeScreen.OtpRecovery) }
            )
        }
        WgcShoppeScreen.OtpRecovery -> {
            WgcShoppeOtpRecoveryScreenTemplate(
                modifier = modifier,
                onSubmitClick = { onNavigate?.invoke(WgcShoppeScreen.HomeShop) }
            )
        }
        WgcShoppeScreen.HomeShop -> {
            WgcShoppeHomeScreenTemplate(
                modifier = modifier,
                topBarSlot = topBarSlot,
                bottomBarSlot = bottomBarSlot,
                onCameraSearchClick = { onNavigate?.invoke(WgcShoppeScreen.VisualSearch) },
                onProductClick = { onNavigate?.invoke(WgcShoppeScreen.ProductDetails) },
                onBottomTabSelect = { index ->
                    when (index) {
                        0 -> {} // Already home
                        2 -> onNavigate?.invoke(WgcShoppeScreen.VisualSearch)
                        3 -> onNavigate?.invoke(WgcShoppeScreen.Profile)
                    }
                }
            )
        }
        WgcShoppeScreen.VisualSearch -> {
            WgcShoppeVisualSearchScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcShoppeScreen.HomeShop) },
                onViewResultsClick = { onNavigate?.invoke(WgcShoppeScreen.ProductDetails) }
            )
        }
        WgcShoppeScreen.ProductDetails -> {
            WgcShoppeProductDetailsScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcShoppeScreen.HomeShop) },
                onAddToCartClick = { onNavigate?.invoke(WgcShoppeScreen.Cart) },
                onBuyNowClick = { onNavigate?.invoke(WgcShoppeScreen.Payment) }
            )
        }
        WgcShoppeScreen.Cart -> {
            WgcShoppeCartScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcShoppeScreen.HomeShop) },
                onCheckoutClick = { onNavigate?.invoke(WgcShoppeScreen.Payment) }
            )
        }
        WgcShoppeScreen.Payment -> {
            WgcShoppePaymentScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcShoppeScreen.Cart) },
                onPayNowClick = { onNavigate?.invoke(WgcShoppeScreen.OrderTracking) }
            )
        }
        WgcShoppeScreen.OrderTracking -> {
            WgcShoppeToReceiveTrackingScreenTemplate(
                modifier = modifier,
                onContinueShoppingClick = { onNavigate?.invoke(WgcShoppeScreen.HomeShop) }
            )
        }
        WgcShoppeScreen.CustomerChat -> {
            WgcShoppeChatScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcShoppeScreen.HomeShop) }
            )
        }
        WgcShoppeScreen.Profile -> {
            WgcShoppeProfileScreenTemplate(
                modifier = modifier,
                onOrderSectionClick = { onNavigate?.invoke(WgcShoppeScreen.OrderTracking) },
                onVouchersClick = { onNavigate?.invoke(WgcShoppeScreen.CustomerChat) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShoppeFactoryPreview() {
    WgcShoppeFactory(screen = WgcShoppeScreen.HomeShop)
}
