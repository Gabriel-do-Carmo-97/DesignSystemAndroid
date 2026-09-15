package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.decolar.*

enum class WgcDecolarScreen {
    PACKAGES,
    HOTELS,
    PASSPORT,
    TRIPS,
    PROFILE
}

@Composable
fun WgcDecolarFactory(
    screen: WgcDecolarScreen = WgcDecolarScreen.PACKAGES,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcDecolarScreen.PACKAGES -> WgcDecolarPackagesTemplate(modifier = modifier)
        WgcDecolarScreen.HOTELS -> WgcDecolarHotelsTemplate(modifier = modifier)
        WgcDecolarScreen.PASSPORT -> WgcDecolarPassportTemplate(modifier = modifier)
        WgcDecolarScreen.TRIPS -> WgcDecolarTripsTemplate(modifier = modifier)
        WgcDecolarScreen.PROFILE -> WgcDecolarProfileTemplate(modifier = modifier)
    }
}
