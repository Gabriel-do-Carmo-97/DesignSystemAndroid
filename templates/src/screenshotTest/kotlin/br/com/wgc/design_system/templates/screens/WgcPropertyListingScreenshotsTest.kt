package br.com.wgc.design_system.templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.templates.factories.WgcPropertyListingFactory
import br.com.wgc.design_system.templates.factories.WgcPropertyListingScreen
import br.com.wgc.design_system.factories.verticals.propertylisting.templates.contact.WgcPropertyListingContactLeadTemplate
import br.com.wgc.design_system.factories.verticals.propertylisting.templates.detail.WgcPropertyListingPropertyDetailTemplate
import br.com.wgc.design_system.factories.verticals.propertylisting.templates.favorites.WgcPropertyListingFavoritesTemplate
import br.com.wgc.design_system.factories.verticals.propertylisting.templates.home.WgcPropertyListingHomeTemplate
import br.com.wgc.design_system.factories.verticals.propertylisting.templates.profile.WgcPropertyListingProfileTemplate

class WgcPropertyListingScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyListingHome() {
        WgcPropertyListingHomeTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyListingDetail() {
        WgcPropertyListingPropertyDetailTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyListingContactLead() {
        WgcPropertyListingContactLeadTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyListingFavorites() {
        WgcPropertyListingFavoritesTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyListingProfile() {
        WgcPropertyListingProfileTemplate()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPropertyListingFactory() {
        WgcPropertyListingFactory(screen = WgcPropertyListingScreen.Home)
    }
}
