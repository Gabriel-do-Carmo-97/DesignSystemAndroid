package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.telemedicine.WgcTelemedicineHomeTemplate
import br.com.wgc.ds_templates.screens.telemedicine.WgcTelemedicinePrescriptionsTemplate
import br.com.wgc.ds_templates.screens.telemedicine.WgcTelemedicineProfileTemplate
import br.com.wgc.ds_templates.screens.telemedicine.WgcTelemedicineSpecialistsTemplate
import br.com.wgc.ds_templates.screens.telemedicine.WgcTelemedicineVideoCallTemplate

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
