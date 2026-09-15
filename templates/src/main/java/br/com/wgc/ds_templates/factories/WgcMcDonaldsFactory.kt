package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.mcdonalds.*

enum class WgcMcDonaldsScreen {
    MENU,
    CUPONS,
    LOYALTY,
    CART,
    PROFILE
}

@Composable
fun WgcMcDonaldsFactory(
    screen: WgcMcDonaldsScreen = WgcMcDonaldsScreen.MENU,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcMcDonaldsScreen.MENU -> WgcMcDonaldsMenuTemplate(modifier = modifier)
        WgcMcDonaldsScreen.CUPONS -> WgcMcDonaldsCuponsTemplate(modifier = modifier)
        WgcMcDonaldsScreen.LOYALTY -> WgcMcDonaldsLoyaltyTemplate(modifier = modifier)
        WgcMcDonaldsScreen.CART -> WgcMcDonaldsCartTemplate(modifier = modifier)
        WgcMcDonaldsScreen.PROFILE -> WgcMcDonaldsProfileTemplate(modifier = modifier)
    }
}
