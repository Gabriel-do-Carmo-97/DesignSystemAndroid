package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.ds_templates.screens.boticario.*

enum class WgcBoticarioScreen {
    HOME,
    CLUBE,
    DIAG,
    BAG,
    PROFILE
}

@Composable
fun WgcBoticarioFactory(
    screen: WgcBoticarioScreen = WgcBoticarioScreen.HOME,
    modifier: Modifier = Modifier
) {
    when (screen) {
        WgcBoticarioScreen.HOME -> WgcBoticarioHomeTemplate(modifier = modifier)
        WgcBoticarioScreen.CLUBE -> WgcBoticarioClubeTemplate(modifier = modifier)
        WgcBoticarioScreen.DIAG -> WgcBoticarioDiagTemplate(modifier = modifier)
        WgcBoticarioScreen.BAG -> WgcBoticarioBagTemplate(modifier = modifier)
        WgcBoticarioScreen.PROFILE -> WgcBoticarioProfileTemplate(modifier = modifier)
    }
}
