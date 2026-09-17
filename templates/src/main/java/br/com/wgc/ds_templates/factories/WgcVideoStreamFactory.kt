package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.videostreaming.*

enum class WgcVideoStreamScreen {
    HOME,
    TRAILER,
    MY_LIST,
    NEWS,
    PROFILE
}

@Composable
fun WgcVideoStreamFactory(
    screen: WgcVideoStreamScreen = WgcVideoStreamScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcVideoStreamScreen.HOME -> WgcVideoStreamHomeTemplate(modifier = modifier)
        WgcVideoStreamScreen.TRAILER -> WgcVideoStreamTrailerTemplate(modifier = modifier)
        WgcVideoStreamScreen.MY_LIST -> WgcVideoStreamMyListTemplate(modifier = modifier)
        WgcVideoStreamScreen.NEWS -> WgcVideoStreamNewsTemplate(modifier = modifier)
        WgcVideoStreamScreen.PROFILE -> WgcVideoStreamProfileTemplate(modifier = modifier)
    }
}
