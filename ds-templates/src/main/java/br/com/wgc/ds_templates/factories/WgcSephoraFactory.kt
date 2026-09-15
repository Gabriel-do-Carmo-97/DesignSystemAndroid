package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.sephora.*

enum class WgcSephoraScreen {
    HOME,
    CLUB,
    TUTORIALS,
    BAG,
    PROFILE
}

@Composable
fun WgcSephoraFactory(
    screen: WgcSephoraScreen = WgcSephoraScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcSephoraScreen.HOME -> WgcSephoraHomeTemplate(modifier = modifier)
        WgcSephoraScreen.CLUB -> WgcSephoraClubTemplate(modifier = modifier)
        WgcSephoraScreen.TUTORIALS -> WgcSephoraTutorialsTemplate(modifier = modifier)
        WgcSephoraScreen.BAG -> WgcSephoraBagTemplate(modifier = modifier)
        WgcSephoraScreen.PROFILE -> WgcSephoraProfileTemplate(modifier = modifier)
    }
}
