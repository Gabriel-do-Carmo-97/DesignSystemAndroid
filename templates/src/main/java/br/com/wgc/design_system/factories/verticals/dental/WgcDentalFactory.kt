package br.com.wgc.design_system.factories.verticals.dental

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.dental.templates.DentalMockData
import br.com.wgc.design_system.factories.verticals.dental.templates.WgcDentalAppointmentTemplate
import br.com.wgc.design_system.factories.verticals.dental.templates.WgcDentalHomeTemplate
import br.com.wgc.design_system.factories.verticals.dental.templates.WgcDentalOdontogramTemplate
import br.com.wgc.design_system.factories.verticals.dental.templates.WgcDentalProfileTemplate
import br.com.wgc.design_system.factories.verticals.dental.templates.WgcDentalXRayTemplate

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
