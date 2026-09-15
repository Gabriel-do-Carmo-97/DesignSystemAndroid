package br.com.wgc.ds_templates.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.components.cards.WgcWellhubPlanTier
import br.com.wgc.ds_templates.factories.WgcWellhubFactory
import br.com.wgc.ds_templates.factories.WgcWellhubScreen
import br.com.wgc.ds_templates.screens.wellhub.checkin.WgcWellhubCheckInTemplate
import br.com.wgc.ds_templates.screens.wellhub.explore.WgcWellhubExploreGymsTemplate
import br.com.wgc.ds_templates.screens.wellhub.home.WgcWellhubHomeTemplate
import br.com.wgc.ds_templates.screens.wellhub.model.WellhubMockData
import br.com.wgc.ds_templates.screens.wellhub.plans.WgcWellhubPlansTemplate
import br.com.wgc.ds_templates.screens.wellhub.wellness.WgcWellhubWellnessAppsTemplate

class WgcWellhubScreenshotsTest {

    @Preview(showBackground = true)
    @Composable
    fun PreviewWellhubHome() {
        WgcWellhubHomeTemplate(
            user = WellhubMockData.mockUser,
            nearbyGyms = WellhubMockData.mockGyms
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewWellhubExploreGyms() {
        WgcWellhubExploreGymsTemplate(
            gyms = WellhubMockData.mockGyms,
            selectedFilterIndex = 0,
            onSelectFilter = {}
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewWellhubCheckIn() {
        WgcWellhubCheckInTemplate(
            user = WellhubMockData.mockUser,
            currentCheckIn = WellhubMockData.mockUser.todayCheckIn!!
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewWellhubPlans() {
        WgcWellhubPlansTemplate(
            plans = WellhubMockData.mockPlans,
            currentTier = WgcWellhubPlanTier.GOLD
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewWellhubWellnessApps() {
        WgcWellhubWellnessAppsTemplate(
            apps = WellhubMockData.mockWellnessApps
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewWellhubFactory() {
        WgcWellhubFactory.Screen(screen = WgcWellhubScreen.Home)
    }
}
