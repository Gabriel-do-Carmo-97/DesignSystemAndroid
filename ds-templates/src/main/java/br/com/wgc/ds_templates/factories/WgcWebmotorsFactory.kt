package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.webmotors.WgcWebmotorsDetailTemplate
import br.com.wgc.ds_templates.screens.webmotors.WgcWebmotorsFinancingTemplate
import br.com.wgc.ds_templates.screens.webmotors.WgcWebmotorsFipeTemplate
import br.com.wgc.ds_templates.screens.webmotors.WgcWebmotorsHomeTemplate
import br.com.wgc.ds_templates.screens.webmotors.WgcWebmotorsProfileTemplate

enum class WgcWebmotorsScreen {
    HOME,
    VEHICLE_DETAIL,
    FIPE_CALCULATOR,
    FINANCING,
    PROFILE
}

@Composable
fun WgcWebmotorsFactory(
    screen: WgcWebmotorsScreen = WgcWebmotorsScreen.HOME,
    modifier: Modifier = Modifier,
    onNavigateToScreen: (WgcWebmotorsScreen) -> Unit = {}
) {
    when (screen) {
        WgcWebmotorsScreen.HOME -> WgcWebmotorsHomeTemplate(
            onVehicleClick = { onNavigateToScreen(WgcWebmotorsScreen.VEHICLE_DETAIL) }
        )
        WgcWebmotorsScreen.VEHICLE_DETAIL -> WgcWebmotorsDetailTemplate(
            onSimulateFinancing = { onNavigateToScreen(WgcWebmotorsScreen.FINANCING) }
        )
        WgcWebmotorsScreen.FIPE_CALCULATOR -> WgcWebmotorsFipeTemplate()
        WgcWebmotorsScreen.FINANCING -> WgcWebmotorsFinancingTemplate()
        WgcWebmotorsScreen.PROFILE -> WgcWebmotorsProfileTemplate()
    }
}
