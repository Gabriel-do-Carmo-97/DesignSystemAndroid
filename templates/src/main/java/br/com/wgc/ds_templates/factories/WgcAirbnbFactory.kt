package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.airbnb.*

enum class WgcAirbnbScreen {
    EXPLORE,
    DETAILS,
    MESSAGES,
    TRIPS,
    PROFILE
}

@Composable
fun WgcAirbnbFactory(
    screen: WgcAirbnbScreen = WgcAirbnbScreen.EXPLORE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcAirbnbScreen.EXPLORE -> WgcAirbnbExploreTemplate(modifier = modifier)
        WgcAirbnbScreen.DETAILS -> WgcAirbnbDetailsTemplate(modifier = modifier)
        WgcAirbnbScreen.MESSAGES -> WgcAirbnbMessagesTemplate(modifier = modifier)
        WgcAirbnbScreen.TRIPS -> WgcAirbnbTripsTemplate(modifier = modifier)
        WgcAirbnbScreen.PROFILE -> WgcAirbnbProfileTemplate(modifier = modifier)
    }
}
