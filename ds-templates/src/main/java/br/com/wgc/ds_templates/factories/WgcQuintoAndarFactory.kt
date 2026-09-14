package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.navigation.WgcQuintoAndarNavItem
import br.com.wgc.ds_templates.screens.quintoandar.detail.WgcQuintoAndarPropertyDetailTemplate
import br.com.wgc.ds_templates.screens.quintoandar.favorites.WgcQuintoAndarFavoritesTemplate
import br.com.wgc.ds_templates.screens.quintoandar.home.WgcQuintoAndarHomeTemplate
import br.com.wgc.ds_templates.screens.quintoandar.model.QuintoAndarMockData
import br.com.wgc.ds_templates.screens.quintoandar.model.QuintoAndarPropertyModel
import br.com.wgc.ds_templates.screens.quintoandar.profile.WgcQuintoAndarProfileTemplate
import br.com.wgc.ds_templates.screens.quintoandar.schedule.WgcQuintoAndarScheduleVisitTemplate

enum class WgcQuintoAndarScreen {
    Home,
    Detail,
    ScheduleVisit,
    Favorites,
    Profile
}

/**
 * Factory Unificada da Suíte Imobiliária QuintoAndar.
 * Provê alternância imediata entre todas as telas do ecossistema de aluguel e compra de imóveis,
 * com sensible defaults e suporte completo a state hoisting e slots.
 */
@Composable
fun WgcQuintoAndarFactory(
    modifier: Modifier = Modifier,
    screen: WgcQuintoAndarScreen = WgcQuintoAndarScreen.Home,
    selectedProperty: QuintoAndarPropertyModel = QuintoAndarMockData.sampleDetailProperty,
    onNavigateToScreen: (WgcQuintoAndarScreen) -> Unit = {},
    customScreenSlot: (@Composable () -> Unit)? = null
) {
    if (customScreenSlot != null) {
        customScreenSlot()
        return
    }

    when (screen) {
        WgcQuintoAndarScreen.Home -> {
            WgcQuintoAndarHomeTemplate(
                modifier = modifier,
                selectedNavItem = WgcQuintoAndarNavItem.Explore,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcQuintoAndarNavItem.Explore -> onNavigateToScreen(WgcQuintoAndarScreen.Home)
                        WgcQuintoAndarNavItem.Favorites -> onNavigateToScreen(WgcQuintoAndarScreen.Favorites)
                        WgcQuintoAndarNavItem.Visits -> onNavigateToScreen(WgcQuintoAndarScreen.ScheduleVisit)
                        WgcQuintoAndarNavItem.Messages -> onNavigateToScreen(WgcQuintoAndarScreen.Profile)
                        WgcQuintoAndarNavItem.Profile -> onNavigateToScreen(WgcQuintoAndarScreen.Profile)
                    }
                },
                onPropertyClick = { onNavigateToScreen(WgcQuintoAndarScreen.Detail) }
            )
        }
        WgcQuintoAndarScreen.Detail -> {
            WgcQuintoAndarPropertyDetailTemplate(
                modifier = modifier,
                property = selectedProperty,
                onBackClick = { onNavigateToScreen(WgcQuintoAndarScreen.Home) },
                onScheduleVisitClick = { onNavigateToScreen(WgcQuintoAndarScreen.ScheduleVisit) },
                onMakeProposalClick = { onNavigateToScreen(WgcQuintoAndarScreen.ScheduleVisit) }
            )
        }
        WgcQuintoAndarScreen.ScheduleVisit -> {
            WgcQuintoAndarScheduleVisitTemplate(
                modifier = modifier,
                property = selectedProperty,
                onBackClick = { onNavigateToScreen(WgcQuintoAndarScreen.Detail) },
                onConfirmSchedule = { _, _, _ -> onNavigateToScreen(WgcQuintoAndarScreen.Profile) }
            )
        }
        WgcQuintoAndarScreen.Favorites -> {
            WgcQuintoAndarFavoritesTemplate(
                modifier = modifier,
                selectedNavItem = WgcQuintoAndarNavItem.Favorites,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcQuintoAndarNavItem.Explore -> onNavigateToScreen(WgcQuintoAndarScreen.Home)
                        WgcQuintoAndarNavItem.Favorites -> onNavigateToScreen(WgcQuintoAndarScreen.Favorites)
                        WgcQuintoAndarNavItem.Visits -> onNavigateToScreen(WgcQuintoAndarScreen.ScheduleVisit)
                        WgcQuintoAndarNavItem.Messages -> onNavigateToScreen(WgcQuintoAndarScreen.Profile)
                        WgcQuintoAndarNavItem.Profile -> onNavigateToScreen(WgcQuintoAndarScreen.Profile)
                    }
                },
                onPropertyClick = { onNavigateToScreen(WgcQuintoAndarScreen.Detail) },
                onExploreClick = { onNavigateToScreen(WgcQuintoAndarScreen.Home) }
            )
        }
        WgcQuintoAndarScreen.Profile -> {
            WgcQuintoAndarProfileTemplate(
                modifier = modifier,
                selectedNavItem = WgcQuintoAndarNavItem.Profile,
                onNavItemSelect = { navItem ->
                    when (navItem) {
                        WgcQuintoAndarNavItem.Explore -> onNavigateToScreen(WgcQuintoAndarScreen.Home)
                        WgcQuintoAndarNavItem.Favorites -> onNavigateToScreen(WgcQuintoAndarScreen.Favorites)
                        WgcQuintoAndarNavItem.Visits -> onNavigateToScreen(WgcQuintoAndarScreen.ScheduleVisit)
                        WgcQuintoAndarNavItem.Messages -> onNavigateToScreen(WgcQuintoAndarScreen.Profile)
                        WgcQuintoAndarNavItem.Profile -> onNavigateToScreen(WgcQuintoAndarScreen.Profile)
                    }
                },
                onMyVisitsClick = { onNavigateToScreen(WgcQuintoAndarScreen.ScheduleVisit) },
                onMyProposalsClick = { onNavigateToScreen(WgcQuintoAndarScreen.Detail) }
            )
        }
    }
}
