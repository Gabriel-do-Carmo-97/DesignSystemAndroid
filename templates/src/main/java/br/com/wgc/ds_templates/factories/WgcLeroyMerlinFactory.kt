package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.leroymerlin.*

enum class WgcLeroyMerlinScreen {
    HOME,
    CLUBE,
    CALCULATOR,
    CART,
    PROFILE
}

@Composable
fun WgcLeroyMerlinFactory(
    screen: WgcLeroyMerlinScreen = WgcLeroyMerlinScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcLeroyMerlinScreen.HOME -> WgcLeroyMerlinHomeTemplate(modifier = modifier)
        WgcLeroyMerlinScreen.CLUBE -> WgcLeroyMerlinClubeTemplate(modifier = modifier)
        WgcLeroyMerlinScreen.CALCULATOR -> WgcLeroyMerlinCalculatorTemplate(modifier = modifier)
        WgcLeroyMerlinScreen.CART -> WgcLeroyMerlinCartTemplate(modifier = modifier)
        WgcLeroyMerlinScreen.PROFILE -> WgcLeroyMerlinProfileTemplate(modifier = modifier)
    }
}
