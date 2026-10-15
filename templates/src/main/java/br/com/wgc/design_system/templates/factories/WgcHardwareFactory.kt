package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.hardware.templates.WgcHardwareCartTemplate
import br.com.wgc.design_system.factories.verticals.hardware.templates.WgcHardwareHomeTemplate
import br.com.wgc.design_system.factories.verticals.hardware.templates.WgcHardwarePcBuilderTemplate
import br.com.wgc.design_system.factories.verticals.hardware.templates.WgcHardwareProfileTemplate
import br.com.wgc.design_system.factories.verticals.hardware.templates.WgcHardwareSpecsTemplate

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
