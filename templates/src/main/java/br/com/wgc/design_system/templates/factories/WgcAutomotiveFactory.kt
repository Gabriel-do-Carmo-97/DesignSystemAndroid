package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.screens.automotive.WgcAutomotiveDetailTemplate
import br.com.wgc.design_system.templates.screens.automotive.WgcAutomotiveFinancingTemplate
import br.com.wgc.design_system.templates.screens.automotive.WgcAutomotiveFipeTemplate
import br.com.wgc.design_system.templates.screens.automotive.WgcAutomotiveHomeTemplate
import br.com.wgc.design_system.templates.screens.automotive.WgcAutomotiveProfileTemplate
import br.com.wgc.design_system.theme.WgcTheme

enum class WgcAutomotiveScreen {
    HOME,
    DETAIL,
    FIPE,
    FINANCING,
    PROFILE
}

@Composable
fun WgcAutomotiveFactory(
    screen: WgcAutomotiveScreen = WgcAutomotiveScreen.HOME,
    modifier: Modifier = Modifier,
    onNavigateToScreen: (WgcAutomotiveScreen) -> Unit = {}
) {
    when (screen) {
        WgcAutomotiveScreen.HOME -> WgcAutomotiveHomeTemplate(
            onVehicleClick = { onNavigateToScreen(WgcAutomotiveScreen.DETAIL) }
        )
        WgcAutomotiveScreen.DETAIL -> WgcAutomotiveDetailTemplate()
        WgcAutomotiveScreen.FIPE -> WgcAutomotiveFipeTemplate()
        WgcAutomotiveScreen.FINANCING -> WgcAutomotiveFinancingTemplate()
        WgcAutomotiveScreen.PROFILE -> WgcAutomotiveProfileTemplate()
    }
}

@Preview(name = "WgcAutomotiveFactory - Home", showBackground = true)
@Composable
private fun WgcAutomotiveFactoryHomePreview() {
    WgcTheme {
        WgcAutomotiveFactory(screen = WgcAutomotiveScreen.HOME)
    }
}

@Preview(name = "WgcAutomotiveFactory - Detail", showBackground = true)
@Composable
private fun WgcAutomotiveFactoryDetailPreview() {
    WgcTheme {
        WgcAutomotiveFactory(screen = WgcAutomotiveScreen.DETAIL)
    }
}

@Preview(name = "WgcAutomotiveFactory - Fipe", showBackground = true)
@Composable
private fun WgcAutomotiveFactoryFipePreview() {
    WgcTheme {
        WgcAutomotiveFactory(screen = WgcAutomotiveScreen.FIPE)
    }
}

@Preview(name = "WgcAutomotiveFactory - Financing", showBackground = true)
@Composable
private fun WgcAutomotiveFactoryFinancingPreview() {
    WgcTheme {
        WgcAutomotiveFactory(screen = WgcAutomotiveScreen.FINANCING)
    }
}

@Preview(name = "WgcAutomotiveFactory - Profile", showBackground = true)
@Composable
private fun WgcAutomotiveFactoryProfilePreview() {
    WgcTheme {
        WgcAutomotiveFactory(screen = WgcAutomotiveScreen.PROFILE)
    }
}

