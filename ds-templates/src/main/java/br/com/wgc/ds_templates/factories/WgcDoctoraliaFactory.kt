package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.doctoralia.WgcDoctoraliaHomeTemplate
import br.com.wgc.ds_templates.screens.doctoralia.WgcDoctoraliaPrescriptionsTemplate
import br.com.wgc.ds_templates.screens.doctoralia.WgcDoctoraliaProfileTemplate
import br.com.wgc.ds_templates.screens.doctoralia.WgcDoctoraliaSpecialistsTemplate
import br.com.wgc.ds_templates.screens.doctoralia.WgcDoctoraliaVideoCallTemplate

enum class WgcDoctoraliaScreen {
    HOME,
    SPECIALISTS,
    VIDEO_CALL,
    PRESCRIPTIONS,
    PROFILE
}

@Composable
fun WgcDoctoraliaFactory(
    screen: WgcDoctoraliaScreen = WgcDoctoraliaScreen.HOME,
    modifier: Modifier = Modifier,
    onNavigateToScreen: (WgcDoctoraliaScreen) -> Unit = {}
) {
    when (screen) {
        WgcDoctoraliaScreen.HOME -> WgcDoctoraliaHomeTemplate(
            onStartTelemedicine = { onNavigateToScreen(WgcDoctoraliaScreen.VIDEO_CALL) },
            onDoctorClick = { onNavigateToScreen(WgcDoctoraliaScreen.SPECIALISTS) }
        )
        WgcDoctoraliaScreen.SPECIALISTS -> WgcDoctoraliaSpecialistsTemplate(
            onSelectDoctor = { onNavigateToScreen(WgcDoctoraliaScreen.VIDEO_CALL) }
        )
        WgcDoctoraliaScreen.VIDEO_CALL -> WgcDoctoraliaVideoCallTemplate(
            onEndCall = { onNavigateToScreen(WgcDoctoraliaScreen.HOME) }
        )
        WgcDoctoraliaScreen.PRESCRIPTIONS -> WgcDoctoraliaPrescriptionsTemplate()
        WgcDoctoraliaScreen.PROFILE -> WgcDoctoraliaProfileTemplate()
    }
}
