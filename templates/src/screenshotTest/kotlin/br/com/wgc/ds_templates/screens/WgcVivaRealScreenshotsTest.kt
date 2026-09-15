package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcVivaRealFactory
import br.com.wgc.ds_templates.factories.WgcVivaRealScreen
import br.com.wgc.ds_templates.screens.vivareal.contact.WgcVivaRealContactLeadTemplate
import br.com.wgc.ds_templates.screens.vivareal.detail.WgcVivaRealPropertyDetailTemplate
import br.com.wgc.ds_templates.screens.vivareal.favorites.WgcVivaRealFavoritesTemplate
import br.com.wgc.ds_templates.screens.vivareal.home.WgcVivaRealHomeTemplate
import br.com.wgc.ds_templates.screens.vivareal.profile.WgcVivaRealProfileTemplate

class WgcVivaRealScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewVivaRealHome() {
        WgcVivaRealHomeTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewVivaRealDetail() {
        WgcVivaRealPropertyDetailTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewVivaRealContactLead() {
        WgcVivaRealContactLeadTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewVivaRealFavorites() {
        WgcVivaRealFavoritesTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewVivaRealProfile() {
        WgcVivaRealProfileTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewVivaRealFactory() {
        WgcVivaRealFactory(screen = WgcVivaRealScreen.Home)
    }
}
