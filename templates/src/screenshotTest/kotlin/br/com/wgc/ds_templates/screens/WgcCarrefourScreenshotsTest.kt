package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcCarrefourFactory
import br.com.wgc.ds_templates.factories.WgcCarrefourScreen

class WgcCarrefourScreenshotsTest {

    @Preview(name = "Carrefour - Home Screen", showBackground = true)
    @Composable
    fun carrefourHomeScreenPreview() {
        WgcCarrefourFactory(screen = WgcCarrefourScreen.HOME)
    }

    @Preview(name = "Carrefour - Coupons Screen", showBackground = true)
    @Composable
    fun carrefourCouponsScreenPreview() {
        WgcCarrefourFactory(screen = WgcCarrefourScreen.COUPONS)
    }

    @Preview(name = "Carrefour - Flyer Screen", showBackground = true)
    @Composable
    fun carrefourFlyerScreenPreview() {
        WgcCarrefourFactory(screen = WgcCarrefourScreen.FLYER)
    }

    @Preview(name = "Carrefour - Cart Screen", showBackground = true)
    @Composable
    fun carrefourCartScreenPreview() {
        WgcCarrefourFactory(screen = WgcCarrefourScreen.CART)
    }

    @Preview(name = "Carrefour - Profile Screen", showBackground = true)
    @Composable
    fun carrefourProfileScreenPreview() {
        WgcCarrefourFactory(screen = WgcCarrefourScreen.PROFILE)
    }
}
