package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.urbanfashion.*

enum class WgcUrbanFashionScreen {
    HOME,
    CLUBE,
    SEARCH,
    BAG,
    PROFILE
}

@Composable
fun WgcUrbanFashionFactory(
    screen: WgcUrbanFashionScreen = WgcUrbanFashionScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcUrbanFashionScreen.HOME -> WgcCeaHomeTemplate(modifier = modifier)
        WgcUrbanFashionScreen.CLUBE -> WgcCeaClubeTemplate(modifier = modifier)
        WgcUrbanFashionScreen.SEARCH -> WgcCeaSearchTemplate(modifier = modifier)
        WgcUrbanFashionScreen.BAG -> WgcCeaBagTemplate(modifier = modifier)
        WgcUrbanFashionScreen.PROFILE -> WgcCeaProfileTemplate(modifier = modifier)
    }
}
