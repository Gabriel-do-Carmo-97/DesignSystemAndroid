package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcZapFactory
import br.com.wgc.ds_templates.factories.WgcZapScreen
import br.com.wgc.ds_templates.screens.zap.detail.WgcZapPropertyDetailTemplate
import br.com.wgc.ds_templates.screens.zap.favorites.WgcZapFavoritesTemplate
import br.com.wgc.ds_templates.screens.zap.fipezap.WgcZapFipeZapCalculatorTemplate
import br.com.wgc.ds_templates.screens.zap.home.WgcZapHomeTemplate
import br.com.wgc.ds_templates.screens.zap.profile.WgcZapProfileTemplate

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
        WgcZapFactory(screen = WgcZapScreen.Home)
    }
}
