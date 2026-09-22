package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.naturalbeauty.*

enum class WgcNaturalBeautyScreen {
    HOME,
    CONSULTANT,
    REFILLS,
    BAG,
    PROFILE
}

@Composable
fun WgcNaturalBeautyFactory(
    screen: WgcNaturalBeautyScreen = WgcNaturalBeautyScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcNaturalBeautyScreen.HOME -> WgcNaturaHomeTemplate(modifier = modifier)
        WgcNaturalBeautyScreen.CONSULTANT -> WgcNaturaConsultantTemplate(modifier = modifier)
        WgcNaturalBeautyScreen.REFILLS -> WgcNaturaRefillsTemplate(modifier = modifier)
        WgcNaturalBeautyScreen.BAG -> WgcNaturaBagTemplate(modifier = modifier)
        WgcNaturalBeautyScreen.PROFILE -> WgcNaturaProfileTemplate(modifier = modifier)
    }
}
