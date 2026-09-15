package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.duolingo.*

enum class WgcDuolingoScreen {
    PATH,
    PRONOUNCE,
    LEAGUES,
    SHOP,
    PROFILE
}

@Composable
fun WgcDuolingoFactory(
    screen: WgcDuolingoScreen = WgcDuolingoScreen.PATH,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcDuolingoScreen.PATH -> WgcDuolingoPathTemplate(modifier = modifier)
        WgcDuolingoScreen.PRONOUNCE -> WgcDuolingoPronounceTemplate(modifier = modifier)
        WgcDuolingoScreen.LEAGUES -> WgcDuolingoLeaguesTemplate(modifier = modifier)
        WgcDuolingoScreen.SHOP -> WgcDuolingoShopTemplate(modifier = modifier)
        WgcDuolingoScreen.PROFILE -> WgcDuolingoProfileTemplate(modifier = modifier)
    }
}
