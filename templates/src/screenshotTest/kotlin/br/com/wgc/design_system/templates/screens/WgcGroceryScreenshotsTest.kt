package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcGroceryFactory
import br.com.wgc.design_system.templates.factories.WgcGroceryScreen

class WgcSupermercadoScreenshotsTest {

    @Preview(name = "Supermercado - Home Screen", showBackground = true)
    @Composable
    fun groceryHomeScreenPreview() {
        WgcGroceryFactory(screen = WgcGroceryScreen.HOME)
    }

    @Preview(name = "Supermercado - Coupons Screen", showBackground = true)
    @Composable
    fun groceryCouponsScreenPreview() {
        WgcGroceryFactory(screen = WgcGroceryScreen.COUPONS)
    }

    @Preview(name = "Supermercado - Flyer Screen", showBackground = true)
    @Composable
    fun groceryFlyerScreenPreview() {
        WgcGroceryFactory(screen = WgcGroceryScreen.FLYER)
    }

    @Preview(name = "Supermercado - Cart Screen", showBackground = true)
    @Composable
    fun groceryCartScreenPreview() {
        WgcGroceryFactory(screen = WgcGroceryScreen.CART)
    }

    @Preview(name = "Supermercado - Profile Screen", showBackground = true)
    @Composable
    fun groceryProfileScreenPreview() {
        WgcGroceryFactory(screen = WgcGroceryScreen.PROFILE)
    }
}
