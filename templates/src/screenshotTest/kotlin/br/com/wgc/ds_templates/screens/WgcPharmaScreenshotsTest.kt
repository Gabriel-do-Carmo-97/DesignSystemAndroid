package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcDrogaRaiaFactory
import br.com.wgc.ds_templates.factories.WgcDrogaRaiaScreen
import br.com.wgc.ds_templates.factories.WgcDrogasilFactory
import br.com.wgc.ds_templates.factories.WgcDrogasilScreen
import br.com.wgc.ds_templates.factories.WgcPagueMenosFactory
import br.com.wgc.ds_templates.factories.WgcPagueMenosScreen

class WgcPharmaScreenshotsTest {

    @Preview(name = "Droga Raia - Home Screen", showBackground = true)
    @Composable
    fun drogaRaiaHomeScreenPreview() {
        WgcDrogaRaiaFactory(screen = WgcDrogaRaiaScreen.HOME)
    }

    @Preview(name = "Drogasil - Home Screen", showBackground = true)
    @Composable
    fun drogasilHomeScreenPreview() {
        WgcDrogasilFactory(screen = WgcDrogasilScreen.HOME)
    }

    @Preview(name = "Pague Menos - Home Screen", showBackground = true)
    @Composable
    fun pagueMenosHomeScreenPreview() {
        WgcPagueMenosFactory(screen = WgcPagueMenosScreen.HOME)
    }
}
