package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.petlifestyle.*

enum class WgcPetLifestyleScreen {
    HOME,
    KITCHEN,
    ACCESSORIES,
    CART,
    PROFILE
}

@Composable
fun WgcPetLifestyleFactory(
    screen: WgcPetLifestyleScreen = WgcPetLifestyleScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcPetLifestyleScreen.HOME -> WgcZeeDogHomeTemplate(modifier = modifier)
        WgcPetLifestyleScreen.KITCHEN -> WgcZeeDogKitchenTemplate(modifier = modifier)
        WgcPetLifestyleScreen.ACCESSORIES -> WgcZeeDogAccessoriesTemplate(modifier = modifier)
        WgcPetLifestyleScreen.CART -> WgcZeeDogCartTemplate(modifier = modifier)
        WgcPetLifestyleScreen.PROFILE -> WgcZeeDogProfileTemplate(modifier = modifier)
    }
}
