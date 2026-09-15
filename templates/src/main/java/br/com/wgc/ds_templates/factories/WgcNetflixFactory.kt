package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.netflix.*

enum class WgcNetflixScreen {
    HOME,
    TRAILER,
    MY_LIST,
    NEWS,
    PROFILE
}

@Composable
fun WgcNetflixFactory(
    screen: WgcNetflixScreen = WgcNetflixScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcNetflixScreen.HOME -> WgcNetflixHomeTemplate(modifier = modifier)
        WgcNetflixScreen.TRAILER -> WgcNetflixTrailerTemplate(modifier = modifier)
        WgcNetflixScreen.MY_LIST -> WgcNetflixMyListTemplate(modifier = modifier)
        WgcNetflixScreen.NEWS -> WgcNetflixNewsTemplate(modifier = modifier)
        WgcNetflixScreen.PROFILE -> WgcNetflixProfileTemplate(modifier = modifier)
    }
}
