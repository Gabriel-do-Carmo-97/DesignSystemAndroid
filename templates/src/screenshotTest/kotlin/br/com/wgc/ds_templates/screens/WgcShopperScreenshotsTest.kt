package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcFreshGroceryFactory
import br.com.wgc.ds_templates.factories.WgcFreshGroceryScreen
import br.com.wgc.ds_templates.screens.freshgrocery.cart.WgcShopperCartTemplate
import br.com.wgc.ds_templates.screens.freshgrocery.detail.WgcShopperProductDetailTemplate
import br.com.wgc.ds_templates.screens.freshgrocery.home.WgcShopperHomeTemplate
import br.com.wgc.ds_templates.screens.freshgrocery.profile.WgcShopperProfileTemplate
import br.com.wgc.ds_templates.screens.freshgrocery.splash.WgcShopperSplashTemplate

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
        WgcFreshGroceryFactory(screen = WgcFreshGroceryScreen.Home)
    }
}
