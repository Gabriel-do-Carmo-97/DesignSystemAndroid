package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.natura.*

enum class WgcNaturaScreen {
    HOME,
    CONSULTANT,
    REFILLS,
    BAG,
    PROFILE
}

@Composable
fun WgcNaturaFactory(
    screen: WgcNaturaScreen = WgcNaturaScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcNaturaScreen.HOME -> WgcNaturaHomeTemplate(modifier = modifier)
        WgcNaturaScreen.CONSULTANT -> WgcNaturaConsultantTemplate(modifier = modifier)
        WgcNaturaScreen.REFILLS -> WgcNaturaRefillsTemplate(modifier = modifier)
        WgcNaturaScreen.BAG -> WgcNaturaBagTemplate(modifier = modifier)
        WgcNaturaScreen.PROFILE -> WgcNaturaProfileTemplate(modifier = modifier)
    }
}
