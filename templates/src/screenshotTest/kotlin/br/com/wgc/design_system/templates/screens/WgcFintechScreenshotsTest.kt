package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.verticals.fintechcarbon.WgcFintechCarbonFactory
import br.com.wgc.design_system.factories.verticals.fintechcarbon.WgcFintechCarbonScreen
import br.com.wgc.design_system.factories.verticals.fintechsuperapp.WgcFintechSuperAppFactory
import br.com.wgc.design_system.factories.verticals.fintechsuperapp.WgcFintechSuperAppScreen
import br.com.wgc.design_system.factories.verticals.fintechneobank.WgcFintechNeobankFactory
import br.com.wgc.design_system.factories.verticals.fintechneobank.WgcFintechNeobankScreen

class WgcFintechScreenshotsTest {

    @Preview(name = "Neobank - Home Screen", showBackground = true)
    @Composable
    fun fintechNeobankHomeScreenPreview() {
        WgcFintechNeobankFactory(screen = WgcFintechNeobankScreen.HOME)
    }

    @Preview(name = "Fintech SuperApp - Home Screen", showBackground = true)
    @Composable
    fun fintechSuperAppHomeScreenPreview() {
        WgcFintechSuperAppFactory(screen = WgcFintechSuperAppScreen.HOME)
    }

    @Preview(name = "Carbon Bank - Home Screen", showBackground = true)
    @Composable
    fun c6HomeScreenPreview() {
        WgcFintechCarbonFactory(screen = WgcFintechCarbonScreen.HOME)
    }
}
