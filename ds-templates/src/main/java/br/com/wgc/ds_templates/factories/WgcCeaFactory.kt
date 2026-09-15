package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.cea.*

enum class WgcCeaScreen {
    HOME,
    CLUBE,
    SEARCH,
    BAG,
    PROFILE
}

@Composable
fun WgcCeaFactory(
    screen: WgcCeaScreen = WgcCeaScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcCeaScreen.HOME -> WgcCeaHomeTemplate(modifier = modifier)
        WgcCeaScreen.CLUBE -> WgcCeaClubeTemplate(modifier = modifier)
        WgcCeaScreen.SEARCH -> WgcCeaSearchTemplate(modifier = modifier)
        WgcCeaScreen.BAG -> WgcCeaBagTemplate(modifier = modifier)
        WgcCeaScreen.PROFILE -> WgcCeaProfileTemplate(modifier = modifier)
    }
}
