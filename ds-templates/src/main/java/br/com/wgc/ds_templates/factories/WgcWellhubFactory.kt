package br.com.wgc.ds_templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.cards.WgcWellhubPlanTier
import br.com.wgc.design_system.components.navigation.WgcWellhubNavItem
import br.com.wgc.ds_templates.screens.wellhub.checkin.WgcWellhubCheckInTemplate
import br.com.wgc.ds_templates.screens.wellhub.explore.WgcWellhubExploreGymsTemplate
import br.com.wgc.ds_templates.screens.wellhub.home.WgcWellhubHomeTemplate
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubCheckIn
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubGym
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubMockData
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubPlan
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubUserProfile
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubWellnessApp
import br.com.wgc.ds_templates.screens.wellhub.plans.WgcWellhubPlansTemplate
import br.com.wgc.ds_templates.screens.wellhub.wellness.WgcWellhubWellnessAppsTemplate

/**
 * Variantes de Telas suportadas pela Fábrica Wellhub (Gympass).
 */
enum class WgcWellhubScreen {
    Home,
    Explore,
    CheckIn,
    Plans,
    Wellness
}

/**
 * Fábrica Universal do ecossistema Wellhub / Gympass (WgcWellhubFactory).
 *
 * Fornece ponto de entrada único para inicialização de qualquer tela Wellhub
 * com Sensible Defaults prontos para produção e slots de substituição granular.
 *
 * Em conformidade com a Regra 6 do AGENTS.md.
 */
object WgcWellhubFactory {

