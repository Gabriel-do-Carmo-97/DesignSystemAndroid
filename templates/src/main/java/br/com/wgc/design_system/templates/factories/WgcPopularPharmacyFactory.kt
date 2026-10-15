package br.com.wgc.design_system.templates.factories

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
            br.com.wgc.design_system.factories.verticals.popularpharmacy.templates.home.WgcPagueMenosHomeTemplate(
                modifier = modifier
            )
        }
        WgcPopularPharmacyScreen.CLINIC -> {
            br.com.wgc.design_system.factories.verticals.popularpharmacy.templates.clinic.WgcPagueMenosClinicTemplate(
                modifier = modifier
            )
        }
        WgcPopularPharmacyScreen.CONVENIO -> {
            br.com.wgc.design_system.factories.verticals.popularpharmacy.templates.profile.WgcPagueMenosProfileTemplate(
                modifier = modifier
            )
        }
        WgcPopularPharmacyScreen.CART -> {
            br.com.wgc.design_system.factories.verticals.popularpharmacy.templates.cart.WgcPagueMenosCartTemplate(
                modifier = modifier
            )
        }
        WgcPopularPharmacyScreen.PROFILE -> {
            br.com.wgc.design_system.factories.verticals.popularpharmacy.templates.profile.WgcPagueMenosProfileTemplate(
                modifier = modifier
            )
        }
    }
}
