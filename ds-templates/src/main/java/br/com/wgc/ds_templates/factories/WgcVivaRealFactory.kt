package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcVivaRealNavItem
import br.com.wgc.ds_templates.screens.vivareal.contact.WgcVivaRealContactLeadTemplate
import br.com.wgc.ds_templates.screens.vivareal.detail.WgcVivaRealPropertyDetailTemplate
import br.com.wgc.ds_templates.screens.vivareal.favorites.WgcVivaRealFavoritesTemplate
import br.com.wgc.ds_templates.screens.vivareal.home.WgcVivaRealHomeTemplate
import br.com.wgc.ds_templates.screens.vivareal.model.VivaRealMockData
import br.com.wgc.ds_templates.screens.vivareal.model.VivaRealPropertyModel
import br.com.wgc.ds_templates.screens.vivareal.profile.WgcVivaRealProfileTemplate

enum class WgcVivaRealScreen {
    Home,
    Detail,
    ContactLead,
    Favorites,
    Profile
}

/**
 * Factory Unificada da Suíte de Classificados Imobiliários Viva Real.
 * Provê alternância imediata entre todas as telas do portal de classificados,
 * com sensible defaults e suporte completo a slots e callbacks.
 */
@Composable
fun WgcVivaRealFactory(
    modifier: Modifier = Modifier,
    screen: WgcVivaRealScreen = WgcVivaRealScreen.Home,
    selectedProperty: VivaRealPropertyModel = VivaRealMockData.sampleProperty,
    onNavigateToScreen: (WgcVivaRealScreen) -> Unit = {},
    customScreenSlot: (@Composable () -> Unit)? = null
) {
    if (customScreenSlot != null) {
        customScreenSlot()
        return
    }

    when (screen) {
        WgcVivaRealScreen.Home -> {
            WgcVivaRealHomeTemplate(
                modifier = modifier,
                selectedNavItem = WgcVivaRealNavItem.Search,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcVivaRealNavItem.Search -> onNavigateToScreen(WgcVivaRealScreen.Home)
                        WgcVivaRealNavItem.Favorites -> onNavigateToScreen(WgcVivaRealScreen.Favorites)
                        WgcVivaRealNavItem.Messages -> onNavigateToScreen(WgcVivaRealScreen.ContactLead)
                        WgcVivaRealNavItem.Profile -> onNavigateToScreen(WgcVivaRealScreen.Profile)
                    }
                },
                onPropertyClick = { onNavigateToScreen(WgcVivaRealScreen.Detail) },
                onWhatsAppClick = { onNavigateToScreen(WgcVivaRealScreen.ContactLead) }
            )
        }
        WgcVivaRealScreen.Detail -> {
            WgcVivaRealPropertyDetailTemplate(
                modifier = modifier,
                property = selectedProperty,
                onBackClick = { onNavigateToScreen(WgcVivaRealScreen.Home) },
                onWhatsAppClick = { onNavigateToScreen(WgcVivaRealScreen.ContactLead) },
                onSendMessageClick = { onNavigateToScreen(WgcVivaRealScreen.ContactLead) }
            )
        }
        WgcVivaRealScreen.ContactLead -> {
            WgcVivaRealContactLeadTemplate(
                modifier = modifier,
                property = selectedProperty,
                onBackClick = { onNavigateToScreen(WgcVivaRealScreen.Detail) },
                onSubmitLead = { _, _, _, _ -> onNavigateToScreen(WgcVivaRealScreen.Favorites) }
            )
        }
        WgcVivaRealScreen.Favorites -> {
            WgcVivaRealFavoritesTemplate(
                modifier = modifier,
                selectedNavItem = WgcVivaRealNavItem.Favorites,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcVivaRealNavItem.Search -> onNavigateToScreen(WgcVivaRealScreen.Home)
                        WgcVivaRealNavItem.Favorites -> onNavigateToScreen(WgcVivaRealScreen.Favorites)
                        WgcVivaRealNavItem.Messages -> onNavigateToScreen(WgcVivaRealScreen.ContactLead)
                        WgcVivaRealNavItem.Profile -> onNavigateToScreen(WgcVivaRealScreen.Profile)
                    }
                },
                onPropertyClick = { onNavigateToScreen(WgcVivaRealScreen.Detail) },
                onWhatsAppClick = { onNavigateToScreen(WgcVivaRealScreen.ContactLead) },
                onExploreClick = { onNavigateToScreen(WgcVivaRealScreen.Home) }
            )
        }
        WgcVivaRealScreen.Profile -> {
            WgcVivaRealProfileTemplate(
                modifier = modifier,
                selectedNavItem = WgcVivaRealNavItem.Profile,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcVivaRealNavItem.Search -> onNavigateToScreen(WgcVivaRealScreen.Home)
                        WgcVivaRealNavItem.Favorites -> onNavigateToScreen(WgcVivaRealScreen.Favorites)
                        WgcVivaRealNavItem.Messages -> onNavigateToScreen(WgcVivaRealScreen.ContactLead)
                        WgcVivaRealNavItem.Profile -> onNavigateToScreen(WgcVivaRealScreen.Profile)
                    }
                },
                onMessagesClick = { onNavigateToScreen(WgcVivaRealScreen.ContactLead) },
                onFavoritesClick = { onNavigateToScreen(WgcVivaRealScreen.Favorites) },
                onAdvertisePropertyClick = { onNavigateToScreen(WgcVivaRealScreen.ContactLead) }
            )
        }
    }
}
