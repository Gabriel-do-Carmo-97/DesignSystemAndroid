package br.com.wgc.ds_templates.factories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import br.com.wgc.design_system.components.cards.WgcDrogasilLoyaltyCard
import br.com.wgc.design_system.components.cards.WgcDrogasilVaccineCard

enum class WgcDrogasilScreen {
    HOME,
    VACCINES,
    LOYALTY,
    CART,
    PROFILE
}

@Composable
fun WgcDrogasilFactory(
    modifier: Modifier = Modifier,
    screen: WgcDrogasilScreen = WgcDrogasilScreen.HOME,
    onNavigate: (WgcDrogasilScreen) -> Unit = {}
) {
    when (screen) {
        WgcDrogasilScreen.HOME -> {
            br.com.wgc.ds_templates.screens.drogasil.home.WgcDrogasilHomeTemplate(
                modifier = modifier
            )
        }
        WgcDrogasilScreen.VACCINES -> {
            br.com.wgc.ds_templates.screens.drogasil.vaccines.WgcDrogasilVaccinesTemplate(
                modifier = modifier
            )
        }
        WgcDrogasilScreen.LOYALTY -> {
            br.com.wgc.ds_templates.screens.drogasil.profile.WgcDrogasilProfileTemplate(
                modifier = modifier
            )
        }
        WgcDrogasilScreen.CART -> {
            br.com.wgc.ds_templates.screens.drogasil.cart.WgcDrogasilCartTemplate(
                modifier = modifier
            )
        }
        WgcDrogasilScreen.PROFILE -> {
            br.com.wgc.ds_templates.screens.drogasil.profile.WgcDrogasilProfileTemplate(
                modifier = modifier
            )
        }
    }
}
