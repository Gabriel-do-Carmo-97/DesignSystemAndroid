package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.exame.*

enum class WgcExameScreen {
    HOME,
    INVEST,
    ESG,
    MAGAZINE,
    PROFILE
}

@Composable
fun WgcExameFactory(
    screen: WgcExameScreen = WgcExameScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcExameScreen.HOME -> WgcExameHomeTemplate(modifier = modifier)
        WgcExameScreen.INVEST -> WgcExameInvestTemplate(modifier = modifier)
        WgcExameScreen.ESG -> WgcExameEsgTemplate(modifier = modifier)
        WgcExameScreen.MAGAZINE -> WgcExameMagazineTemplate(modifier = modifier)
        WgcExameScreen.PROFILE -> WgcExameProfileTemplate(modifier = modifier)
    }
}
