package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.verticals.freshgrocery.WgcFreshGroceryFactory
import br.com.wgc.design_system.factories.verticals.freshgrocery.WgcFreshGroceryScreen
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.cart.WgcFreshGroceryCartTemplate
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.detail.WgcFreshGroceryProductDetailTemplate
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.home.WgcFreshGroceryHomeTemplate
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.profile.WgcFreshGroceryProfileTemplate
import br.com.wgc.design_system.factories.verticals.freshgrocery.templates.splash.WgcFreshGrocerySplashTemplate

class WgcFreshGroceryScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun previewFreshGrocerySplash() {
        WgcFreshGrocerySplashTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewFreshGroceryHome() {
        WgcFreshGroceryHomeTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewFreshGroceryDetail() {
        WgcFreshGroceryProductDetailTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewFreshGroceryCart() {
        WgcFreshGroceryCartTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewFreshGroceryProfile() {
        WgcFreshGroceryProfileTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun previewFreshGroceryFactory() {
        WgcFreshGroceryFactory(screen = WgcFreshGroceryScreen.Home)
    }
}
