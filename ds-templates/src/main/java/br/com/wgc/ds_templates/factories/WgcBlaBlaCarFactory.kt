package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.blablacar.*

enum class WgcBlaBlaCarScreen {
    SEARCH,
    OFFER,
    BOOKINGS,
    ALERTS,
    PROFILE
}

@Composable
fun WgcBlaBlaCarFactory(
    screen: WgcBlaBlaCarScreen = WgcBlaBlaCarScreen.SEARCH,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcBlaBlaCarScreen.SEARCH -> WgcBlaBlaCarSearchTemplate(modifier = modifier)
        WgcBlaBlaCarScreen.OFFER -> WgcBlaBlaCarOfferTemplate(modifier = modifier)
        WgcBlaBlaCarScreen.BOOKINGS -> WgcBlaBlaCarBookingsTemplate(modifier = modifier)
        WgcBlaBlaCarScreen.ALERTS -> WgcBlaBlaCarAlertsTemplate(modifier = modifier)
        WgcBlaBlaCarScreen.PROFILE -> WgcBlaBlaCarProfileTemplate(modifier = modifier)
    }
}
