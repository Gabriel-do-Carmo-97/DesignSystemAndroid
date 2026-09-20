package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcPropertyListingNavItem
import br.com.wgc.design_system.templates.screens.propertylisting.contact.WgcPropertyListingContactLeadTemplate
import br.com.wgc.design_system.templates.screens.propertylisting.detail.WgcPropertyListingPropertyDetailTemplate
import br.com.wgc.design_system.templates.screens.propertylisting.favorites.WgcPropertyListingFavoritesTemplate
import br.com.wgc.design_system.templates.screens.propertylisting.home.WgcPropertyListingHomeTemplate
import br.com.wgc.design_system.templates.screens.propertylisting.model.PropertyListingMockData
import br.com.wgc.design_system.templates.screens.propertylisting.model.PropertyListingPropertyModel
import br.com.wgc.design_system.templates.screens.propertylisting.profile.WgcPropertyListingProfileTemplate

enum class WgcPropertyListingScreen {
    Home,
    Detail,
    ContactLead,
    Favorites,
    Profile
}

/**
 * Factory Unificada da Suíte de Classificados Imobiliários PropertyListing.
 * Provê alternância imediata entre todas as telas do portal de classificados,
 * com sensible defaults e suporte completo a slots e callbacks.
 */
@Composable
fun WgcPropertyListingFactory(
    modifier: Modifier = Modifier,
    screen: WgcPropertyListingScreen = WgcPropertyListingScreen.Home,
    selectedProperty: PropertyListingPropertyModel = PropertyListingMockData.sampleProperty,
    onNavigateToScreen: (WgcPropertyListingScreen) -> Unit = {},
    customScreenSlot: (@Composable () -> Unit)? = null
) {
    if (customScreenSlot != null) {
        customScreenSlot()
        return
    }

    when (screen) {
        WgcPropertyListingScreen.Home -> {
            WgcPropertyListingHomeTemplate(
                modifier = modifier,
                selectedNavItem = WgcPropertyListingNavItem.Search,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcPropertyListingNavItem.Search -> onNavigateToScreen(WgcPropertyListingScreen.Home)
                        WgcPropertyListingNavItem.Favorites -> onNavigateToScreen(WgcPropertyListingScreen.Favorites)
                        WgcPropertyListingNavItem.Messages -> onNavigateToScreen(WgcPropertyListingScreen.ContactLead)
                        WgcPropertyListingNavItem.Profile -> onNavigateToScreen(WgcPropertyListingScreen.Profile)
                    }
                },
                onPropertyClick = { onNavigateToScreen(WgcPropertyListingScreen.Detail) },
                onWhatsAppClick = { onNavigateToScreen(WgcPropertyListingScreen.ContactLead) }
            )
        }
        WgcPropertyListingScreen.Detail -> {
            WgcPropertyListingPropertyDetailTemplate(
                modifier = modifier,
                property = selectedProperty,
                onBackClick = { onNavigateToScreen(WgcPropertyListingScreen.Home) },
                onWhatsAppClick = { onNavigateToScreen(WgcPropertyListingScreen.ContactLead) },
                onSendMessageClick = { onNavigateToScreen(WgcPropertyListingScreen.ContactLead) }
            )
        }
        WgcPropertyListingScreen.ContactLead -> {
            WgcPropertyListingContactLeadTemplate(
                modifier = modifier,
                property = selectedProperty,
                onBackClick = { onNavigateToScreen(WgcPropertyListingScreen.Detail) },
                onSubmitLead = { _, _, _, _ -> onNavigateToScreen(WgcPropertyListingScreen.Favorites) }
            )
        }
        WgcPropertyListingScreen.Favorites -> {
            WgcPropertyListingFavoritesTemplate(
                modifier = modifier,
                selectedNavItem = WgcPropertyListingNavItem.Favorites,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcPropertyListingNavItem.Search -> onNavigateToScreen(WgcPropertyListingScreen.Home)
                        WgcPropertyListingNavItem.Favorites -> onNavigateToScreen(WgcPropertyListingScreen.Favorites)
                        WgcPropertyListingNavItem.Messages -> onNavigateToScreen(WgcPropertyListingScreen.ContactLead)
                        WgcPropertyListingNavItem.Profile -> onNavigateToScreen(WgcPropertyListingScreen.Profile)
                    }
                },
                onPropertyClick = { onNavigateToScreen(WgcPropertyListingScreen.Detail) },
                onWhatsAppClick = { onNavigateToScreen(WgcPropertyListingScreen.ContactLead) },
                onExploreClick = { onNavigateToScreen(WgcPropertyListingScreen.Home) }
            )
        }
        WgcPropertyListingScreen.Profile -> {
            WgcPropertyListingProfileTemplate(
                modifier = modifier,
                selectedNavItem = WgcPropertyListingNavItem.Profile,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcPropertyListingNavItem.Search -> onNavigateToScreen(WgcPropertyListingScreen.Home)
                        WgcPropertyListingNavItem.Favorites -> onNavigateToScreen(WgcPropertyListingScreen.Favorites)
                        WgcPropertyListingNavItem.Messages -> onNavigateToScreen(WgcPropertyListingScreen.ContactLead)
                        WgcPropertyListingNavItem.Profile -> onNavigateToScreen(WgcPropertyListingScreen.Profile)
                    }
                },
                onMessagesClick = { onNavigateToScreen(WgcPropertyListingScreen.ContactLead) },
                onFavoritesClick = { onNavigateToScreen(WgcPropertyListingScreen.Favorites) },
                onAdvertisePropertyClick = { onNavigateToScreen(WgcPropertyListingScreen.ContactLead) }
            )
        }
    }
}
