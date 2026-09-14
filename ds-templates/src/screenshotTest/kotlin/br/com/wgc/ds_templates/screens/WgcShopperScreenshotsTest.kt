package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcShopperFactory
import br.com.wgc.ds_templates.factories.WgcShopperScreen
import br.com.wgc.ds_templates.screens.shopper.cart.WgcShopperCartTemplate
import br.com.wgc.ds_templates.screens.shopper.detail.WgcShopperProductDetailTemplate
import br.com.wgc.ds_templates.screens.shopper.home.WgcShopperHomeTemplate
import br.com.wgc.ds_templates.screens.shopper.profile.WgcShopperProfileTemplate
import br.com.wgc.ds_templates.screens.shopper.splash.WgcShopperSplashTemplate

class WgcShopperScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun previewShopperSplash() {
        WgcShopperSplashTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewShopperHome() {
        WgcShopperHomeTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewShopperDetail() {
        WgcShopperProductDetailTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewShopperCart() {
        WgcShopperCartTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewShopperProfile() {
        WgcShopperProfileTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewShopperFactory() {
        WgcShopperFactory(screen = WgcShopperScreen.Home)
    }
}
