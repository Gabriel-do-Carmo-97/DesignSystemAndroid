package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.homeimprovement.*

enum class WgcHomeImprovementScreen {
    HOME,
    CLUBE,
    CALCULATOR,
    CART,
    PROFILE
}

@Composable
fun WgcHomeImprovementFactory(
    screen: WgcHomeImprovementScreen = WgcHomeImprovementScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcHomeImprovementScreen.HOME -> WgcLeroyMerlinHomeTemplate(modifier = modifier)
        WgcHomeImprovementScreen.CLUBE -> WgcLeroyMerlinClubeTemplate(modifier = modifier)
        WgcHomeImprovementScreen.CALCULATOR -> WgcLeroyMerlinCalculatorTemplate(modifier = modifier)
        WgcHomeImprovementScreen.CART -> WgcLeroyMerlinCartTemplate(modifier = modifier)
        WgcHomeImprovementScreen.PROFILE -> WgcLeroyMerlinProfileTemplate(modifier = modifier)
    }
}
