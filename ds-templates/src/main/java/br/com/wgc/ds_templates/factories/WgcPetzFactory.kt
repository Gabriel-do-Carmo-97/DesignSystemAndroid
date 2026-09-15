package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.petz.*

enum class WgcPetzScreen {
    HOME,
    SUBSCRIPTION,
    CLINIC,
    CART,
    PROFILE
}

@Composable
fun WgcPetzFactory(
    screen: WgcPetzScreen = WgcPetzScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcPetzScreen.HOME -> WgcPetzHomeTemplate(modifier = modifier)
        WgcPetzScreen.SUBSCRIPTION -> WgcPetzSubscriptionTemplate(modifier = modifier)
        WgcPetzScreen.CLINIC -> WgcPetzClinicTemplate(modifier = modifier)
        WgcPetzScreen.CART -> WgcPetzCartTemplate(modifier = modifier)
        WgcPetzScreen.PROFILE -> WgcPetzProfileTemplate(modifier = modifier)
    }
}
