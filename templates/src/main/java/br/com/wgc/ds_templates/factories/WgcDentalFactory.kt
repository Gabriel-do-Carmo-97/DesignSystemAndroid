package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.dental.DentalMockData
import br.com.wgc.ds_templates.screens.dental.WgcDentalAppointmentTemplate
import br.com.wgc.ds_templates.screens.dental.WgcDentalHomeTemplate
import br.com.wgc.ds_templates.screens.dental.WgcDentalOdontogramTemplate
import br.com.wgc.ds_templates.screens.dental.WgcDentalProfileTemplate
import br.com.wgc.ds_templates.screens.dental.WgcDentalXRayTemplate

enum class WgcDentalScreen {
    HOME,
    ODONTOGRAM,
    XRAY_HISTORY,
    APPOINTMENT,
    PROFILE
}

@Composable
fun WgcDentalFactory(
    screen: WgcDentalScreen = WgcDentalScreen.HOME,
    modifier: Modifier = Modifier,
    onNavigateToScreen: (WgcDentalScreen) -> Unit = {}
) {
    when (screen) {
        WgcDentalScreen.HOME -> WgcDentalHomeTemplate(
            onScheduleClick = { onNavigateToScreen(WgcDentalScreen.APPOINTMENT) },
            onViewOdontogramClick = { onNavigateToScreen(WgcDentalScreen.ODONTOGRAM) },
            onViewXRayClick = { onNavigateToScreen(WgcDentalScreen.XRAY_HISTORY) }
        )
        WgcDentalScreen.ODONTOGRAM -> WgcDentalOdontogramTemplate()
        WgcDentalScreen.XRAY_HISTORY -> WgcDentalXRayTemplate()
        WgcDentalScreen.APPOINTMENT -> WgcDentalAppointmentTemplate()
        WgcDentalScreen.PROFILE -> WgcDentalProfileTemplate()
    }
}
