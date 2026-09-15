package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.dominos.*

enum class WgcDominosScreen {
    BUILD,
    TRACKER,
    OFFERS,
    CART,
    PROFILE
}

@Composable
fun WgcDominosFactory(
    screen: WgcDominosScreen = WgcDominosScreen.BUILD,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcDominosScreen.BUILD -> WgcDominosBuildTemplate(modifier = modifier)
        WgcDominosScreen.TRACKER -> WgcDominosTrackerTemplate(modifier = modifier)
        WgcDominosScreen.OFFERS -> WgcDominosOffersTemplate(modifier = modifier)
        WgcDominosScreen.CART -> WgcDominosCartTemplate(modifier = modifier)
        WgcDominosScreen.PROFILE -> WgcDominosProfileTemplate(modifier = modifier)
    }
}
