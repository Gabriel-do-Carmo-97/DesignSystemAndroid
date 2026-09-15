package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.c6.*

enum class WgcC6Screen {
    HOME,
    CARBON,
    ATOMOS,
    GLOBAL,
    PROFILE
}

@Composable
fun WgcC6Factory(
    screen: WgcC6Screen = WgcC6Screen.HOME,
    onNavigateScreen: (WgcC6Screen) -> Unit = {},
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcC6Screen.HOME -> WgcC6HomeTemplate(
            onCarbonClick = { onNavigateScreen(WgcC6Screen.CARBON) },
            onAtomosClick = { onNavigateScreen(WgcC6Screen.ATOMOS) },
            onGlobalClick = { onNavigateScreen(WgcC6Screen.GLOBAL) },
            modifier = modifier
        )
        WgcC6Screen.CARBON -> WgcC6CarbonTemplate(modifier = modifier)
        WgcC6Screen.ATOMOS -> WgcC6AtomosTemplate(modifier = modifier)
        WgcC6Screen.GLOBAL -> WgcC6GlobalTemplate(modifier = modifier)
        WgcC6Screen.PROFILE -> WgcC6ProfileTemplate(modifier = modifier)
    }
}
