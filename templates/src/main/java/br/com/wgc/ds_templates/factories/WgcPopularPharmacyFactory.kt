package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class WgcPopularPharmacyScreen {
    HOME,
    CLINIC,
    CONVENIO,
    CART,
    PROFILE
}

@Composable
fun WgcPopularPharmacyFactory(
    modifier: Modifier = Modifier,
    screen: WgcPopularPharmacyScreen = WgcPopularPharmacyScreen.HOME,
    onNavigate: (WgcPopularPharmacyScreen) -> Unit = {}
) {
    when (screen) {
        WgcPopularPharmacyScreen.HOME -> {
            br.com.wgc.ds_templates.screens.popularpharmacy.home.WgcPagueMenosHomeTemplate(
                modifier = modifier
            )
        }
        WgcPopularPharmacyScreen.CLINIC -> {
            br.com.wgc.ds_templates.screens.popularpharmacy.clinic.WgcPagueMenosClinicTemplate(
                modifier = modifier
            )
        }
        WgcPopularPharmacyScreen.CONVENIO -> {
            br.com.wgc.ds_templates.screens.popularpharmacy.profile.WgcPagueMenosProfileTemplate(
                modifier = modifier
            )
        }
        WgcPopularPharmacyScreen.CART -> {
            br.com.wgc.ds_templates.screens.popularpharmacy.cart.WgcPagueMenosCartTemplate(
                modifier = modifier
            )
        }
        WgcPopularPharmacyScreen.PROFILE -> {
            br.com.wgc.ds_templates.screens.popularpharmacy.profile.WgcPagueMenosProfileTemplate(
                modifier = modifier
            )
        }
    }
}
