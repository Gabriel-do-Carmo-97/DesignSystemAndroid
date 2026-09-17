package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.screens.megastore.auth.WgcShoppeLoginScreenTemplate
import br.com.wgc.ds_templates.screens.megastore.auth.WgcShoppeOtpRecoveryScreenTemplate
import br.com.wgc.ds_templates.screens.megastore.auth.WgcShoppePasswordScreenTemplate
import br.com.wgc.ds_templates.screens.megastore.auth.WgcShoppeStartScreenTemplate
import br.com.wgc.ds_templates.screens.megastore.chat.WgcShoppeChatScreenTemplate
import br.com.wgc.ds_templates.screens.megastore.checkout.WgcShoppeCartScreenTemplate
import br.com.wgc.ds_templates.screens.megastore.checkout.WgcShoppePaymentScreenTemplate
import br.com.wgc.ds_templates.screens.megastore.checkout.WgcShoppeToReceiveTrackingScreenTemplate
import br.com.wgc.ds_templates.screens.megastore.home.WgcShoppeHomeScreenTemplate
import br.com.wgc.ds_templates.screens.megastore.product.WgcShoppeProductDetailsScreenTemplate
import br.com.wgc.ds_templates.screens.megastore.profile.WgcShoppeProfileScreenTemplate
import br.com.wgc.ds_templates.screens.megastore.search.WgcShoppeVisualSearchScreenTemplate

/**
 * Os Principais Fluxos Oficiais do Shoppe Fashion eCommerce UI Kit.
 */
enum class WgcMegaStoreScreen {
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
 * Fábrica Universal do Shoppe eCommerce (WgcMegaStoreFactory).
 * Provê alternância instantânea entre os fluxos oficiais com defaults sensatos de produção
 * e slots customizáveis para injeção cirúrgica de componentes.
 */
@Composable
fun WgcMegaStoreFactory(
    modifier: Modifier = Modifier,
    screen: WgcMegaStoreScreen = WgcMegaStoreScreen.HomeShop,
    topBarSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null,
    onNavigate: ((WgcMegaStoreScreen) -> Unit)? = null
) {
    when (screen) {
        WgcMegaStoreScreen.Start -> {
            WgcShoppeStartScreenTemplate(
                modifier = modifier,
                onGetStartedClick = { onNavigate?.invoke(WgcMegaStoreScreen.HomeShop) },
                onLoginClick = { onNavigate?.invoke(WgcMegaStoreScreen.Login) }
            )
        }
        WgcMegaStoreScreen.Login -> {
            WgcShoppeLoginScreenTemplate(
                modifier = modifier,
                onContinueClick = { onNavigate?.invoke(WgcMegaStoreScreen.Password) },
                onCreateAccountClick = { onNavigate?.invoke(WgcMegaStoreScreen.Start) }
            )
        }
        WgcMegaStoreScreen.Password -> {
            WgcShoppePasswordScreenTemplate(
                modifier = modifier,
                onLoginClick = { onNavigate?.invoke(WgcMegaStoreScreen.HomeShop) },
                onForgotPasswordClick = { onNavigate?.invoke(WgcMegaStoreScreen.OtpRecovery) }
            )
        }
        WgcMegaStoreScreen.OtpRecovery -> {
            WgcShoppeOtpRecoveryScreenTemplate(
                modifier = modifier,
                onSubmitClick = { onNavigate?.invoke(WgcMegaStoreScreen.HomeShop) }
            )
        }
        WgcMegaStoreScreen.HomeShop -> {
            WgcShoppeHomeScreenTemplate(
                modifier = modifier,
                topBarSlot = topBarSlot,
                bottomBarSlot = bottomBarSlot,
                onCameraSearchClick = { onNavigate?.invoke(WgcMegaStoreScreen.VisualSearch) },
                onProductClick = { onNavigate?.invoke(WgcMegaStoreScreen.ProductDetails) },
                onBottomTabSelect = { index ->
                    when (index) {
                        0 -> {} // Already home
                        2 -> onNavigate?.invoke(WgcMegaStoreScreen.VisualSearch)
                        3 -> onNavigate?.invoke(WgcMegaStoreScreen.Profile)
                    }
                }
            )
        }
        WgcMegaStoreScreen.VisualSearch -> {
            WgcShoppeVisualSearchScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcMegaStoreScreen.HomeShop) },
                onViewResultsClick = { onNavigate?.invoke(WgcMegaStoreScreen.ProductDetails) }
            )
        }
        WgcMegaStoreScreen.ProductDetails -> {
            WgcShoppeProductDetailsScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcMegaStoreScreen.HomeShop) },
                onAddToCartClick = { onNavigate?.invoke(WgcMegaStoreScreen.Cart) },
                onBuyNowClick = { onNavigate?.invoke(WgcMegaStoreScreen.Payment) }
            )
        }
        WgcMegaStoreScreen.Cart -> {
            WgcShoppeCartScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcMegaStoreScreen.HomeShop) },
                onCheckoutClick = { onNavigate?.invoke(WgcMegaStoreScreen.Payment) }
            )
        }
        WgcMegaStoreScreen.Payment -> {
            WgcShoppePaymentScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcMegaStoreScreen.Cart) },
                onPayNowClick = { onNavigate?.invoke(WgcMegaStoreScreen.OrderTracking) }
            )
        }
        WgcMegaStoreScreen.OrderTracking -> {
            WgcShoppeToReceiveTrackingScreenTemplate(
                modifier = modifier,
                onContinueShoppingClick = { onNavigate?.invoke(WgcMegaStoreScreen.HomeShop) }
            )
        }
        WgcMegaStoreScreen.CustomerChat -> {
            WgcShoppeChatScreenTemplate(
                modifier = modifier,
                onBackClick = { onNavigate?.invoke(WgcMegaStoreScreen.HomeShop) }
            )
        }
        WgcMegaStoreScreen.Profile -> {
            WgcShoppeProfileScreenTemplate(
                modifier = modifier,
                onOrderSectionClick = { onNavigate?.invoke(WgcMegaStoreScreen.OrderTracking) },
                onVouchersClick = { onNavigate?.invoke(WgcMegaStoreScreen.CustomerChat) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcMegaStoreFactoryPreview() {
    WgcMegaStoreFactory(screen = WgcMegaStoreScreen.HomeShop)
}
