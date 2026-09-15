package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.cobasi.*

enum class WgcCobasiScreen {
    HOME,
    AMIGO,
    PROGRAMADA,
    CART,
    PROFILE
}

@Composable
fun WgcCobasiFactory(
    screen: WgcCobasiScreen = WgcCobasiScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcCobasiScreen.HOME -> WgcCobasiHomeTemplate(modifier = modifier)
        WgcCobasiScreen.AMIGO -> WgcCobasiAmigoTemplate(modifier = modifier)
        WgcCobasiScreen.PROGRAMADA -> WgcCobasiProgramadaTemplate(modifier = modifier)
        WgcCobasiScreen.CART -> WgcCobasiCartTemplate(modifier = modifier)
        WgcCobasiScreen.PROFILE -> WgcCobasiProfileTemplate(modifier = modifier)
    }
}
