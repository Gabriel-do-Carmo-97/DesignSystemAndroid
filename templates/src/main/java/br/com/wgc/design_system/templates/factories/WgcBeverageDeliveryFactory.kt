package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.beveragedelivery.templates.WgcBeverageDeliveryCartTemplate
import br.com.wgc.design_system.factories.verticals.beveragedelivery.templates.WgcBeverageDeliveryColdTrackerTemplate
import br.com.wgc.design_system.factories.verticals.beveragedelivery.templates.WgcBeverageDeliveryHomeTemplate
import br.com.wgc.design_system.factories.verticals.beveragedelivery.templates.WgcBeverageDeliveryOffersTemplate
import br.com.wgc.design_system.factories.verticals.beveragedelivery.templates.WgcBeverageDeliveryProfileTemplate

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
