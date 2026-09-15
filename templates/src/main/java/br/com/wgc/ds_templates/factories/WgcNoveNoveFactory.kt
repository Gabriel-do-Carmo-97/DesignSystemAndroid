package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.novenove.*

enum class WgcNoveNoveScreen {
    REQUEST,
    WALLET,
    HISTORY,
    COUPONS,
    PROFILE
}

@Composable
fun WgcNoveNoveFactory(
    screen: WgcNoveNoveScreen = WgcNoveNoveScreen.REQUEST,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcNoveNoveScreen.REQUEST -> WgcNoveNoveRideRequestTemplate(modifier = modifier)
        WgcNoveNoveScreen.WALLET -> WgcNoveNovePayTemplate(modifier = modifier)
        WgcNoveNoveScreen.HISTORY -> WgcNoveNoveHistoryTemplate(modifier = modifier)
        WgcNoveNoveScreen.COUPONS -> WgcNoveNoveCouponsTemplate(modifier = modifier)
        WgcNoveNoveScreen.PROFILE -> WgcNoveNoveProfileTemplate(modifier = modifier)
    }
}
