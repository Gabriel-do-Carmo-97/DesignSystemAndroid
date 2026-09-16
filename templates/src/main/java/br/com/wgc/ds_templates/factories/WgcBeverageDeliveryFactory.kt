package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.beveragedelivery.WgcBeverageDeliveryCartTemplate
import br.com.wgc.ds_templates.screens.beveragedelivery.WgcBeverageDeliveryColdTrackerTemplate
import br.com.wgc.ds_templates.screens.beveragedelivery.WgcBeverageDeliveryHomeTemplate
import br.com.wgc.ds_templates.screens.beveragedelivery.WgcBeverageDeliveryOffersTemplate
import br.com.wgc.ds_templates.screens.beveragedelivery.WgcBeverageDeliveryProfileTemplate

enum class WgcBeverageDeliveryScreen {
    HOME,
    COLD_TRACKER,
    OFFERS,
    CART,
    PROFILE
}

@Composable
fun WgcBeverageDeliveryFactory(
    screen: WgcBeverageDeliveryScreen = WgcBeverageDeliveryScreen.HOME,
    modifier: Modifier = Modifier,
    onNavigateToScreen: (WgcBeverageDeliveryScreen) -> Unit = {}
) {
    when (screen) {
        WgcBeverageDeliveryScreen.HOME -> WgcBeverageDeliveryHomeTemplate()
        WgcBeverageDeliveryScreen.COLD_TRACKER -> WgcBeverageDeliveryColdTrackerTemplate()
        WgcBeverageDeliveryScreen.OFFERS -> WgcBeverageDeliveryOffersTemplate()
        WgcBeverageDeliveryScreen.CART -> WgcBeverageDeliveryCartTemplate()
        WgcBeverageDeliveryScreen.PROFILE -> WgcBeverageDeliveryProfileTemplate()
    }
}
