package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.nubank.*

enum class WgcNubankScreen {
    HOME,
    PIX,
    CARDS,
    INVESTMENTS,
    PROFILE
}

@Composable
fun WgcNubankFactory(
    screen: WgcNubankScreen = WgcNubankScreen.HOME,
    onNavigateScreen: (WgcNubankScreen) -> Unit = {},
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcNubankScreen.HOME -> WgcNubankHomeTemplate(
            onPixClick = { onNavigateScreen(WgcNubankScreen.PIX) },
            onCreditCardClick = { onNavigateScreen(WgcNubankScreen.CARDS) },
            modifier = modifier
        )
        WgcNubankScreen.PIX -> WgcNubankPixTemplate(
            modifier = modifier
        )
        WgcNubankScreen.CARDS -> WgcNubankCardTemplate(
            modifier = modifier
        )
        WgcNubankScreen.INVESTMENTS -> WgcNubankInvestTemplate(
            modifier = modifier
        )
        WgcNubankScreen.PROFILE -> WgcNubankProfileTemplate(
            modifier = modifier
        )
    }
}
