package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.globoplay.*

enum class WgcGloboplayScreen {
    HOME,
    LIVE,
    NOVELAS,
    CHANNELS,
    PROFILE
}

@Composable
fun WgcGloboplayFactory(
    screen: WgcGloboplayScreen = WgcGloboplayScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcGloboplayScreen.HOME -> WgcGloboplayHomeTemplate(modifier = modifier)
        WgcGloboplayScreen.LIVE -> WgcGloboplayLiveTemplate(modifier = modifier)
        WgcGloboplayScreen.NOVELAS -> WgcGloboplayNovelasTemplate(modifier = modifier)
        WgcGloboplayScreen.CHANNELS -> WgcGloboplayChannelsTemplate(modifier = modifier)
        WgcGloboplayScreen.PROFILE -> WgcGloboplayProfileTemplate(modifier = modifier)
    }
}
