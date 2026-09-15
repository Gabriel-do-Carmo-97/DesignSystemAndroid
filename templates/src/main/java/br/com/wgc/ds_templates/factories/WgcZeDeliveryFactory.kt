package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.zedelivery.WgcZeDeliveryCartTemplate
import br.com.wgc.ds_templates.screens.zedelivery.WgcZeDeliveryColdTrackerTemplate
import br.com.wgc.ds_templates.screens.zedelivery.WgcZeDeliveryHomeTemplate
import br.com.wgc.ds_templates.screens.zedelivery.WgcZeDeliveryOffersTemplate
import br.com.wgc.ds_templates.screens.zedelivery.WgcZeDeliveryProfileTemplate

enum class WgcZeDeliveryScreen {
    HOME,
    COLD_TRACKER,
    OFFERS,
    CART,
    PROFILE
}

@Composable
fun WgcZeDeliveryFactory(
    screen: WgcZeDeliveryScreen = WgcZeDeliveryScreen.HOME,
    modifier: Modifier = Modifier,
    onNavigateToScreen: (WgcZeDeliveryScreen) -> Unit = {}
) {
    when (screen) {
        WgcZeDeliveryScreen.HOME -> WgcZeDeliveryHomeTemplate(
            onAddToCart = { onNavigateToScreen(WgcZeDeliveryScreen.CART) }
        )
        WgcZeDeliveryScreen.COLD_TRACKER -> WgcZeDeliveryColdTrackerTemplate()
        WgcZeDeliveryScreen.OFFERS -> WgcZeDeliveryOffersTemplate()
        WgcZeDeliveryScreen.CART -> WgcZeDeliveryCartTemplate(
            onCheckout = { onNavigateToScreen(WgcZeDeliveryScreen.COLD_TRACKER) }
        )
        WgcZeDeliveryScreen.PROFILE -> WgcZeDeliveryProfileTemplate()
    }
}
