package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.madeiramadeira.*

enum class WgcMadeiraMadeiraScreen {
    HOME,
    PLANNED,
    SHIPPING,
    CART,
    PROFILE
}

@Composable
fun WgcMadeiraMadeiraFactory(
    screen: WgcMadeiraMadeiraScreen = WgcMadeiraMadeiraScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcMadeiraMadeiraScreen.HOME -> WgcMadeiraMadeiraHomeTemplate(modifier = modifier)
        WgcMadeiraMadeiraScreen.PLANNED -> WgcMadeiraMadeiraPlannedTemplate(modifier = modifier)
        WgcMadeiraMadeiraScreen.SHIPPING -> WgcMadeiraMadeiraShippingTemplate(modifier = modifier)
        WgcMadeiraMadeiraScreen.CART -> WgcMadeiraMadeiraCartTemplate(modifier = modifier)
        WgcMadeiraMadeiraScreen.PROFILE -> WgcMadeiraMadeiraProfileTemplate(modifier = modifier)
    }
}
