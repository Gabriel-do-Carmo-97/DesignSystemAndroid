package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.bustravel.*

enum class WgcBusTravelScreen {
    SEARCH,
    SEATS,
    TICKETS,
    CHECKOUT,
    PROFILE
}

@Composable
fun WgcBusTravelFactory(
    screen: WgcBusTravelScreen = WgcBusTravelScreen.SEARCH,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcBusTravelScreen.SEARCH -> WgcClickBusSearchTemplate(modifier = modifier)
        WgcBusTravelScreen.SEATS -> WgcClickBusSeatsTemplate(modifier = modifier)
        WgcBusTravelScreen.TICKETS -> WgcClickBusTicketsTemplate(modifier = modifier)
        WgcBusTravelScreen.CHECKOUT -> WgcClickBusCheckoutTemplate(modifier = modifier)
        WgcBusTravelScreen.PROFILE -> WgcClickBusProfileTemplate(modifier = modifier)
    }
}
