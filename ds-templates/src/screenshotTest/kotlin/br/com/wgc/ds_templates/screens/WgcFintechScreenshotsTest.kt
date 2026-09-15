package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcC6Factory
import br.com.wgc.ds_templates.factories.WgcC6Screen
import br.com.wgc.ds_templates.factories.WgcInterFactory
import br.com.wgc.ds_templates.factories.WgcInterScreen
import br.com.wgc.ds_templates.factories.WgcNubankFactory
import br.com.wgc.ds_templates.factories.WgcNubankScreen

class WgcFintechScreenshotsTest {

    @Preview(name = "Nubank - Home Screen", showBackground = true)
    @Composable
    fun nubankHomeScreenPreview() {
        WgcNubankFactory(screen = WgcNubankScreen.HOME)
    }

    @Preview(name = "Inter - Home Screen", showBackground = true)
    @Composable
    fun interHomeScreenPreview() {
        WgcInterFactory(screen = WgcInterScreen.HOME)
    }

    @Preview(name = "C6 Bank - Home Screen", showBackground = true)
    @Composable
    fun c6HomeScreenPreview() {
        WgcC6Factory(screen = WgcC6Screen.HOME)
    }
}
