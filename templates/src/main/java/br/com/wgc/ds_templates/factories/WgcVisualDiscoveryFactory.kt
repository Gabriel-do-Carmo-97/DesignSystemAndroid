package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.visualdiscovery.*

enum class WgcVisualDiscoveryScreen {
    FEED,
    SEARCH,
    CREATE,
    UPDATES,
    PROFILE
}

@Composable
fun WgcVisualDiscoveryFactory(
    screen: WgcVisualDiscoveryScreen = WgcVisualDiscoveryScreen.FEED,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcVisualDiscoveryScreen.FEED -> WgcPinterestFeedTemplate(modifier = modifier)
        WgcVisualDiscoveryScreen.SEARCH -> WgcPinterestSearchTemplate(modifier = modifier)
        WgcVisualDiscoveryScreen.CREATE -> WgcPinterestCreateTemplate(modifier = modifier)
        WgcVisualDiscoveryScreen.UPDATES -> WgcPinterestUpdatesTemplate(modifier = modifier)
        WgcVisualDiscoveryScreen.PROFILE -> WgcPinterestProfileTemplate(modifier = modifier)
    }
}
