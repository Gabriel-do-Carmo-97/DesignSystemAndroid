package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.steam.*

enum class WgcSteamScreen {
    STORE,
    LIBRARY,
    COMMUNITY,
    WISHLIST,
    PROFILE
}

@Composable
fun WgcSteamFactory(
    screen: WgcSteamScreen = WgcSteamScreen.STORE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcSteamScreen.STORE -> WgcSteamStoreTemplate(modifier = modifier)
        WgcSteamScreen.LIBRARY -> WgcSteamLibraryTemplate(modifier = modifier)
        WgcSteamScreen.COMMUNITY -> WgcSteamCommunityTemplate(modifier = modifier)
        WgcSteamScreen.WISHLIST -> WgcSteamWishlistTemplate(modifier = modifier)
        WgcSteamScreen.PROFILE -> WgcSteamProfileTemplate(modifier = modifier)
    }
}
