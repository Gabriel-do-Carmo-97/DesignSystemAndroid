package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.g1.*

enum class WgcG1Screen {
    HOME,
    CATEGORIES,
    FACTCHECK,
    VIDEOS,
    PROFILE
}

@Composable
fun WgcG1Factory(
    screen: WgcG1Screen = WgcG1Screen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcG1Screen.HOME -> WgcG1HomeTemplate(modifier = modifier)
        WgcG1Screen.CATEGORIES -> WgcG1CategoriesTemplate(modifier = modifier)
        WgcG1Screen.FACTCHECK -> WgcG1FactCheckTemplate(modifier = modifier)
        WgcG1Screen.VIDEOS -> WgcG1VideosTemplate(modifier = modifier)
        WgcG1Screen.PROFILE -> WgcG1ProfileTemplate(modifier = modifier)
    }
}
