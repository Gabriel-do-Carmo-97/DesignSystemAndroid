package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.urbanmobility.*

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
        WgcUrbanMobilityScreen.REQUEST -> WgcNoveNoveRideRequestTemplate(modifier = modifier)
        WgcUrbanMobilityScreen.WALLET -> WgcNoveNovePayTemplate(modifier = modifier)
        WgcUrbanMobilityScreen.HISTORY -> WgcNoveNoveHistoryTemplate(modifier = modifier)
        WgcUrbanMobilityScreen.COUPONS -> WgcNoveNoveCouponsTemplate(modifier = modifier)
        WgcUrbanMobilityScreen.PROFILE -> WgcNoveNoveProfileTemplate(modifier = modifier)
    }
}
