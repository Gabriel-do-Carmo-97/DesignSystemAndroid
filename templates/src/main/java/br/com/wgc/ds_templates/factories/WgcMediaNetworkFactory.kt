package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.medianetwork.*

enum class WgcMediaNetworkScreen {
    HOME,
    ECONOMY,
    SPORTS,
    OPINION,
    PROFILE
}

@Composable
fun WgcMediaNetworkFactory(
    screen: WgcMediaNetworkScreen = WgcMediaNetworkScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcMediaNetworkScreen.HOME -> WgcUolHomeTemplate(modifier = modifier)
        WgcMediaNetworkScreen.ECONOMY -> WgcUolEconomyTemplate(modifier = modifier)
        WgcMediaNetworkScreen.SPORTS -> WgcUolSportsTemplate(modifier = modifier)
        WgcMediaNetworkScreen.OPINION -> WgcUolOpinionTemplate(modifier = modifier)
        WgcMediaNetworkScreen.PROFILE -> WgcUolProfileTemplate(modifier = modifier)
    }
}
