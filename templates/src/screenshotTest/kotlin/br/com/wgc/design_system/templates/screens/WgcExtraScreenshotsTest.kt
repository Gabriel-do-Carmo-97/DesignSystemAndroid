package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcHypermarketFactory
import br.com.wgc.design_system.templates.factories.WgcHypermarketScreen
import br.com.wgc.design_system.templates.screens.hypermarket.cart.WgcExtraCartTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.discounts.WgcExtraDiscountsTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.flyer.WgcExtraFlyerTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.home.WgcExtraHomeTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.loyalty.WgcExtraLoyaltyTemplate
import br.com.wgc.design_system.templates.screens.hypermarket.model.ExtraCartItem
import br.com.wgc.design_system.templates.screens.hypermarket.model.HypermarketMockData

class WgcExtraScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraHome() {
        WgcExtraHomeTemplate(
            user = HypermarketMockData.mockUser,
            products = HypermarketMockData.mockProducts
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraDiscounts() {
        WgcExtraDiscountsTemplate(
            coupons = HypermarketMockData.mockCoupons,
            userCpfMasked = "***.482.918-**"
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraFlyer() {
        WgcExtraFlyerTemplate(
            products = HypermarketMockData.mockProducts
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraCart() {
        WgcExtraCartTemplate(
            cartItems = listOf(
                ExtraCartItem(HypermarketMockData.mockProducts[0], 1),
                ExtraCartItem(HypermarketMockData.mockProducts[1], 2),
                ExtraCartItem(HypermarketMockData.mockProducts[2], 6)
            )
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraLoyalty() {
        WgcExtraLoyaltyTemplate(
            stamps = HypermarketMockData.mockStamps
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraFactory() {
        WgcHypermarketFactory(screen = WgcHypermarketScreen.HOME)
    }
}
