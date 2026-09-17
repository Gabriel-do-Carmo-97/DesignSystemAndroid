package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.citizenservices.*

enum class WgcCitizenServicesScreen {
    SERVICES,
    CPF,
    SIGN,
    NOTIFICATIONS,
    PROFILE
}

@Composable
fun WgcCitizenServicesFactory(
    screen: WgcCitizenServicesScreen = WgcCitizenServicesScreen.SERVICES,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcCitizenServicesScreen.SERVICES -> WgcGovBrServicesTemplate(modifier = modifier)
        WgcCitizenServicesScreen.CPF -> WgcGovBrCpfTemplate(modifier = modifier)
        WgcCitizenServicesScreen.SIGN -> WgcGovBrSignTemplate(modifier = modifier)
        WgcCitizenServicesScreen.NOTIFICATIONS -> WgcGovBrNotificationsTemplate(modifier = modifier)
        WgcCitizenServicesScreen.PROFILE -> WgcGovBrProfileTemplate(modifier = modifier)
    }
}
