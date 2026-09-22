package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.freightlogistics.*

enum class WgcFreightLogisticsScreen {
    QUOTE,
    ROUTE,
    TRACKING,
    ORDERS,
    PROFILE
}

@Composable
fun WgcFreightLogisticsFactory(
    screen: WgcFreightLogisticsScreen = WgcFreightLogisticsScreen.QUOTE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcFreightLogisticsScreen.QUOTE -> WgcLalamoveQuoteTemplate(modifier = modifier)
        WgcFreightLogisticsScreen.ROUTE -> WgcLalamoveRouteTemplate(modifier = modifier)
        WgcFreightLogisticsScreen.TRACKING -> WgcLalamoveTrackingTemplate(modifier = modifier)
        WgcFreightLogisticsScreen.ORDERS -> WgcLalamoveOrdersTemplate(modifier = modifier)
        WgcFreightLogisticsScreen.PROFILE -> WgcLalamoveProfileTemplate(modifier = modifier)
    }
}
