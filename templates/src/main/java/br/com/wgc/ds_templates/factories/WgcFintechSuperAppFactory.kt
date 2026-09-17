package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.fintechsuperapp.*

enum class WgcFintechSuperAppScreen {
    HOME,
    SHOP,
    CARDS,
    INVEST,
    PROFILE
}

@Composable
fun WgcFintechSuperAppFactory(
    screen: WgcFintechSuperAppScreen = WgcFintechSuperAppScreen.HOME,
    onNavigateScreen: (WgcFintechSuperAppScreen) -> Unit = {},
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcFintechSuperAppScreen.HOME -> WgcInterHomeTemplate(
            onShopClick = { onNavigateScreen(WgcFintechSuperAppScreen.SHOP) },
            onInvestClick = { onNavigateScreen(WgcFintechSuperAppScreen.INVEST) },
            onCardClick = { onNavigateScreen(WgcFintechSuperAppScreen.CARDS) },
            modifier = modifier
        )
        WgcFintechSuperAppScreen.SHOP -> WgcInterShopTemplate(modifier = modifier)
        WgcFintechSuperAppScreen.CARDS -> WgcInterCardTemplate(modifier = modifier)
        WgcFintechSuperAppScreen.INVEST -> WgcInterInvestTemplate(modifier = modifier)
        WgcFintechSuperAppScreen.PROFILE -> WgcInterProfileTemplate(modifier = modifier)
    }
}
