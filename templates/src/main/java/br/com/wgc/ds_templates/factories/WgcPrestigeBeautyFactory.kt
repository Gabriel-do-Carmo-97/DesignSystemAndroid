package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.prestigebeauty.*

enum class WgcPrestigeBeautyScreen {
    HOME,
    CLUB,
    TUTORIALS,
    BAG,
    PROFILE
}

@Composable
fun WgcPrestigeBeautyFactory(
    screen: WgcPrestigeBeautyScreen = WgcPrestigeBeautyScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcPrestigeBeautyScreen.HOME -> WgcSephoraHomeTemplate(modifier = modifier)
        WgcPrestigeBeautyScreen.CLUB -> WgcSephoraClubTemplate(modifier = modifier)
        WgcPrestigeBeautyScreen.TUTORIALS -> WgcSephoraTutorialsTemplate(modifier = modifier)
        WgcPrestigeBeautyScreen.BAG -> WgcSephoraBagTemplate(modifier = modifier)
        WgcPrestigeBeautyScreen.PROFILE -> WgcSephoraProfileTemplate(modifier = modifier)
    }
}
