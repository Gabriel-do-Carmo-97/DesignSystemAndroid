package br.com.wgc.design_system.factories.verticals.corporatewellness

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.components.cards.WgcCorporateWellnessPlanTier
import br.com.wgc.design_system.components.navigation.WgcCorporateWellnessNavItem
import br.com.wgc.design_system.factories.verticals.corporatewellness.templates.checkin.WgcCorporateWellnessCheckInTemplate
import br.com.wgc.design_system.factories.verticals.corporatewellness.templates.explore.WgcCorporateWellnessExploreGymsTemplate
import br.com.wgc.design_system.factories.verticals.corporatewellness.templates.home.WgcCorporateWellnessHomeTemplate
import br.com.wgc.design_system.factories.verticals.corporatewellness.templates.model.CorporateWellnessCheckIn
import br.com.wgc.design_system.factories.verticals.corporatewellness.templates.model.CorporateWellnessGym
import br.com.wgc.design_system.factories.verticals.corporatewellness.templates.model.CorporateWellnessMockData
import br.com.wgc.design_system.factories.verticals.corporatewellness.templates.model.CorporateWellnessPlan
import br.com.wgc.design_system.factories.verticals.corporatewellness.templates.model.CorporateWellnessUserProfile
import br.com.wgc.design_system.factories.verticals.corporatewellness.templates.model.CorporateWellnessWellnessApp
import br.com.wgc.design_system.factories.verticals.corporatewellness.templates.plans.WgcCorporateWellnessPlansTemplate
import br.com.wgc.design_system.factories.verticals.corporatewellness.templates.wellness.WgcCorporateWellnessWellnessAppsTemplate

/**
 * Variantes de Telas suportadas pela FÃ¡brica Corporate Wellness (Wellness Network).
 */
enum class WgcCorporateWellnessScreen {
    Home,
    Explore,
    CheckIn,
    Plans,
    Wellness
}

/**
 * FÃ¡brica Universal do ecossistema Corporate Wellness / Wellness Network (WgcCorporateWellnessFactory).
 *
 * Fornece ponto de entrada Ãºnico para inicializaÃ§Ã£o de qualquer tela Corporate Wellness
 * com Sensible Defaults prontos para produÃ§Ã£o e slots de substituiÃ§Ã£o granular.
 *
 * Em conformidade com a Regra 6 do AGENTS.md.
 */
object WgcCorporateWellnessFactory {

