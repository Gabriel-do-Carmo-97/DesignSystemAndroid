package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.businessnews.*

enum class WgcBusinessNewsScreen {
    HOME,
    INVEST,
    ESG,
    MAGAZINE,
    PROFILE
}

@Composable
fun WgcBusinessNewsFactory(
    screen: WgcBusinessNewsScreen = WgcBusinessNewsScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcBusinessNewsScreen.HOME -> WgcExameHomeTemplate(modifier = modifier)
        WgcBusinessNewsScreen.INVEST -> WgcExameInvestTemplate(modifier = modifier)
        WgcBusinessNewsScreen.ESG -> WgcExameEsgTemplate(modifier = modifier)
        WgcBusinessNewsScreen.MAGAZINE -> WgcExameMagazineTemplate(modifier = modifier)
        WgcBusinessNewsScreen.PROFILE -> WgcExameProfileTemplate(modifier = modifier)
    }
}
