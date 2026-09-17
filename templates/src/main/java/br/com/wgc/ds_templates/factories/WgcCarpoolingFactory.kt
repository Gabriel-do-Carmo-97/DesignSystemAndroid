package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.carpooling.*

enum class WgcCarpoolingScreen {
    SEARCH,
    OFFER,
    BOOKINGS,
    ALERTS,
    PROFILE
}

@Composable
fun WgcCarpoolingFactory(
    screen: WgcCarpoolingScreen = WgcCarpoolingScreen.SEARCH,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcCarpoolingScreen.SEARCH -> WgcCarpoolingSearchTemplate(modifier = modifier)
        WgcCarpoolingScreen.OFFER -> WgcCarpoolingOfferTemplate(modifier = modifier)
        WgcCarpoolingScreen.BOOKINGS -> WgcCarpoolingBookingsTemplate(modifier = modifier)
        WgcCarpoolingScreen.ALERTS -> WgcCarpoolingAlertsTemplate(modifier = modifier)
        WgcCarpoolingScreen.PROFILE -> WgcCarpoolingProfileTemplate(modifier = modifier)
    }
}
