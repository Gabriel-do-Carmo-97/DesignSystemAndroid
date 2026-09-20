package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.expresslogistics.*

enum class WgcExpressLogisticsScreen {
    TRACK,
    SEND,
    DELIVERIES,
    HISTORY,
    PROFILE
}

@Composable
fun WgcExpressLogisticsFactory(
    screen: WgcExpressLogisticsScreen = WgcExpressLogisticsScreen.TRACK,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcExpressLogisticsScreen.TRACK -> WgcLoggiTrackTemplate(modifier = modifier)
        WgcExpressLogisticsScreen.SEND -> WgcLoggiSendTemplate(modifier = modifier)
        WgcExpressLogisticsScreen.DELIVERIES -> WgcLoggiDeliveriesTemplate(modifier = modifier)
        WgcExpressLogisticsScreen.HISTORY -> WgcLoggiHistoryTemplate(modifier = modifier)
        WgcExpressLogisticsScreen.PROFILE -> WgcLoggiProfileTemplate(modifier = modifier)
    }
}
