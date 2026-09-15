package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.inter.*

enum class WgcInterScreen {
    HOME,
    SHOP,
    CARDS,
    INVEST,
    PROFILE
}

@Composable
fun WgcInterFactory(
    screen: WgcInterScreen = WgcInterScreen.HOME,
    onNavigateScreen: (WgcInterScreen) -> Unit = {},
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcInterScreen.HOME -> WgcInterHomeTemplate(
            onShopClick = { onNavigateScreen(WgcInterScreen.SHOP) },
            onInvestClick = { onNavigateScreen(WgcInterScreen.INVEST) },
            onCardClick = { onNavigateScreen(WgcInterScreen.CARDS) },
            modifier = modifier
        )
        WgcInterScreen.SHOP -> WgcInterShopTemplate(modifier = modifier)
        WgcInterScreen.CARDS -> WgcInterCardTemplate(modifier = modifier)
        WgcInterScreen.INVEST -> WgcInterInvestTemplate(modifier = modifier)
        WgcInterScreen.PROFILE -> WgcInterProfileTemplate(modifier = modifier)
    }
}
