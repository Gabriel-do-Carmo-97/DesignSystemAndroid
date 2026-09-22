package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.trendapparel.*

enum class WgcTrendApparelScreen {
    HOME,
    MIDWAY,
    DEALS,
    BAG,
    PROFILE
}

@Composable
fun WgcTrendApparelFactory(
    screen: WgcTrendApparelScreen = WgcTrendApparelScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcTrendApparelScreen.HOME -> WgcRiachueloHomeTemplate(modifier = modifier)
        WgcTrendApparelScreen.MIDWAY -> WgcRiachueloMidwayTemplate(modifier = modifier)
        WgcTrendApparelScreen.DEALS -> WgcRiachueloDealsTemplate(modifier = modifier)
        WgcTrendApparelScreen.BAG -> WgcRiachueloBagTemplate(modifier = modifier)
        WgcTrendApparelScreen.PROFILE -> WgcRiachueloProfileTemplate(modifier = modifier)
    }
}
