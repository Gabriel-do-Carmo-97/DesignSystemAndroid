package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcPdaFactory
import br.com.wgc.ds_templates.factories.WgcPdaScreen

class WgcPdaScreenshotsTest {

    @Preview(name = "PDA - Home Screen", showBackground = true)
    @Composable
    fun pdaHomeScreenPreview() {
        WgcPdaFactory(screen = WgcPdaScreen.HOME)
    }

    @Preview(name = "PDA - Adega Screen", showBackground = true)
    @Composable
    fun pdaAdegaScreenPreview() {
        WgcPdaFactory(screen = WgcPdaScreen.ADEGA)
    }

    @Preview(name = "PDA - Discounts Screen", showBackground = true)
    @Composable
    fun pdaDiscountsScreenPreview() {
        WgcPdaFactory(screen = WgcPdaScreen.DISCOUNTS)
    }

    @Preview(name = "PDA - Cart Screen", showBackground = true)
    @Composable
    fun pdaCartScreenPreview() {
        WgcPdaFactory(screen = WgcPdaScreen.CART)
    }

    @Preview(name = "PDA - Profile Screen", showBackground = true)
    @Composable
    fun pdaProfileScreenPreview() {
        WgcPdaFactory(screen = WgcPdaScreen.PROFILE)
    }
}
