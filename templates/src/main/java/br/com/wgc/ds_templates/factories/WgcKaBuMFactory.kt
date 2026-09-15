package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.kabum.WgcKaBuMCartTemplate
import br.com.wgc.ds_templates.screens.kabum.WgcKaBuMHardwareSpecsTemplate
import br.com.wgc.ds_templates.screens.kabum.WgcKaBuMHomeTemplate
import br.com.wgc.ds_templates.screens.kabum.WgcKaBuMPcBuilderTemplate
import br.com.wgc.ds_templates.screens.kabum.WgcKaBuMProfileTemplate

enum class WgcKaBuMScreen {
    HOME,
    HARDWARE_SPECS,
    PC_BUILDER,
    CART,
    PROFILE
}

@Composable
fun WgcKaBuMFactory(
    screen: WgcKaBuMScreen = WgcKaBuMScreen.HOME,
    modifier: Modifier = Modifier,
    onNavigateToScreen: (WgcKaBuMScreen) -> Unit = {}
) {
    when (screen) {
        WgcKaBuMScreen.HOME -> WgcKaBuMHomeTemplate(
            onAddToCart = { onNavigateToScreen(WgcKaBuMScreen.CART) }
        )
        WgcKaBuMScreen.HARDWARE_SPECS -> WgcKaBuMHardwareSpecsTemplate()
        WgcKaBuMScreen.PC_BUILDER -> WgcKaBuMPcBuilderTemplate()
        WgcKaBuMScreen.CART -> WgcKaBuMCartTemplate()
        WgcKaBuMScreen.PROFILE -> WgcKaBuMProfileTemplate()
    }
}
