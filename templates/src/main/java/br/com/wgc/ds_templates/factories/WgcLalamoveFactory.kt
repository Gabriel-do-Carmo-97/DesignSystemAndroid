package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.lalamove.*

enum class WgcLalamoveScreen {
    QUOTE,
    ROUTE,
    TRACKING,
    ORDERS,
    PROFILE
}

@Composable
fun WgcLalamoveFactory(
    screen: WgcLalamoveScreen = WgcLalamoveScreen.QUOTE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcLalamoveScreen.QUOTE -> WgcLalamoveQuoteTemplate(modifier = modifier)
        WgcLalamoveScreen.ROUTE -> WgcLalamoveRouteTemplate(modifier = modifier)
        WgcLalamoveScreen.TRACKING -> WgcLalamoveTrackingTemplate(modifier = modifier)
        WgcLalamoveScreen.ORDERS -> WgcLalamoveOrdersTemplate(modifier = modifier)
        WgcLalamoveScreen.PROFILE -> WgcLalamoveProfileTemplate(modifier = modifier)
    }
}