    @Composable
    fun Screen(
        screen: WgcCorporateWellnessScreen,
        modifier: Modifier = Modifier,
        user: CorporateWellnessUserProfile = CorporateWellnessMockData.mockUser,
        gyms: List<CorporateWellnessGym> = CorporateWellnessMockData.mockGyms,
        plans: List<CorporateWellnessPlan> = CorporateWellnessMockData.mockPlans,
        wellnessApps: List<CorporateWellnessWellnessApp> = CorporateWellnessMockData.mockWellnessApps,
        currentCheckIn: CorporateWellnessCheckIn = CorporateWellnessMockData.mockUser.todayCheckIn!!,
        selectedFilterIndex: Int = 0,
        onNavigateScreen: ((WgcCorporateWellnessScreen) -> Unit)? = null,
        onSelectFilter: (Int) -> Unit = {},
        onSelectGym: ((CorporateWellnessGym) -> Unit)? = null,
        onSelectPlan: ((CorporateWellnessPlan) -> Unit)? = null,
        onToggleActivateApp: ((appId: String, activate: Boolean) -> Unit)? = null,
        slotHeader: (@Composable () -> Unit)? = null,
        slotBottomNav: (@Composable () -> Unit)? = null
    ) {
        when (screen) {
            WgcCorporateWellnessScreen.Home -> {
                WgcCorporateWellnessHomeTemplate(
                    user = user,
                    nearbyGyms = gyms,
                    modifier = modifier,
                    onOpenExplore = { onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Explore) },
                    onOpenCheckIn = { onNavigateScreen?.invoke(WgcCorporateWellnessScreen.CheckIn) },
                    onOpenPlans = { onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Plans) },
                    onOpenWellness = { onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Wellness) },
                    onSelectGym = onSelectGym,
                    selectedNavItem = WgcCorporateWellnessNavItem.HOME,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcCorporateWellnessNavItem.HOME -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Home)
                            WgcCorporateWellnessNavItem.EXPLORE -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Explore)
                            WgcCorporateWellnessNavItem.CHECKIN -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.CheckIn)
                            WgcCorporateWellnessNavItem.WELLNESS -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Wellness)
                            WgcCorporateWellnessNavItem.PROFILE -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Plans)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcCorporateWellnessScreen.Explore -> {
                WgcCorporateWellnessExploreGymsTemplate(
                    gyms = gyms,
                    selectedFilterIndex = selectedFilterIndex,
                    onSelectFilter = onSelectFilter,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Home) },
                    onSelectGym = onSelectGym,
                    onCheckInGym = { onNavigateScreen?.invoke(WgcCorporateWellnessScreen.CheckIn) },
                    selectedNavItem = WgcCorporateWellnessNavItem.EXPLORE,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcCorporateWellnessNavItem.HOME -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Home)
                            WgcCorporateWellnessNavItem.EXPLORE -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Explore)
                            WgcCorporateWellnessNavItem.CHECKIN -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.CheckIn)
                            WgcCorporateWellnessNavItem.WELLNESS -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Wellness)
                            WgcCorporateWellnessNavItem.PROFILE -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Plans)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcCorporateWellnessScreen.CheckIn -> {
                WgcCorporateWellnessCheckInTemplate(
                    user = user,
                    currentCheckIn = currentCheckIn,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Home) },
                    selectedNavItem = WgcCorporateWellnessNavItem.CHECKIN,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcCorporateWellnessNavItem.HOME -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Home)
                            WgcCorporateWellnessNavItem.EXPLORE -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Explore)
                            WgcCorporateWellnessNavItem.CHECKIN -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.CheckIn)
                            WgcCorporateWellnessNavItem.WELLNESS -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Wellness)
                            WgcCorporateWellnessNavItem.PROFILE -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Plans)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcCorporateWellnessScreen.Plans -> {
                WgcCorporateWellnessPlansTemplate(
                    plans = plans,
                    currentTier = user.currentTier,
                    modifier = modifier,
                    companyName = user.company,
                    onBackClick = { onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Home) },
                    onSelectPlan = onSelectPlan,
                    selectedNavItem = WgcCorporateWellnessNavItem.PROFILE,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcCorporateWellnessNavItem.HOME -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Home)
                            WgcCorporateWellnessNavItem.EXPLORE -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Explore)
                            WgcCorporateWellnessNavItem.CHECKIN -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.CheckIn)
                            WgcCorporateWellnessNavItem.WELLNESS -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Wellness)
                            WgcCorporateWellnessNavItem.PROFILE -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Plans)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
            WgcCorporateWellnessScreen.Wellness -> {
                WgcCorporateWellnessWellnessAppsTemplate(
                    apps = wellnessApps,
                    modifier = modifier,
                    onBackClick = { onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Home) },
                    onToggleActivateApp = onToggleActivateApp,
                    selectedNavItem = WgcCorporateWellnessNavItem.WELLNESS,
                    onNavItemClick = { item ->
                        when (item) {
                            WgcCorporateWellnessNavItem.HOME -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Home)
                            WgcCorporateWellnessNavItem.EXPLORE -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Explore)
                            WgcCorporateWellnessNavItem.CHECKIN -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.CheckIn)
                            WgcCorporateWellnessNavItem.WELLNESS -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Wellness)
                            WgcCorporateWellnessNavItem.PROFILE -> onNavigateScreen?.invoke(WgcCorporateWellnessScreen.Plans)
                        }
                    },
                    slotHeader = slotHeader,
                    slotBottomNav = slotBottomNav
                )
            }
        }
    }
}
