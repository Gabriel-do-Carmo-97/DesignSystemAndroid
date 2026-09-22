package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.fintechneobank.*

enum class WgcFintechNeobankScreen {
    HOME,
    PIX,
    CARDS,
    INVESTMENTS,
    PROFILE
}

@Composable
fun WgcFintechNeobankFactory(
    screen: WgcFintechNeobankScreen = WgcFintechNeobankScreen.HOME,
    onNavigateScreen: (WgcFintechNeobankScreen) -> Unit = {},
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcFintechNeobankScreen.HOME -> WgcNeobankHomeTemplate(
            onPixClick = { onNavigateScreen(WgcFintechNeobankScreen.PIX) },
            onCreditCardClick = { onNavigateScreen(WgcFintechNeobankScreen.CARDS) },
            modifier = modifier
        )
        WgcFintechNeobankScreen.PIX -> WgcNeobankPixTemplate(
            modifier = modifier
        )
        WgcFintechNeobankScreen.CARDS -> WgcNeobankCardTemplate(
            modifier = modifier
        )
        WgcFintechNeobankScreen.INVESTMENTS -> WgcNeobankInvestTemplate(
            modifier = modifier
        )
        WgcFintechNeobankScreen.PROFILE -> WgcNeobankProfileTemplate(
            modifier = modifier
        )
    }
}
