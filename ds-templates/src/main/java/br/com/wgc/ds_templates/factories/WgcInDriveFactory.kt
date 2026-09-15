package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.indrive.*

enum class WgcInDriveScreen {
    NEGOTIATE,
    INTERCITY,
    BIDS,
    RATINGS,
    PROFILE
}

@Composable
fun WgcInDriveFactory(
    screen: WgcInDriveScreen = WgcInDriveScreen.NEGOTIATE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcInDriveScreen.NEGOTIATE -> WgcInDriveNegotiateTemplate(modifier = modifier)
        WgcInDriveScreen.INTERCITY -> WgcInDriveIntercityTemplate(modifier = modifier)
        WgcInDriveScreen.BIDS -> WgcInDriveBidsTemplate(modifier = modifier)
        WgcInDriveScreen.RATINGS -> WgcInDriveRatingsTemplate(modifier = modifier)
        WgcInDriveScreen.PROFILE -> WgcInDriveProfileTemplate(modifier = modifier)
    }
}
