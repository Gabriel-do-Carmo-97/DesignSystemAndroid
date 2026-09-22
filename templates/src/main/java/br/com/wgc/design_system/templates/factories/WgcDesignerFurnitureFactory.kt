package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.designerfurniture.*

enum class WgcDesignerFurnitureScreen {
    HOME,
    ENVIRONMENTS,
    AR,
    CART,
    PROFILE
}

@Composable
fun WgcDesignerFurnitureFactory(
    screen: WgcDesignerFurnitureScreen = WgcDesignerFurnitureScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcDesignerFurnitureScreen.HOME -> WgcTokStokHomeTemplate(modifier = modifier)
        WgcDesignerFurnitureScreen.ENVIRONMENTS -> WgcTokStokEnvironmentsTemplate(modifier = modifier)
        WgcDesignerFurnitureScreen.AR -> WgcTokStokArTemplate(modifier = modifier)
        WgcDesignerFurnitureScreen.CART -> WgcTokStokCartTemplate(modifier = modifier)
        WgcDesignerFurnitureScreen.PROFILE -> WgcTokStokProfileTemplate(modifier = modifier)
    }
}
