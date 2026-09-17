package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcFintechCarbonFactory
import br.com.wgc.ds_templates.factories.WgcFintechCarbonScreen
import br.com.wgc.ds_templates.factories.WgcFintechSuperAppFactory
import br.com.wgc.ds_templates.factories.WgcFintechSuperAppScreen
import br.com.wgc.ds_templates.factories.WgcFintechNeobankFactory
import br.com.wgc.ds_templates.factories.WgcFintechNeobankScreen

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
