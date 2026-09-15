package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.clickbus.*

enum class WgcClickBusScreen {
    SEARCH,
    SEATS,
    TICKETS,
    CHECKOUT,
    PROFILE
}

@Composable
fun WgcClickBusFactory(
    screen: WgcClickBusScreen = WgcClickBusScreen.SEARCH,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcClickBusScreen.SEARCH -> WgcClickBusSearchTemplate(modifier = modifier)
        WgcClickBusScreen.SEATS -> WgcClickBusSeatsTemplate(modifier = modifier)
        WgcClickBusScreen.TICKETS -> WgcClickBusTicketsTemplate(modifier = modifier)
        WgcClickBusScreen.CHECKOUT -> WgcClickBusCheckoutTemplate(modifier = modifier)
        WgcClickBusScreen.PROFILE -> WgcClickBusProfileTemplate(modifier = modifier)
    }
}
