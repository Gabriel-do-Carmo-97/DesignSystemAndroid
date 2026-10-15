package br.com.wgc.design_system.factories.verticals.languagelearning

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.languagelearning.templates.*

enum class WgcLanguageLearningScreen {
    PATH,
    PRONOUNCE,
    LEAGUES,
    SHOP,
    PROFILE
}

@Composable
fun WgcLanguageLearningFactory(
    screen: WgcLanguageLearningScreen = WgcLanguageLearningScreen.PATH,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcLanguageLearningScreen.PATH -> WgcDuolingoPathTemplate(modifier = modifier)
        WgcLanguageLearningScreen.PRONOUNCE -> WgcDuolingoPronounceTemplate(modifier = modifier)
        WgcLanguageLearningScreen.LEAGUES -> WgcDuolingoLeaguesTemplate(modifier = modifier)
        WgcLanguageLearningScreen.SHOP -> WgcDuolingoShopTemplate(modifier = modifier)
        WgcLanguageLearningScreen.PROFILE -> WgcDuolingoProfileTemplate(modifier = modifier)
    }
}
