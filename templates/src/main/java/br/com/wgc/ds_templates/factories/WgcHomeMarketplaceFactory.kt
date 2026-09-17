package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.homemarketplace.*

enum class WgcHomeMarketplaceScreen {
    HOME,
    PLANNED,
    SHIPPING,
    CART,
    PROFILE
}

@Composable
fun WgcHomeMarketplaceFactory(
    screen: WgcHomeMarketplaceScreen = WgcHomeMarketplaceScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcHomeMarketplaceScreen.HOME -> WgcMadeiraMadeiraHomeTemplate(modifier = modifier)
        WgcHomeMarketplaceScreen.PLANNED -> WgcMadeiraMadeiraPlannedTemplate(modifier = modifier)
        WgcHomeMarketplaceScreen.SHIPPING -> WgcMadeiraMadeiraShippingTemplate(modifier = modifier)
        WgcHomeMarketplaceScreen.CART -> WgcMadeiraMadeiraCartTemplate(modifier = modifier)
        WgcHomeMarketplaceScreen.PROFILE -> WgcMadeiraMadeiraProfileTemplate(modifier = modifier)
    }
}
