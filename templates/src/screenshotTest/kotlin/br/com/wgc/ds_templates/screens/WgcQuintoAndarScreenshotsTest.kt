package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.ds_templates.factories.WgcQuintoAndarFactory
import br.com.wgc.ds_templates.factories.WgcQuintoAndarScreen
import br.com.wgc.ds_templates.screens.quintoandar.detail.WgcQuintoAndarPropertyDetailTemplate
import br.com.wgc.ds_templates.screens.quintoandar.favorites.WgcQuintoAndarFavoritesTemplate
import br.com.wgc.ds_templates.screens.quintoandar.home.WgcQuintoAndarHomeTemplate
import br.com.wgc.ds_templates.screens.quintoandar.profile.WgcQuintoAndarProfileTemplate
import br.com.wgc.ds_templates.screens.quintoandar.schedule.WgcQuintoAndarScheduleVisitTemplate

class WgcQuintoAndarScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewQuintoAndarHome() {
        WgcQuintoAndarHomeTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewQuintoAndarDetail() {
        WgcQuintoAndarPropertyDetailTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewQuintoAndarScheduleVisit() {
        WgcQuintoAndarScheduleVisitTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewQuintoAndarFavorites() {
        WgcQuintoAndarFavoritesTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewQuintoAndarProfile() {
        WgcQuintoAndarProfileTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewQuintoAndarFactory() {
        WgcQuintoAndarFactory(screen = WgcQuintoAndarScreen.Home)
    }
}
