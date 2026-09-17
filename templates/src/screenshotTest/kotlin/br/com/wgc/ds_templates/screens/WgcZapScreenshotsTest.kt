package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcPropertyClassifiedsFactory
import br.com.wgc.ds_templates.factories.WgcPropertyClassifiedsScreen
import br.com.wgc.ds_templates.screens.propertyclassifieds.detail.WgcZapPropertyDetailTemplate
import br.com.wgc.ds_templates.screens.propertyclassifieds.favorites.WgcZapFavoritesTemplate
import br.com.wgc.ds_templates.screens.propertyclassifieds.fipezap.WgcZapFipeZapCalculatorTemplate
import br.com.wgc.ds_templates.screens.propertyclassifieds.home.WgcZapHomeTemplate
import br.com.wgc.ds_templates.screens.propertyclassifieds.profile.WgcZapProfileTemplate

class WgcZapScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewZapHome() {
        WgcZapHomeTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewZapDetail() {
        WgcZapPropertyDetailTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewZapFipeZap() {
        WgcZapFipeZapCalculatorTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewZapFavorites() {
        WgcZapFavoritesTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewZapProfile() {
        WgcZapProfileTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewZapFactory() {
        WgcPropertyClassifiedsFactory(screen = WgcPropertyClassifiedsScreen.Home)
    }
}
