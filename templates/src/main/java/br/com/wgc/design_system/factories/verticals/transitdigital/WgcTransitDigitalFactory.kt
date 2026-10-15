package br.com.wgc.design_system.factories.verticals.transitdigital

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.transitdigital.templates.*

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
