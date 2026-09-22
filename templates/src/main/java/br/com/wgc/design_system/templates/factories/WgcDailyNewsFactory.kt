package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.dailynews.*

enum class WgcDailyNewsScreen {
    HOME,
    CATEGORIES,
    FACTCHECK,
    VIDEOS,
    PROFILE
}

@Composable
fun WgcDailyNewsFactory(
    screen: WgcDailyNewsScreen = WgcDailyNewsScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcDailyNewsScreen.HOME -> WgcG1HomeTemplate(modifier = modifier)
        WgcDailyNewsScreen.CATEGORIES -> WgcG1CategoriesTemplate(modifier = modifier)
        WgcDailyNewsScreen.FACTCHECK -> WgcG1FactCheckTemplate(modifier = modifier)
        WgcDailyNewsScreen.VIDEOS -> WgcG1VideosTemplate(modifier = modifier)
        WgcDailyNewsScreen.PROFILE -> WgcG1ProfileTemplate(modifier = modifier)
    }
}
