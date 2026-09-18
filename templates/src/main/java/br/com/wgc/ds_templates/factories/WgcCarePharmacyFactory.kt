package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class WgcCarePharmacyScreen {
    HOME,
    VACCINES,
    LOYALTY,
    CART,
    PROFILE
}

@Composable
fun WgcCarePharmacyFactory(
    modifier: Modifier = Modifier,
    screen: WgcCarePharmacyScreen = WgcCarePharmacyScreen.HOME,
    onNavigate: (WgcCarePharmacyScreen) -> Unit = {}
) {
    when (screen) {
        WgcCarePharmacyScreen.HOME -> {
            br.com.wgc.ds_templates.screens.carepharmacy.home.WgcDrogasilHomeTemplate(
                modifier = modifier
            )
        }
        WgcCarePharmacyScreen.VACCINES -> {
            br.com.wgc.ds_templates.screens.carepharmacy.vaccines.WgcDrogasilVaccinesTemplate(
                modifier = modifier
            )
        }
        WgcCarePharmacyScreen.LOYALTY -> {
            br.com.wgc.ds_templates.screens.carepharmacy.profile.WgcDrogasilProfileTemplate(
                modifier = modifier
            )
        }
        WgcCarePharmacyScreen.CART -> {
            br.com.wgc.ds_templates.screens.carepharmacy.cart.WgcDrogasilCartTemplate(
                modifier = modifier
            )
        }
        WgcCarePharmacyScreen.PROFILE -> {
            br.com.wgc.ds_templates.screens.carepharmacy.profile.WgcDrogasilProfileTemplate(
                modifier = modifier
            )
        }
    }
}
