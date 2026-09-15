package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.zeedog.*

enum class WgcZeeDogScreen {
    HOME,
    KITCHEN,
    ACCESSORIES,
    CART,
    PROFILE
}

@Composable
fun WgcZeeDogFactory(
    screen: WgcZeeDogScreen = WgcZeeDogScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcZeeDogScreen.HOME -> WgcZeeDogHomeTemplate(modifier = modifier)
        WgcZeeDogScreen.KITCHEN -> WgcZeeDogKitchenTemplate(modifier = modifier)
        WgcZeeDogScreen.ACCESSORIES -> WgcZeeDogAccessoriesTemplate(modifier = modifier)
        WgcZeeDogScreen.CART -> WgcZeeDogCartTemplate(modifier = modifier)
        WgcZeeDogScreen.PROFILE -> WgcZeeDogProfileTemplate(modifier = modifier)
    }
}
