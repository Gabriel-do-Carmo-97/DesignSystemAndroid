package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.cdt.*

enum class WgcCdtScreen {
    CNH,
    CRLV,
    INFRACTIONS,
    POINTS,
    PROFILE
}

@Composable
fun WgcCdtFactory(
    screen: WgcCdtScreen = WgcCdtScreen.CNH,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcCdtScreen.CNH -> WgcCdtCnhTemplate(modifier = modifier)
        WgcCdtScreen.CRLV -> WgcCdtCrlvTemplate(modifier = modifier)
        WgcCdtScreen.INFRACTIONS -> WgcCdtInfractionsTemplate(modifier = modifier)
        WgcCdtScreen.POINTS -> WgcCdtPointsTemplate(modifier = modifier)
        WgcCdtScreen.PROFILE -> WgcCdtProfileTemplate(modifier = modifier)
    }
}
