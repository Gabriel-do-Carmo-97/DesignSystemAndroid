package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.tokstok.*

enum class WgcTokStokScreen {
    HOME,
    ENVIRONMENTS,
    AR,
    CART,
    PROFILE
}

@Composable
fun WgcTokStokFactory(
    screen: WgcTokStokScreen = WgcTokStokScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcTokStokScreen.HOME -> WgcTokStokHomeTemplate(modifier = modifier)
        WgcTokStokScreen.ENVIRONMENTS -> WgcTokStokEnvironmentsTemplate(modifier = modifier)
        WgcTokStokScreen.AR -> WgcTokStokArTemplate(modifier = modifier)
        WgcTokStokScreen.CART -> WgcTokStokCartTemplate(modifier = modifier)
        WgcTokStokScreen.PROFILE -> WgcTokStokProfileTemplate(modifier = modifier)
    }
}
