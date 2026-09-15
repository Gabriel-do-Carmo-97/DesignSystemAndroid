package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.pinterest.*

enum class WgcPinterestScreen {
    FEED,
    SEARCH,
    CREATE,
    UPDATES,
    PROFILE
}

@Composable
fun WgcPinterestFactory(
    screen: WgcPinterestScreen = WgcPinterestScreen.FEED,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcPinterestScreen.FEED -> WgcPinterestFeedTemplate(modifier = modifier)
        WgcPinterestScreen.SEARCH -> WgcPinterestSearchTemplate(modifier = modifier)
        WgcPinterestScreen.CREATE -> WgcPinterestCreateTemplate(modifier = modifier)
        WgcPinterestScreen.UPDATES -> WgcPinterestUpdatesTemplate(modifier = modifier)
        WgcPinterestScreen.PROFILE -> WgcPinterestProfileTemplate(modifier = modifier)
    }
}
