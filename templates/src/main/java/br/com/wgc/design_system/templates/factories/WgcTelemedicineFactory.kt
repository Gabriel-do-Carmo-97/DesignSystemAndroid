package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.telemedicine.templates.WgcTelemedicineHomeTemplate
import br.com.wgc.design_system.factories.verticals.telemedicine.templates.WgcTelemedicinePrescriptionsTemplate
import br.com.wgc.design_system.factories.verticals.telemedicine.templates.WgcTelemedicineProfileTemplate
import br.com.wgc.design_system.factories.verticals.telemedicine.templates.WgcTelemedicineSpecialistsTemplate
import br.com.wgc.design_system.factories.verticals.telemedicine.templates.WgcTelemedicineVideoCallTemplate

enum class WgcTelemedicineScreen {
    HOME,
    SPECIALISTS,
    VIDEOCALL,
    PRESCRIPTIONS,
    PROFILE
}

@Composable
fun WgcTelemedicineFactory(
    screen: WgcTelemedicineScreen = WgcTelemedicineScreen.HOME,
    modifier: Modifier = Modifier,
    onNavigateToScreen: (WgcTelemedicineScreen) -> Unit = {}
) {
    when (screen) {
        WgcTelemedicineScreen.HOME -> WgcTelemedicineHomeTemplate(
            onDoctorClick = { onNavigateToScreen(WgcTelemedicineScreen.SPECIALISTS) }
        )
        WgcTelemedicineScreen.SPECIALISTS -> WgcTelemedicineSpecialistsTemplate(
            onSelectDoctor = { onNavigateToScreen(WgcTelemedicineScreen.VIDEOCALL) }
        )
        WgcTelemedicineScreen.VIDEOCALL -> WgcTelemedicineVideoCallTemplate(
            onEndCall = { onNavigateToScreen(WgcTelemedicineScreen.HOME) }
        )
        WgcTelemedicineScreen.PRESCRIPTIONS -> WgcTelemedicinePrescriptionsTemplate()
        WgcTelemedicineScreen.PROFILE -> WgcTelemedicineProfileTemplate()
    }
}
