package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcExtraFactory
import br.com.wgc.ds_templates.factories.WgcExtraScreen
import br.com.wgc.ds_templates.screens.extra.cart.WgcExtraCartTemplate
import br.com.wgc.ds_templates.screens.extra.discounts.WgcExtraDiscountsTemplate
import br.com.wgc.ds_templates.screens.extra.flyer.WgcExtraFlyerTemplate
import br.com.wgc.ds_templates.screens.extra.home.WgcExtraHomeTemplate
import br.com.wgc.ds_templates.screens.extra.loyalty.WgcExtraLoyaltyTemplate
import br.com.wgc.ds_templates.screens.extra.model.ExtraCartItem
import br.com.wgc.ds_templates.screens.extra.model.ExtraMockData

class WgcExtraScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraHome() {
        WgcExtraHomeTemplate(
            user = ExtraMockData.mockUser,
            products = ExtraMockData.mockProducts
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraDiscounts() {
        WgcExtraDiscountsTemplate(
            coupons = ExtraMockData.mockCoupons,
            userCpfMasked = "***.482.918-**"
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraFlyer() {
        WgcExtraFlyerTemplate(
            products = ExtraMockData.mockProducts
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraCart() {
        WgcExtraCartTemplate(
            cartItems = listOf(
                ExtraCartItem(ExtraMockData.mockProducts[0], 1),
                ExtraCartItem(ExtraMockData.mockProducts[1], 2),
                ExtraCartItem(ExtraMockData.mockProducts[2], 6)
            )
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraLoyalty() {
        WgcExtraLoyaltyTemplate(
            stamps = ExtraMockData.mockStamps
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewExtraFactory() {
        WgcExtraFactory(screen = WgcExtraScreen.HOME)
    }
}
