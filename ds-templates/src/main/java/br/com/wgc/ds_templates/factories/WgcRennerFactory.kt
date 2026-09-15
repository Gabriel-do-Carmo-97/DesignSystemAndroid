package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.renner.*

enum class WgcRennerScreen {
    HOME,
    COLLECTIONS,
    CARD,
    BAG,
    PROFILE
}

@Composable
fun WgcRennerFactory(
    screen: WgcRennerScreen = WgcRennerScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcRennerScreen.HOME -> WgcRennerHomeTemplate(modifier = modifier)
        WgcRennerScreen.COLLECTIONS -> WgcRennerCollectionsTemplate(modifier = modifier)
        WgcRennerScreen.CARD -> WgcRennerCardTemplate(modifier = modifier)
        WgcRennerScreen.BAG -> WgcRennerBagTemplate(modifier = modifier)
        WgcRennerScreen.PROFILE -> WgcRennerProfileTemplate(modifier = modifier)
    }
}
