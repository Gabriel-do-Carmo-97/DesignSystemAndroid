package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.gamingstore.*

enum class WgcGamingStoreScreen {
    STORE,
    LIBRARY,
    COMMUNITY,
    WISHLIST,
    PROFILE
}

@Composable
fun WgcGamingStoreFactory(
    screen: WgcGamingStoreScreen = WgcGamingStoreScreen.STORE,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcGamingStoreScreen.STORE -> WgcSteamStoreTemplate(modifier = modifier)
        WgcGamingStoreScreen.LIBRARY -> WgcSteamLibraryTemplate(modifier = modifier)
        WgcGamingStoreScreen.COMMUNITY -> WgcSteamCommunityTemplate(modifier = modifier)
        WgcGamingStoreScreen.WISHLIST -> WgcSteamWishlistTemplate(modifier = modifier)
        WgcGamingStoreScreen.PROFILE -> WgcSteamProfileTemplate(modifier = modifier)
    }
}
