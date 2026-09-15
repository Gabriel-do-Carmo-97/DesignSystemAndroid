package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.riachuelo.*

enum class WgcRiachueloScreen {
    HOME,
    MIDWAY,
    DEALS,
    BAG,
    PROFILE
}

@Composable
fun WgcRiachueloFactory(
    screen: WgcRiachueloScreen = WgcRiachueloScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcRiachueloScreen.HOME -> WgcRiachueloHomeTemplate(modifier = modifier)
        WgcRiachueloScreen.MIDWAY -> WgcRiachueloMidwayTemplate(modifier = modifier)
        WgcRiachueloScreen.DEALS -> WgcRiachueloDealsTemplate(modifier = modifier)
        WgcRiachueloScreen.BAG -> WgcRiachueloBagTemplate(modifier = modifier)
        WgcRiachueloScreen.PROFILE -> WgcRiachueloProfileTemplate(modifier = modifier)
    }
}
