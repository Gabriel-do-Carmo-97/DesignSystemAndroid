package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.transitdigital.*

enum class WgcTransitDigitalScreen {
    CNH,
    CRLV,
    INFRACTIONS,
    POINTS,
    PROFILE
}

@Composable
fun WgcTransitDigitalFactory(
    screen: WgcTransitDigitalScreen = WgcTransitDigitalScreen.CNH,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcTransitDigitalScreen.CNH -> WgcCdtCnhTemplate(modifier = modifier)
        WgcTransitDigitalScreen.CRLV -> WgcCdtCrlvTemplate(modifier = modifier)
        WgcTransitDigitalScreen.INFRACTIONS -> WgcCdtInfractionsTemplate(modifier = modifier)
        WgcTransitDigitalScreen.POINTS -> WgcCdtPointsTemplate(modifier = modifier)
        WgcTransitDigitalScreen.PROFILE -> WgcCdtProfileTemplate(modifier = modifier)
    }
}
