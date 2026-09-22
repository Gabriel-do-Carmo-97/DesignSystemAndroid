package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.templates.screens.petsuperstore.*

enum class WgcPetSuperstoreScreen {
    HOME,
    AMIGO,
    PROGRAMADA,
    CART,
    PROFILE
}

@Composable
fun WgcPetSuperstoreFactory(
    screen: WgcPetSuperstoreScreen = WgcPetSuperstoreScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcPetSuperstoreScreen.HOME -> WgcCobasiHomeTemplate(modifier = modifier)
        WgcPetSuperstoreScreen.AMIGO -> WgcCobasiAmigoTemplate(modifier = modifier)
        WgcPetSuperstoreScreen.PROGRAMADA -> WgcCobasiProgramadaTemplate(modifier = modifier)
        WgcPetSuperstoreScreen.CART -> WgcCobasiCartTemplate(modifier = modifier)
        WgcPetSuperstoreScreen.PROFILE -> WgcCobasiProfileTemplate(modifier = modifier)
    }
}
