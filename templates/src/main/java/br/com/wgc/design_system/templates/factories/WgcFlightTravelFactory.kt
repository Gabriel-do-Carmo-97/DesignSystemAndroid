package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.flighttravel.*

enum class WgcFlightTravelScreen {
    PACKAGES,
    HOTELS,
    PASSPORT,
    TRIPS,
    PROFILE
}

@Composable
fun WgcFlightTravelFactory(
    screen: WgcFlightTravelScreen = WgcFlightTravelScreen.PACKAGES,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcFlightTravelScreen.PACKAGES -> WgcDecolarPackagesTemplate(modifier = modifier)
        WgcFlightTravelScreen.HOTELS -> WgcDecolarHotelsTemplate(modifier = modifier)
        WgcFlightTravelScreen.PASSPORT -> WgcDecolarPassportTemplate(modifier = modifier)
        WgcFlightTravelScreen.TRIPS -> WgcDecolarTripsTemplate(modifier = modifier)
        WgcFlightTravelScreen.PROFILE -> WgcDecolarProfileTemplate(modifier = modifier)
    }
}
