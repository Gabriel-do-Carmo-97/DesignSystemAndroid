package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.loggi.*

enum class WgcLoggiScreen {
    TRACK,
    SEND,
    DELIVERIES,
    HISTORY,
    PROFILE
}

@Composable
fun WgcLoggiFactory(
    screen: WgcLoggiScreen = WgcLoggiScreen.TRACK,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcLoggiScreen.TRACK -> WgcLoggiTrackTemplate(modifier = modifier)
        WgcLoggiScreen.SEND -> WgcLoggiSendTemplate(modifier = modifier)
        WgcLoggiScreen.DELIVERIES -> WgcLoggiDeliveriesTemplate(modifier = modifier)
        WgcLoggiScreen.HISTORY -> WgcLoggiHistoryTemplate(modifier = modifier)
        WgcLoggiScreen.PROFILE -> WgcLoggiProfileTemplate(modifier = modifier)
    }
}
