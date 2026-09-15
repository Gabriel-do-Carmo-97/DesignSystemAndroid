package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.spotify.*

enum class WgcSpotifyScreen {
    HOME,
    SEARCH,
    LIBRARY,
    PLAYER,
    PROFILE
}

@Composable
fun WgcSpotifyFactory(
    screen: WgcSpotifyScreen = WgcSpotifyScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcSpotifyScreen.HOME -> WgcSpotifyHomeTemplate(modifier = modifier)
        WgcSpotifyScreen.SEARCH -> WgcSpotifySearchTemplate(modifier = modifier)
        WgcSpotifyScreen.LIBRARY -> WgcSpotifyLibraryTemplate(modifier = modifier)
        WgcSpotifyScreen.PLAYER -> WgcSpotifyPlayerTemplate(modifier = modifier)
        WgcSpotifyScreen.PROFILE -> WgcSpotifyProfileTemplate(modifier = modifier)
    }
}
