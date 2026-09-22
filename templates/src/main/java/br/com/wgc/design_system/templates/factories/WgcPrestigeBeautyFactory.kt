package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.prestigebeauty.*

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
        WgcPrestigeBeautyScreen.HOME -> WgcPrestigeBeautyHomeTemplate(modifier = modifier)
        WgcPrestigeBeautyScreen.CLUB -> WgcPrestigeBeautyClubTemplate(modifier = modifier)
        WgcPrestigeBeautyScreen.TUTORIALS -> WgcPrestigeBeautyTutorialsTemplate(modifier = modifier)
        WgcPrestigeBeautyScreen.BAG -> WgcPrestigeBeautyBagTemplate(modifier = modifier)
        WgcPrestigeBeautyScreen.PROFILE -> WgcPrestigeBeautyProfileTemplate(modifier = modifier)
    }
}
