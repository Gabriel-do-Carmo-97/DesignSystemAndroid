package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.fintechcarbon.*

enum class WgcFintechCarbonScreen {
    HOME,
    CARBON,
    ATOMOS,
    GLOBAL,
    PROFILE
}

@Composable
fun WgcFintechCarbonFactory(
    screen: WgcFintechCarbonScreen = WgcFintechCarbonScreen.HOME,
    onNavigateScreen: (WgcFintechCarbonScreen) -> Unit = {},
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcFintechCarbonScreen.HOME -> WgcC6HomeTemplate(
            onCarbonClick = { onNavigateScreen(WgcFintechCarbonScreen.CARBON) },
            onAtomosClick = { onNavigateScreen(WgcFintechCarbonScreen.ATOMOS) },
            onGlobalClick = { onNavigateScreen(WgcFintechCarbonScreen.GLOBAL) },
            modifier = modifier
        )
        WgcFintechCarbonScreen.CARBON -> WgcC6CarbonTemplate(modifier = modifier)
        WgcFintechCarbonScreen.ATOMOS -> WgcC6AtomosTemplate(modifier = modifier)
        WgcFintechCarbonScreen.GLOBAL -> WgcC6GlobalTemplate(modifier = modifier)
        WgcFintechCarbonScreen.PROFILE -> WgcC6ProfileTemplate(modifier = modifier)
    }
}
