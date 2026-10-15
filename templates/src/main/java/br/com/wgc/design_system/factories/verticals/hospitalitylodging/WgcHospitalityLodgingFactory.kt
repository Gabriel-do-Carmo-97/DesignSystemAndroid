package br.com.wgc.design_system.factories.verticals.hospitalitylodging

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.hospitalitylodging.templates.*

enum class WgcHospitalityLodgingScreen {
    EXPLORE,
    DETAILS,
    MESSAGES,
    TRIPS,
    PROFILE
}

@Composable
fun WgcHospitalityLodgingFactory(
    screen: WgcHospitalityLodgingScreen = WgcHospitalityLodgingScreen.EXPLORE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcHospitalityLodgingScreen.EXPLORE -> WgcHospedagemExploreTemplate(modifier = modifier)
        WgcHospitalityLodgingScreen.DETAILS -> WgcHospedagemDetailsTemplate(modifier = modifier)
        WgcHospitalityLodgingScreen.MESSAGES -> WgcHospedagemMessagesTemplate(modifier = modifier)
        WgcHospitalityLodgingScreen.TRIPS -> WgcHospedagemTripsTemplate(modifier = modifier)
        WgcHospitalityLodgingScreen.PROFILE -> WgcHospedagemProfileTemplate(modifier = modifier)
    }
}