    @Composable
    fun Screen(
        screen: WgcWellhubScreen,
        modifier: Modifier = Modifier,
        user: WellhubUserProfile = WellhubMockData.mockUser,
        gyms: List<WellhubGym> = WellhubMockData.mockGyms,
        plans: List<WellhubPlan> = WellhubMockData.mockPlans,
        wellnessApps: List<WellhubWellnessApp> = WellhubMockData.mockWellnessApps,
        currentCheckIn: WellhubCheckIn = WellhubMockData.mockUser.todayCheckIn!!,
        selectedFilterIndex: Int = 0,
        onNavigateScreen: ((WgcWellhubScreen) -> Unit)? = null,
        onSelectFilter: (Int) -> Unit = {},
        onSelectGym: ((WellhubGym) -> Unit)? = null,
        onSelectPlan: ((WellhubPlan) -> Unit)? = null,
        onToggleActivateApp: ((appId: String, activate: Boolean) -> Unit)? = null,
        slotHeader: (@Composable () -> Unit)? = null,
        slotBottomNav: (@Composable () -> Unit)? = null
    ) {
        when (screen) {
            WgcWellhubScreen.Home -> {
                WgcWellhubHomeTemplate(
                    user = user,
                    nearbyGyms = gyms,
                    modifier = modifier,
                    onOpenExplore = { onNavigateScreen?.invoke(WgcWellhubScreen.Explore) },
                    onOpenCheckIn = { onNavigateScreen?.invoke(WgcWellhubScreen.CheckIn) },
                    onOpenPlans = { onNavigateScreen?.invoke(WgcWellhubScreen.Plans) },
                    onOpenWellness = { onNavigateScreen?.invoke(WgcWellhubScreen.Wellness) },
                    onSelectGym = onSelectGym,
                    selectedNavItem = WgcWellhubNavItem.HOME,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcWellhubNavItem.HOME -> onNavigateScreen?.invoke(WgcWellhubScreen.Home)
                            WgcWellhubNavItem.EXPLORE -> onNavigateScreen?.invoke(WgcWellhubScreen.Explore)
                            WgcWellhubNavItem.CHECKIN -> onNavigateScreen?.invoke(WgcWellhubScreen.CheckIn)
                            WgcWellhubNavItem.WELLNESS -> onNavigateScreen?.invoke(WgcWellhubScreen.Wellness)
                            WgcWellhubNavItem.PROFILE -> onNavigateScreen?.invoke(WgcWellhubScreen.Plans)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcWellhubScreen.Explore -> {
                WgcWellhubExploreGymsTemplate(
                    gyms = gyms,
                    selectedFilterIndex = selectedFilterIndex,
                    onSelectFilter = onSelectFilter,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcWellhubScreen.Home) },
                    onSelectGym = onSelectGym,
                    onCheckInGym = { onNavigateScreen?.invoke(WgcWellhubScreen.CheckIn) },
                    selectedNavItem = WgcWellhubNavItem.EXPLORE,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcWellhubNavItem.HOME -> onNavigateScreen?.invoke(WgcWellhubScreen.Home)
                            WgcWellhubNavItem.EXPLORE -> onNavigateScreen?.invoke(WgcWellhubScreen.Explore)
                            WgcWellhubNavItem.CHECKIN -> onNavigateScreen?.invoke(WgcWellhubScreen.CheckIn)
                            WgcWellhubNavItem.WELLNESS -> onNavigateScreen?.invoke(WgcWellhubScreen.Wellness)
                            WgcWellhubNavItem.PROFILE -> onNavigateScreen?.invoke(WgcWellhubScreen.Plans)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcWellhubScreen.CheckIn -> {
                WgcWellhubCheckInTemplate(
                    user = user,
                    currentCheckIn = currentCheckIn,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcWellhubScreen.Home) },
                    selectedNavItem = WgcWellhubNavItem.CHECKIN,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcWellhubNavItem.HOME -> onNavigateScreen?.invoke(WgcWellhubScreen.Home)
                            WgcWellhubNavItem.EXPLORE -> onNavigateScreen?.invoke(WgcWellhubScreen.Explore)
                            WgcWellhubNavItem.CHECKIN -> onNavigateScreen?.invoke(WgcWellhubScreen.CheckIn)
                            WgcWellhubNavItem.WELLNESS -> onNavigateScreen?.invoke(WgcWellhubScreen.Wellness)
                            WgcWellhubNavItem.PROFILE -> onNavigateScreen?.invoke(WgcWellhubScreen.Plans)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcWellhubScreen.Plans -> {
                WgcWellhubPlansTemplate(
                    plans = plans,
                    currentTier = user.currentTier,
                    modifier = modifier,
                    companyName = user.company,
                    onBackClick = { onNavigateScreen?.invoke(WgcWellhubScreen.Home) },
                    onSelectPlan = onSelectPlan,
                    selectedNavItem = WgcWellhubNavItem.PROFILE,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcWellhubNavItem.HOME -> onNavigateScreen?.invoke(WgcWellhubScreen.Home)
                            WgcWellhubNavItem.EXPLORE -> onNavigateScreen?.invoke(WgcWellhubScreen.Explore)
                            WgcWellhubNavItem.CHECKIN -> onNavigateScreen?.invoke(WgcWellhubScreen.CheckIn)
                            WgcWellhubNavItem.WELLNESS -> onNavigateScreen?.invoke(WgcWellhubScreen.Wellness)
                            WgcWellhubNavItem.PROFILE -> onNavigateScreen?.invoke(WgcWellhubScreen.Plans)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcWellhubScreen.Wellness -> {
                WgcWellhubWellnessAppsTemplate(
                    apps = wellnessApps,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcWellhubScreen.Home) },
                    onToggleActivateApp = onToggleActivateApp,
                    selectedNavItem = WgcWellhubNavItem.WELLNESS,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcWellhubNavItem.HOME -> onNavigateScreen?.invoke(WgcWellhubScreen.Home)
                            WgcWellhubNavItem.EXPLORE -> onNavigateScreen?.invoke(WgcWellhubScreen.Explore)
                            WgcWellhubNavItem.CHECKIN -> onNavigateScreen?.invoke(WgcWellhubScreen.CheckIn)
                            WgcWellhubNavItem.WELLNESS -> onNavigateScreen?.invoke(WgcWellhubScreen.Wellness)
                            WgcWellhubNavItem.PROFILE -> onNavigateScreen?.invoke(WgcWellhubScreen.Plans)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
        }
    }
}
