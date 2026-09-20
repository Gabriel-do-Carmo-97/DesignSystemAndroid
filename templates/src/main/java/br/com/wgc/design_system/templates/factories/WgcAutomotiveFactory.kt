package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.automotive.WgcAutomotiveDetailTemplate
import br.com.wgc.design_system.templates.screens.automotive.WgcAutomotiveFinancingTemplate
import br.com.wgc.design_system.templates.screens.automotive.WgcAutomotiveFipeTemplate
import br.com.wgc.design_system.templates.screens.automotive.WgcAutomotiveHomeTemplate
import br.com.wgc.design_system.templates.screens.automotive.WgcAutomotiveProfileTemplate

enum class WgcAutomotiveScreen {
    HOME,
    DETAIL,
    FIPE,
    FINANCING,
    PROFILE
}

@Composable
fun WgcAutomotiveFactory(
    screen: WgcAutomotiveScreen = WgcAutomotiveScreen.HOME,
    modifier: Modifier = Modifier,
    onNavigateToScreen: (WgcAutomotiveScreen) -> Unit = {}
) {
    when (screen) {
        WgcAutomotiveScreen.HOME -> WgcAutomotiveHomeTemplate(
            onVehicleClick = { onNavigateToScreen(WgcAutomotiveScreen.DETAIL) }
        )
        WgcAutomotiveScreen.DETAIL -> WgcAutomotiveDetailTemplate()
        WgcAutomotiveScreen.FIPE -> WgcAutomotiveFipeTemplate()
        WgcAutomotiveScreen.FINANCING -> WgcAutomotiveFinancingTemplate()
        WgcAutomotiveScreen.PROFILE -> WgcAutomotiveProfileTemplate()
    }
}
