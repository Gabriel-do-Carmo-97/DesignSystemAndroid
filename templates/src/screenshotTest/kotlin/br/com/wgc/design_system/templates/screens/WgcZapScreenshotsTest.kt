package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.WgcPropertyClassifiedsFactory
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.WgcPropertyClassifiedsScreen
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.detail.WgcZapPropertyDetailTemplate
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.favorites.WgcZapFavoritesTemplate
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.fipezap.WgcZapFipeZapCalculatorTemplate
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.home.WgcZapHomeTemplate
import br.com.wgc.design_system.factories.verticals.propertyclassifieds.templates.profile.WgcZapProfileTemplate

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
