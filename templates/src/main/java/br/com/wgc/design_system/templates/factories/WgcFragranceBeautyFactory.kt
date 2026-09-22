package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.fragrancebeauty.*

enum class WgcFragranceBeautyScreen {
    HOME,
    CLUBE,
    DIAG,
    BAG,
    PROFILE
}

@Composable
fun WgcFragranceBeautyFactory(
    screen: WgcFragranceBeautyScreen = WgcFragranceBeautyScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcFragranceBeautyScreen.HOME -> WgcBoticarioHomeTemplate(modifier = modifier)
        WgcFragranceBeautyScreen.CLUBE -> WgcBoticarioClubeTemplate(modifier = modifier)
        WgcFragranceBeautyScreen.DIAG -> WgcBoticarioDiagTemplate(modifier = modifier)
        WgcFragranceBeautyScreen.BAG -> WgcBoticarioBagTemplate(modifier = modifier)
        WgcFragranceBeautyScreen.PROFILE -> WgcBoticarioProfileTemplate(modifier = modifier)
    }
}
