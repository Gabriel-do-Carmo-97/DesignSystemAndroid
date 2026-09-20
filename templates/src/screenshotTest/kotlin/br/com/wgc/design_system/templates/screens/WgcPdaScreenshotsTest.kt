package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcPremiumGroceryFactory
import br.com.wgc.design_system.templates.factories.WgcPremiumGroceryScreen

class WgcPdaScreenshotsTest {

    @Preview(name = "PDA - Home Screen", showBackground = true)
    @Composable
    fun pdaHomeScreenPreview() {
        WgcPremiumGroceryFactory(screen = WgcPremiumGroceryScreen.HOME)
    }

    @Preview(name = "PDA - Adega Screen", showBackground = true)
    @Composable
    fun pdaAdegaScreenPreview() {
        WgcPremiumGroceryFactory(screen = WgcPremiumGroceryScreen.ADEGA)
    }

    @Preview(name = "PDA - Discounts Screen", showBackground = true)
    @Composable
    fun pdaDiscountsScreenPreview() {
        WgcPremiumGroceryFactory(screen = WgcPremiumGroceryScreen.DISCOUNTS)
    }

    @Preview(name = "PDA - Cart Screen", showBackground = true)
    @Composable
    fun pdaCartScreenPreview() {
        WgcPremiumGroceryFactory(screen = WgcPremiumGroceryScreen.CART)
    }

    @Preview(name = "PDA - Profile Screen", showBackground = true)
    @Composable
    fun pdaProfileScreenPreview() {
        WgcPremiumGroceryFactory(screen = WgcPremiumGroceryScreen.PROFILE)
    }
}
