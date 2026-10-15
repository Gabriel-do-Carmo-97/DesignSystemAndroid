package br.com.wgc.design_system.factories.verticals.gamingstore

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.gamingstore.templates.*

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
        WgcGamingStoreScreen.STORE -> WgcGamingStoreCatalogTemplate(modifier = modifier)
        WgcGamingStoreScreen.LIBRARY -> WgcGamingStoreLibraryTemplate(modifier = modifier)
        WgcGamingStoreScreen.COMMUNITY -> WgcGamingStoreCommunityTemplate(modifier = modifier)
        WgcGamingStoreScreen.WISHLIST -> WgcGamingStoreWishlistTemplate(modifier = modifier)
        WgcGamingStoreScreen.PROFILE -> WgcGamingStoreProfileTemplate(modifier = modifier)
    }
}
