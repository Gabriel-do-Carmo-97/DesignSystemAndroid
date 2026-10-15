package br.com.wgc.design_system.factories.verticals.pizza

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.pizza.templates.*

enum class WgcPizzaScreen {
    BUILD,
    TRACKER,
    OFFERS,
    CART,
    PROFILE
}

@Composable
fun WgcPizzaFactory(
    screen: WgcPizzaScreen = WgcPizzaScreen.BUILD,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcPizzaScreen.BUILD -> WgcPizzaBuildTemplate(modifier = modifier)
        WgcPizzaScreen.TRACKER -> WgcPizzaTrackerTemplate(modifier = modifier)
        WgcPizzaScreen.OFFERS -> WgcPizzaOffersTemplate(modifier = modifier)
        WgcPizzaScreen.CART -> WgcPizzaCartTemplate(modifier = modifier)
        WgcPizzaScreen.PROFILE -> WgcPizzaProfileTemplate(modifier = modifier)
    }
}
