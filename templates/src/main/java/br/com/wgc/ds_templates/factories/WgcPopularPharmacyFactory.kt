package br.com.wgc.ds_templates.factories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcPagueMenosClinicCard
import br.com.wgc.design_system.components.cards.WgcPagueMenosConvenioCard

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
