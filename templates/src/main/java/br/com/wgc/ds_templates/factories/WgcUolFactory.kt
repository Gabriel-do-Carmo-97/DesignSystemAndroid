package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.uol.*

enum class WgcUolScreen {
    HOME,
    ECONOMY,
    SPORTS,
    OPINION,
    PROFILE
}

@Composable
fun WgcUolFactory(
    screen: WgcUolScreen = WgcUolScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcUolScreen.HOME -> WgcUolHomeTemplate(modifier = modifier)
        WgcUolScreen.ECONOMY -> WgcUolEconomyTemplate(modifier = modifier)
        WgcUolScreen.SPORTS -> WgcUolSportsTemplate(modifier = modifier)
        WgcUolScreen.OPINION -> WgcUolOpinionTemplate(modifier = modifier)
        WgcUolScreen.PROFILE -> WgcUolProfileTemplate(modifier = modifier)
    }
}
