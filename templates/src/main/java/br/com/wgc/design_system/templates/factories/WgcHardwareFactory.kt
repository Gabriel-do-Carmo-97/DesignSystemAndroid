package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.hardware.WgcHardwareCartTemplate
import br.com.wgc.design_system.templates.screens.hardware.WgcHardwareHomeTemplate
import br.com.wgc.design_system.templates.screens.hardware.WgcHardwarePcBuilderTemplate
import br.com.wgc.design_system.templates.screens.hardware.WgcHardwareProfileTemplate
import br.com.wgc.design_system.templates.screens.hardware.WgcHardwareSpecsTemplate

enum class WgcHardwareScreen {
    HOME,
    SPECS,
    PC_BUILDER,
    CART,
    PROFILE
}

@Composable
fun WgcHardwareFactory(
    screen: WgcHardwareScreen = WgcHardwareScreen.HOME,
    modifier: Modifier = Modifier,
    onNavigateToScreen: (WgcHardwareScreen) -> Unit = {}
) {
    when (screen) {
        WgcHardwareScreen.HOME -> WgcHardwareHomeTemplate(
            onAddToCart = { onNavigateToScreen(WgcHardwareScreen.CART) }
        )
        WgcHardwareScreen.SPECS -> WgcHardwareSpecsTemplate()
        WgcHardwareScreen.PC_BUILDER -> WgcHardwarePcBuilderTemplate()
        WgcHardwareScreen.CART -> WgcHardwareCartTemplate()
        WgcHardwareScreen.PROFILE -> WgcHardwareProfileTemplate()
    }
}
