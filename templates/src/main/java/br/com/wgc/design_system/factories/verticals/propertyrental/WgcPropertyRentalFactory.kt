package br.com.wgc.design_system.factories.verticals.propertyrental

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcPropertyRentalNavItem
import br.com.wgc.design_system.factories.verticals.propertyrental.templates.detail.WgcPropertyRentalPropertyDetailTemplate
import br.com.wgc.design_system.factories.verticals.propertyrental.templates.favorites.WgcPropertyRentalFavoritesTemplate
import br.com.wgc.design_system.factories.verticals.propertyrental.templates.home.WgcPropertyRentalHomeTemplate
import br.com.wgc.design_system.factories.verticals.propertyrental.templates.model.PropertyRentalMockData
import br.com.wgc.design_system.factories.verticals.propertyrental.templates.model.PropertyRentalPropertyModel
import br.com.wgc.design_system.factories.verticals.propertyrental.templates.profile.WgcPropertyRentalProfileTemplate
import br.com.wgc.design_system.factories.verticals.propertyrental.templates.schedule.WgcPropertyRentalScheduleVisitTemplate

enum class WgcPropertyRentalScreen {
    Home,
    Detail,
    ScheduleVisit,
    Favorites,
    Profile
}

/**
 * Factory Unificada da SuÃ­te ImobiliÃ¡ria PropertyRental.
 * ProvÃª alternÃ¢ncia imediata entre todas as telas do ecossistema de aluguel e compra de imÃ³veis,
 * com sensible defaults e suporte completo a state hoisting e slots.
 */
@Composable
fun WgcPropertyRentalFactory(
    modifier: Modifier = Modifier,
    screen: WgcPropertyRentalScreen = WgcPropertyRentalScreen.Home,
    selectedProperty: PropertyRentalPropertyModel = PropertyRentalMockData.sampleDetailProperty,
    onNavigateToScreen: (WgcPropertyRentalScreen) -> Unit = {},
    customScreenSlot: (@Composable () -> Unit)? = null
) {
    if (customScreenSlot != null) {
        customScreenSlot()
        return
    }

    when (screen) {
        WgcPropertyRentalScreen.Home -> {
            WgcPropertyRentalHomeTemplate(
                modifier = modifier,
                selectedNavItem = WgcPropertyRentalNavItem.Explore,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcPropertyRentalNavItem.Explore -> onNavigateToScreen(WgcPropertyRentalScreen.Home)
                        WgcPropertyRentalNavItem.Favorites -> onNavigateToScreen(WgcPropertyRentalScreen.Favorites)
                        WgcPropertyRentalNavItem.Visits -> onNavigateToScreen(WgcPropertyRentalScreen.ScheduleVisit)
                        WgcPropertyRentalNavItem.Messages -> onNavigateToScreen(WgcPropertyRentalScreen.Profile)
                        WgcPropertyRentalNavItem.Profile -> onNavigateToScreen(WgcPropertyRentalScreen.Profile)
                    }
                },
                onPropertyClick = { onNavigateToScreen(WgcPropertyRentalScreen.Detail) }
            )
        }
        WgcPropertyRentalScreen.Detail -> {
            WgcPropertyRentalPropertyDetailTemplate(
                modifier = modifier,
                property = selectedProperty,
                onBackClick = { onNavigateToScreen(WgcPropertyRentalScreen.Home) },
                onScheduleVisitClick = { onNavigateToScreen(WgcPropertyRentalScreen.ScheduleVisit) },
                onMakeProposalClick = { onNavigateToScreen(WgcPropertyRentalScreen.ScheduleVisit) }
            )
        }
        WgcPropertyRentalScreen.ScheduleVisit -> {
            WgcPropertyRentalScheduleVisitTemplate(
                modifier = modifier,
                property = selectedProperty,
                onBackClick = { onNavigateToScreen(WgcPropertyRentalScreen.Detail) },
                onConfirmSchedule = { _, _, _ -> onNavigateToScreen(WgcPropertyRentalScreen.Profile) }
            )
        }
        WgcPropertyRentalScreen.Favorites -> {
            WgcPropertyRentalFavoritesTemplate(
                modifier = modifier,
                selectedNavItem = WgcPropertyRentalNavItem.Favorites,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcPropertyRentalNavItem.Explore -> onNavigateToScreen(WgcPropertyRentalScreen.Home)
                        WgcPropertyRentalNavItem.Favorites -> onNavigateToScreen(WgcPropertyRentalScreen.Favorites)
                        WgcPropertyRentalNavItem.Visits -> onNavigateToScreen(WgcPropertyRentalScreen.ScheduleVisit)
                        WgcPropertyRentalNavItem.Messages -> onNavigateToScreen(WgcPropertyRentalScreen.Profile)
                        WgcPropertyRentalNavItem.Profile -> onNavigateToScreen(WgcPropertyRentalScreen.Profile)
                    }
                },
                onPropertyClick = { onNavigateToScreen(WgcPropertyRentalScreen.Detail) },
                onExploreClick = { onNavigateToScreen(WgcPropertyRentalScreen.Home) }
            )
        }
        WgcPropertyRentalScreen.Profile -> {
            WgcPropertyRentalProfileTemplate(
                modifier = modifier,
                selectedNavItem = WgcPropertyRentalNavItem.Profile,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcPropertyRentalNavItem.Explore -> onNavigateToScreen(WgcPropertyRentalScreen.Home)
                        WgcPropertyRentalNavItem.Favorites -> onNavigateToScreen(WgcPropertyRentalScreen.Favorites)
                        WgcPropertyRentalNavItem.Visits -> onNavigateToScreen(WgcPropertyRentalScreen.ScheduleVisit)
                        WgcPropertyRentalNavItem.Messages -> onNavigateToScreen(WgcPropertyRentalScreen.Profile)
                        WgcPropertyRentalNavItem.Profile -> onNavigateToScreen(WgcPropertyRentalScreen.Profile)
                    }
                },
                onMyVisitsClick = { onNavigateToScreen(WgcPropertyRentalScreen.ScheduleVisit) },
                onMyProposalsClick = { onNavigateToScreen(WgcPropertyRentalScreen.Detail) }
            )
        }
    }
}
