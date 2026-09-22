package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcFreshGroceryFactory
import br.com.wgc.design_system.templates.factories.WgcFreshGroceryScreen
import br.com.wgc.design_system.templates.screens.freshgrocery.cart.WgcFreshGroceryCartTemplate
import br.com.wgc.design_system.templates.screens.freshgrocery.detail.WgcFreshGroceryProductDetailTemplate
import br.com.wgc.design_system.templates.screens.freshgrocery.home.WgcFreshGroceryHomeTemplate
import br.com.wgc.design_system.templates.screens.freshgrocery.profile.WgcFreshGroceryProfileTemplate
import br.com.wgc.design_system.templates.screens.freshgrocery.splash.WgcFreshGrocerySplashTemplate

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
