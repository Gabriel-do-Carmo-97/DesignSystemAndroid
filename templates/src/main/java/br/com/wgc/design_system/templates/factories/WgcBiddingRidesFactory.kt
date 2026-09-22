package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.biddingrides.*

enum class WgcBiddingRidesScreen {
    NEGOTIATE,
    INTERCITY,
    BIDS,
    RATINGS,
    PROFILE
}

@Composable
fun WgcBiddingRidesFactory(
    screen: WgcBiddingRidesScreen = WgcBiddingRidesScreen.NEGOTIATE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcBiddingRidesScreen.NEGOTIATE -> WgcInDriveNegotiateTemplate(modifier = modifier)
        WgcBiddingRidesScreen.INTERCITY -> WgcInDriveIntercityTemplate(modifier = modifier)
        WgcBiddingRidesScreen.BIDS -> WgcInDriveBidsTemplate(modifier = modifier)
        WgcBiddingRidesScreen.RATINGS -> WgcInDriveRatingsTemplate(modifier = modifier)
        WgcBiddingRidesScreen.PROFILE -> WgcInDriveProfileTemplate(modifier = modifier)
    }
}
