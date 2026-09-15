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

enum class WgcPagueMenosScreen {
    HOME,
    CLINIC,
    CONVENIO,
    CART,
    PROFILE
}

@Composable
fun WgcPagueMenosFactory(
    modifier: Modifier = Modifier,
    screen: WgcPagueMenosScreen = WgcPagueMenosScreen.HOME,
    onNavigate: (WgcPagueMenosScreen) -> Unit = {}
) {
    when (screen) {
        WgcPagueMenosScreen.HOME -> {
            br.com.wgc.ds_templates.screens.paguemenos.home.WgcPagueMenosHomeTemplate(
                modifier = modifier
            )
        }
        WgcPagueMenosScreen.CLINIC -> {
            br.com.wgc.ds_templates.screens.paguemenos.clinic.WgcPagueMenosClinicTemplate(
                modifier = modifier
            )
        }
        WgcPagueMenosScreen.CONVENIO -> {
            br.com.wgc.ds_templates.screens.paguemenos.profile.WgcPagueMenosProfileTemplate(
                modifier = modifier
            )
        }
        WgcPagueMenosScreen.CART -> {
            br.com.wgc.ds_templates.screens.paguemenos.cart.WgcPagueMenosCartTemplate(
                modifier = modifier
            )
        }
        WgcPagueMenosScreen.PROFILE -> {
            br.com.wgc.ds_templates.screens.paguemenos.profile.WgcPagueMenosProfileTemplate(
                modifier = modifier
            )
        }
    }
}
