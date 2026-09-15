package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.denticare.DentiCareMockData
import br.com.wgc.ds_templates.screens.denticare.WgcDentiCareAppointmentTemplate
import br.com.wgc.ds_templates.screens.denticare.WgcDentiCareHomeTemplate
import br.com.wgc.ds_templates.screens.denticare.WgcDentiCareOdontogramTemplate
import br.com.wgc.ds_templates.screens.denticare.WgcDentiCareProfileTemplate
import br.com.wgc.ds_templates.screens.denticare.WgcDentiCareXRayTemplate

enum class WgcDentiCareScreen {
    HOME,
    ODONTOGRAM,
    XRAY_HISTORY,
    APPOINTMENT,
    PROFILE
}

@Composable
fun WgcDentiCareFactory(
    screen: WgcDentiCareScreen = WgcDentiCareScreen.HOME,
    modifier: Modifier = Modifier,
    onNavigateToScreen: (WgcDentiCareScreen) -> Unit = {}
) {
    when (screen) {
        WgcDentiCareScreen.HOME -> WgcDentiCareHomeTemplate(
            onScheduleClick = { onNavigateToScreen(WgcDentiCareScreen.APPOINTMENT) },
            onViewOdontogramClick = { onNavigateToScreen(WgcDentiCareScreen.ODONTOGRAM) },
            onViewXRayClick = { onNavigateToScreen(WgcDentiCareScreen.XRAY_HISTORY) }
        )
        WgcDentiCareScreen.ODONTOGRAM -> WgcDentiCareOdontogramTemplate()
        WgcDentiCareScreen.XRAY_HISTORY -> WgcDentiCareXRayTemplate()
        WgcDentiCareScreen.APPOINTMENT -> WgcDentiCareAppointmentTemplate()
        WgcDentiCareScreen.PROFILE -> WgcDentiCareProfileTemplate()
    }
}
