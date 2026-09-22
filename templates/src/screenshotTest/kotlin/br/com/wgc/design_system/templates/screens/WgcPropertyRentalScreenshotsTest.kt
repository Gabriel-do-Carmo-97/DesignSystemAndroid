package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcPropertyRentalFactory
import br.com.wgc.design_system.templates.factories.WgcPropertyRentalScreen
import br.com.wgc.design_system.templates.screens.propertyrental.detail.WgcPropertyRentalPropertyDetailTemplate
import br.com.wgc.design_system.templates.screens.propertyrental.favorites.WgcPropertyRentalFavoritesTemplate
import br.com.wgc.design_system.templates.screens.propertyrental.home.WgcPropertyRentalHomeTemplate
import br.com.wgc.design_system.templates.screens.propertyrental.profile.WgcPropertyRentalProfileTemplate
import br.com.wgc.design_system.templates.screens.propertyrental.schedule.WgcPropertyRentalScheduleVisitTemplate

class WgcPropertyRentalScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyRentalHome() {
        WgcPropertyRentalHomeTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyRentalDetail() {
        WgcPropertyRentalPropertyDetailTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyRentalScheduleVisit() {
        WgcPropertyRentalScheduleVisitTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyRentalFavorites() {
        WgcPropertyRentalFavoritesTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyRentalProfile() {
        WgcPropertyRentalProfileTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyRentalFactory() {
        WgcPropertyRentalFactory(screen = WgcPropertyRentalScreen.Home)
    }
}
