package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.govbr.*

enum class WgcGovBrScreen {
    SERVICES,
    CPF,
    SIGN,
    NOTIFICATIONS,
    PROFILE
}

@Composable
fun WgcGovBrFactory(
    screen: WgcGovBrScreen = WgcGovBrScreen.SERVICES,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcGovBrScreen.SERVICES -> WgcGovBrServicesTemplate(modifier = modifier)
        WgcGovBrScreen.CPF -> WgcGovBrCpfTemplate(modifier = modifier)
        WgcGovBrScreen.SIGN -> WgcGovBrSignTemplate(modifier = modifier)
        WgcGovBrScreen.NOTIFICATIONS -> WgcGovBrNotificationsTemplate(modifier = modifier)
        WgcGovBrScreen.PROFILE -> WgcGovBrProfileTemplate(modifier = modifier)
    }
}
