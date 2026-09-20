package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.urbanmobility.*

enum class WgcUrbanMobilityScreen {
    REQUEST,
    WALLET,
    HISTORY,
    COUPONS,
    PROFILE
}

@Composable
fun WgcUrbanMobilityFactory(
    screen: WgcUrbanMobilityScreen = WgcUrbanMobilityScreen.REQUEST,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcUrbanMobilityScreen.REQUEST -> WgcUrbanMobilityRideRequestTemplate(modifier = modifier)
        WgcUrbanMobilityScreen.WALLET -> WgcUrbanMobilityPayTemplate(modifier = modifier)
        WgcUrbanMobilityScreen.HISTORY -> WgcUrbanMobilityHistoryTemplate(modifier = modifier)
        WgcUrbanMobilityScreen.COUPONS -> WgcUrbanMobilityCouponsTemplate(modifier = modifier)
        WgcUrbanMobilityScreen.PROFILE -> WgcUrbanMobilityProfileTemplate(modifier = modifier)
    }
}
