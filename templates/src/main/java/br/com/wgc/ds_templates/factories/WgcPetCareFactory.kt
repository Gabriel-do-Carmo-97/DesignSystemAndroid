package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.petcare.*

enum class WgcPetCareScreen {
    HOME,
    SUBSCRIPTION,
    CLINIC,
    CART,
    PROFILE
}

@Composable
fun WgcPetCareFactory(
    screen: WgcPetCareScreen = WgcPetCareScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcPetCareScreen.HOME -> WgcPetzHomeTemplate(modifier = modifier)
        WgcPetCareScreen.SUBSCRIPTION -> WgcPetzSubscriptionTemplate(modifier = modifier)
        WgcPetCareScreen.CLINIC -> WgcPetzClinicTemplate(modifier = modifier)
        WgcPetCareScreen.CART -> WgcPetzCartTemplate(modifier = modifier)
        WgcPetCareScreen.PROFILE -> WgcPetzProfileTemplate(modifier = modifier)
    }
}
